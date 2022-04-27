package demofacturas.controller;

import demofacturas.persistence.entity.Factura;
import demofacturas.service.CrudStatus;
import demofacturas.service.FacturaService;
import demofacturas.service.dto.FacturaInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/facturas")
public class FacturaController {
    private final FacturaService factService;

    public FacturaController(FacturaService factService) {
        this.factService = factService;
    }

    @PostMapping(value = "/save", consumes = "application/json")
    public Factura createFactura(@RequestBody FacturaInDTO factInDTO) {
        return this.factService.saveChanges(factInDTO);
    }

    @GetMapping(value = "/all")
    public List<Factura> findAll(){
        return this.factService.getAll();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        CrudStatus status = this.factService.delete(id);
        if (status == CrudStatus.Ok){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
