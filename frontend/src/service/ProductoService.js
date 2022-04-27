import axios from 'axios';


export default class ProductoService {

    url = "http://localhost:8080/productos/";

    getAll() {
        return axios.get(this.url + "all");
    }
}