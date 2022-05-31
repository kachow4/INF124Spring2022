import React, { Component } from "react";
import ProductDataService from "../services/product.service";
import { Link } from "react-router-dom";

export default class ProductsList extends Component {
  constructor(props) {
    super(props);
    this.onChangeSearchName = this.onChangeSearchName.bind(this);
    this.retrieveProducts = this.retrieveProducts.bind(this);
    this.refreshList = this.refreshList.bind(this);
    this.setActiveProduct = this.setActiveProduct.bind(this);
    this.removeAllProducts = this.removeAllProducts.bind(this);
    this.searchName = this.searchName.bind(this);

    // state variable initialization
    this.state = {
      products: [],
      currentProduct: null,
      currentIndex: -1,
      searchName: ""
    };
  }

  componentDidMount() {
    this.retrieveProducts();
  }


  onChangeSearchName(e) {
    //get the value from the target (the search bar)
    const searchName = e.target.value;

    // change the value in the target (the search bar)
    this.setState({
      searchName: searchName
    });
  }

  retrieveProducts() {
    ProductDataService.getAll()
      .then(response => {
        this.setState({
          products: response.data
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  refreshList() {
    this.retrieveProducts();
    this.setState({
      currentProduct: null,
      currentIndex: -1
    });
  }

  setActiveProduct(product, index) {
    this.setState({
      currentProduct: product,
      currentIndex: index
    });
  }

  removeAllProducts() {
    ProductDataService.deleteAll()
      .then(response => {
        console.log(response.data);
        this.refreshList();
      })
      .catch(e => {
        console.log(e);
      });
  }

  searchName() {
    // set state to initial values
    this.setState({
      currentProduct: null,
      currentIndex: -1
    });

    let tempName;
    let tempBrand;

    // links to product.service.js --> searches by name first, checks for if the return is NULL
    ProductDataService.findByName(this.state.searchName)
    //products variable is filled with the response data from the backend/database
      .then(response => {
        //this.setState({
          //products: response.data
        //});
        // try setting the state later
        tempName = response.data;
        console.log("Product Service Return Name search: ", response.data);
      })
      .catch(e => {
        console.log(e);
      });

    if (tempName === null) {
      ProductDataService.findByBrand(this.state.searchName)
        .then(response => {
          tempBrand = response.data;
          console.log("Product Service Return Brand search: ", response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
    else {
      this.setState({
        products: tempName
      });
    }

    if (tempName === null && tempBrand === null) {
      ProductDataService.findByPrice(this.state.searchName)
        .then(response => {
          this.setState({
            products: response.data
          })
        })
        .catch(e => {
          console.log(e);
        });
    }
    else if (tempName === null && tempBrand !== null) {
      this.setState({
        products: tempBrand
      });
    }
  }

//   render/execute the components to show on screen
  render() {
    const { searchName, products, currentProduct, currentIndex } = this.state;

    return (
      <div className="list row">
        {/* SEARCH BAR */}
        <div className="col-md-8">
          <div className="input-group mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Search by name"
              value={searchName} // this will be changed after the onChange function is called
              onChange={this.onChangeSearchName} //changing the text in the search bar
            />
            <div className="input-group-append">
              <button
                className="btn btn-outline-secondary"
                type="button"
                onClick={this.searchName} //call searchName()
              >
                Search
              </button>
            </div>
          </div>
        </div>
        <div className="col-md-6">
          <h4>Products List</h4>

          <ul className="list-group">
            {/* for loop that prints out all the data from the products variable */}
            {products &&
              products.map((product, index) => (
                <li
                  className={
                    "list-group-item " +
                    (index === currentIndex ? "active" : "")
                  }
                  onClick={() => this.setActiveProduct(product, index)}
                  key={index}
                >
                  {product.name}
                </li>
              ))}
          </ul>

          <button
            className="m-3 btn btn-sm btn-danger"
            onClick={this.removeAllProducts}
          >
            Remove All
          </button>
        </div>
        <div className="col-md-6">
          {currentProduct ? (
            <div>
              <h4>Product</h4>
              <div>
                <label>
                  <strong>Name:</strong>
                </label>{" "}
                {currentProduct.name}
              </div>
              <div>
                <label>
                  <strong>Brand:</strong>
                </label>{" "}
                {currentProduct.brand}
              </div> <div>
                <label>
                  <strong>Price:</strong>
                </label>{" "}
                {currentProduct.price}
              </div>
              <div>
                <label>
                  <strong>Description:</strong>
                </label>{" "}
                {currentProduct.description}
              </div>
              <div>
                <label>
                  <strong>Status:</strong>
                </label>{" "}
                {currentProduct.published ? "Published" : "Pending"}
              </div>

              <Link
                to={"/products/" + currentProduct.id}
                className="badge badge-warning"
              >
                Edit
              </Link>
            </div>
          ) : (
            <div>
              <br />
              <p>Please click on a Product...</p>
            </div>
          )}
        </div>
      </div>
    );
  }
}
