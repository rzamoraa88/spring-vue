<template>
  <div style="margin: 0 auto; width: 80%">
    <Toast/>
    <Panel header="FACTURAS APP">
      <Menubar :model="items" />
      <br />
      <DataTable :value="facturas" :paginator="true" :rows="10" selectionMode="single" :selection.sync="selectedFactura" dataKey="id">
        <Column field="id" header="ID"></Column>
        <Column field="codigo" header="Código"></Column>
        <Column field="nif" header="NIF Destinatario"></Column>
        <Column field="numeroProductos" header="Numero Productos"></Column>
        <Column field="importe" header="Importe"></Column>
        <Column field="importeConIva" header="Importe IVA"></Column>
      </DataTable>
    </Panel>
    <Dialog header="Crear Factura" :visible.sync="displayModal" :modal="true">
      <span class="p-float-label">
        <InputText id="codigo" type="text" v-model="factura.codigo" style="width: 100%" />
        <label for="codigo">Codigo</label>
      </span>
      <br />
      <span class="p-float-label">
        <InputText id="nif" type="text" v-model="factura.nif" style="width: 100%" />
        <label for="nif">Destinatario</label>
      </span>
      <br />
      <span>
        <select v-model="factura.productos" multiple>
          <option v-for="(prod, index) in productos" :key="index" v-bind:value="prod">
            {{ prod.descripcion }}
          </option>
        </select>
        <span>Productos: {{ factura.productos }}</span>
      </span>
      <template #footer>
        <Button label="Guardar" icon="pi pi-check" @click="save" />
        <Button label="Cancelar" icon="pi pi-times" @click="closeModal" class="p-button-secondary" />
      </template>
    </Dialog>
  </div>
</template>

<script>
import FacturaService from "../service/FacturaService";
import ProductoService from "../service/ProductoService";
export default {
  name: "FacturasApp",
  data() {
    return {
      facturas: null,
      factura: {
        id: 0,
        codigo: null,
        nif: null,
        productos: []
      },
      selectedFactura: {
        id: 0,
        codigo: null,
        nif: null,
        productos: []
      },
		productos: [],
      items: [
        {
          label: "Nuevo",
          icon: "pi pi-fw pi-plus",
          command: () => {
            this.showSaveModal();
          }
        },
        {
          label: "Editar",
          icon: "pi pi-fw pi-pencil",
          command: () => {
            this.showEditModal();
          }
        },
        {
          label: "Eliminar",
          icon: "pi pi-fw pi-trash",
          command: () => {
            this.delete();
          }
        },
        {
          label: "Refrescar",
          icon: "pi pi-fw pi-refresh",
          command: () => {
            this.getAll();
          }
        }
      ],
      displayModal: false
    };
  },
  facturaService: null,
  productoService: null,
  created() {
    this.facturaService = new FacturaService();
    this.productoService = new ProductoService();
  },
  mounted() {
    this.getAll();
    this.getProductos();
  },
  methods: {
    showSaveModal() {
      this.factura.id = this.facturas.length + 1;
      this.displayModal = true;
    },
    showEditModal() {
      this.factura = this.selectedFactura;
      this.displayModal = true;
    },
    getAll() {
      this.facturaService.getAll().then(data => {
        console.log(data);
        this.facturas = data.data;
      });
    },
    getProductos() {
      this.productoService.getAll().then(data => {
        console.log(data);
        this.productos = data.data;
      });
    },
    delete() {
      this.facturaService.delete(this.selectedFactura.id).then(data => {
        if (data.status === 200) {
          this.$toast.add({severity:'success', summary: 'Atención!', detail: 'Se eliminó el registro correctamente', life: 3000});
          this.getAll();
        }
      });
    },
    save() {
      this.facturaService.save(this.factura).then(data => {
        if (data.status === 200) {
          this.displayModal = false;
          this.factura = {
            codigo: null,
            nif: null,
            productos: []
          };
          this.getAll();
        }
      });
    },
    closeModal() {
      this.displayModal = false;
    }
  }
};
</script>

<style>
</style>