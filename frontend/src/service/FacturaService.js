import axios from 'axios';


export default class FacturaService {

    url = "http://localhost:8080/facturas/";

    getAll() {
        return axios.get(this.url + "all");
    }
    save(factura) {
        return axios.post(this.url + "save", factura)
    }
    delete(id) {
        return axios.get(this.url + "delete/" + id)
    }
}