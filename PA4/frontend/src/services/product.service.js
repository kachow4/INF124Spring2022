// generates the backend
import http from "../http-common";

class ProductDataService {
  getAll() {
    return http.get("/products");
  }

  get(id) {
    return http.get(`/products/${id}`);
  }

  create(data) {
    return http.post("/products", data);
  }

  update(id, data) {
    return http.put(`/products/${id}`, data);
  }

  delete(id) {
    return http.delete(`/products/${id}`);
  }

  deleteAll() {
    return http.delete(`/products`);
  }

  // sending a name to database (controllers file), add to the url
  findByName(name) {
    return http.get(`/products?name=${name}`);
  }

  findByBrand(brand) {
    return http.get(`/products?brand=${brand}`);
  }

  findByPrice(price) {
    return http.get(`/products?price=${price}`);
  }
}

export default new ProductDataService();