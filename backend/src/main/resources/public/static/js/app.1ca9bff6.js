(function(){"use strict";var t={4269:function(t,e,a){var o=a(8935),r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"app"}},[a("FacturasApp")],1)},n=[],l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{margin:"0 auto",width:"80%"}},[a("Toast"),a("Panel",{attrs:{header:"FACTURAS APP"}},[a("Menubar",{attrs:{model:t.items}}),a("br"),a("DataTable",{attrs:{value:t.facturas,paginator:!0,rows:10,selectionMode:"single",selection:t.selectedFactura,dataKey:"id"},on:{"update:selection":function(e){t.selectedFactura=e}}},[a("Column",{attrs:{field:"id",header:"ID"}}),a("Column",{attrs:{field:"codigo",header:"Código"}}),a("Column",{attrs:{field:"nif",header:"NIF Destinatario"}}),a("Column",{attrs:{field:"numeroProductos",header:"Numero Productos"}}),a("Column",{attrs:{field:"importe",header:"Importe"}}),a("Column",{attrs:{field:"importeConIva",header:"Importe IVA"}})],1)],1),a("Dialog",{attrs:{header:"Crear Factura",visible:t.displayModal,modal:!0},on:{"update:visible":function(e){t.displayModal=e}},scopedSlots:t._u([{key:"footer",fn:function(){return[a("Button",{attrs:{label:"Guardar",icon:"pi pi-check"},on:{click:t.save}}),a("Button",{staticClass:"p-button-secondary",attrs:{label:"Cancelar",icon:"pi pi-times"},on:{click:t.closeModal}})]},proxy:!0}])},[a("span",{staticClass:"p-float-label"},[a("InputText",{staticStyle:{width:"100%"},attrs:{id:"codigo",type:"text"},model:{value:t.factura.codigo,callback:function(e){t.$set(t.factura,"codigo",e)},expression:"factura.codigo"}}),a("label",{attrs:{for:"codigo"}},[t._v("Codigo")])],1),a("br"),a("span",{staticClass:"p-float-label"},[a("InputText",{staticStyle:{width:"100%"},attrs:{id:"nif",type:"text"},model:{value:t.factura.nif,callback:function(e){t.$set(t.factura,"nif",e)},expression:"factura.nif"}}),a("label",{attrs:{for:"nif"}},[t._v("Destinatario")])],1),a("br"),a("span",[a("select",{directives:[{name:"model",rawName:"v-model",value:t.factura.productos,expression:"factura.productos"}],attrs:{multiple:""},on:{change:function(e){var a=Array.prototype.filter.call(e.target.options,(function(t){return t.selected})).map((function(t){var e="_value"in t?t._value:t.value;return e}));t.$set(t.factura,"productos",e.target.multiple?a:a[0])}}},t._l(t.productos,(function(e,o){return a("option",{key:o,domProps:{value:e}},[t._v(" "+t._s(e.descripcion)+" ")])})),0),a("span",[t._v("Productos: "+t._s(t.factura.productos))])])])],1)},i=[],u=a(3796),s=a(6166),c=a.n(s);class d{constructor(){(0,u.Z)(this,"url","http://localhost:8080/facturas/")}getAll(){return c().get(this.url+"all")}save(t){return c().post(this.url+"save",t)}delete(t){return c().get(this.url+"delete/"+t)}}class f{constructor(){(0,u.Z)(this,"url","http://localhost:8080/productos/")}getAll(){return c().get(this.url+"all")}}var p={name:"FacturasApp",data(){return{facturas:null,factura:{id:0,codigo:null,nif:null,productos:[]},selectedFactura:{id:0,codigo:null,nif:null,productos:[]},productos:[],items:[{label:"Nuevo",icon:"pi pi-fw pi-plus",command:()=>{this.showSaveModal()}},{label:"Editar",icon:"pi pi-fw pi-pencil",command:()=>{this.showEditModal()}},{label:"Eliminar",icon:"pi pi-fw pi-trash",command:()=>{this.delete()}},{label:"Refrescar",icon:"pi pi-fw pi-refresh",command:()=>{this.getAll()}}],displayModal:!1}},facturaService:null,productoService:null,created(){this.facturaService=new d,this.productoService=new f},mounted(){this.getAll(),this.getProductos()},methods:{showSaveModal(){this.factura.id=this.facturas.length+1,this.displayModal=!0},showEditModal(){this.factura=this.selectedFactura,this.displayModal=!0},getAll(){this.facturaService.getAll().then((t=>{console.log(t),this.facturas=t.data}))},getProductos(){this.productoService.getAll().then((t=>{console.log(t),this.productos=t.data}))},delete(){this.facturaService.delete(this.selectedFactura.id).then((t=>{200===t.status&&(this.$toast.add({severity:"success",summary:"Atención!",detail:"Se eliminó el registro correctamente",life:3e3}),this.getAll())}))},save(){this.facturaService.save(this.factura).then((t=>{200===t.status&&(this.displayModal=!1,this.factura={codigo:null,nif:null,productos:[]},this.getAll())}))},closeModal(){this.displayModal=!1}}},h=p,m=a(1001),v=(0,m.Z)(h,l,i,!1,null,null,null),g=v.exports,b={name:"App",components:{FacturasApp:g}},y=b,w=(0,m.Z)(y,r,n,!1,null,null,null),S=w.exports,M=a(2565),A=a(8649),C=a(8138),_=a(7180),x=a(7182),P=a(9532),O=a(3559),T=a(8101),k=a(1105),F=a(2013);o["default"].config.productionTip=!1,o["default"].component("DataTable",M["default"]),o["default"].component("Column",A["default"]),o["default"].component("Panel",C["default"]),o["default"].component("Menubar",_["default"]),o["default"].component("Dialog",x["default"]),o["default"].component("InputText",P["default"]),o["default"].component("Button",O["default"]),o["default"].component("MultiSelect",T["default"]),o["default"].component("Toast",F["default"]),o["default"].use(k["default"]),new o["default"]({render:t=>t(S)}).$mount("#app")}},e={};function a(o){var r=e[o];if(void 0!==r)return r.exports;var n=e[o]={exports:{}};return t[o](n,n.exports,a),n.exports}a.m=t,function(){var t=[];a.O=function(e,o,r,n){if(!o){var l=1/0;for(c=0;c<t.length;c++){o=t[c][0],r=t[c][1],n=t[c][2];for(var i=!0,u=0;u<o.length;u++)(!1&n||l>=n)&&Object.keys(a.O).every((function(t){return a.O[t](o[u])}))?o.splice(u--,1):(i=!1,n<l&&(l=n));if(i){t.splice(c--,1);var s=r();void 0!==s&&(e=s)}}return e}n=n||0;for(var c=t.length;c>0&&t[c-1][2]>n;c--)t[c]=t[c-1];t[c]=[o,r,n]}}(),function(){a.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return a.d(e,{a:e}),e}}(),function(){a.d=function(t,e){for(var o in e)a.o(e,o)&&!a.o(t,o)&&Object.defineProperty(t,o,{enumerable:!0,get:e[o]})}}(),function(){a.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(t){if("object"===typeof window)return window}}()}(),function(){a.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)}}(),function(){a.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})}}(),function(){var t={143:0};a.O.j=function(e){return 0===t[e]};var e=function(e,o){var r,n,l=o[0],i=o[1],u=o[2],s=0;if(l.some((function(e){return 0!==t[e]}))){for(r in i)a.o(i,r)&&(a.m[r]=i[r]);if(u)var c=u(a)}for(e&&e(o);s<l.length;s++)n=l[s],a.o(t,n)&&t[n]&&t[n][0](),t[n]=0;return a.O(c)},o=self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[];o.forEach(e.bind(null,0)),o.push=e.bind(null,o.push.bind(o))}();var o=a.O(void 0,[998],(function(){return a(4269)}));o=a.O(o)})();
//# sourceMappingURL=app.1ca9bff6.js.map