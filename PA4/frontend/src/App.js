import React, { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AddTutorial from "./components/add-tutorial.component";
import Tutorial from "./components/tutorial.component";
import TutorialsList from "./components/tutorials-list.component";

import AddProduct from "./components/add-product.component";
import Product from "./components/product.component";
import ProductsList from "./components/products-list.component";

class App extends Component {
  render() {
    return (
      <div>
        {/* NAVIGATION BAR */}
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          
          {/* HOME LOGO (links to tutorials) */}
          {/* <Link to={"/tutorials"} className="navbar-brand">
            MyApp
          </Link> */}
        <Link to={"/products"} className="navbar-brand">
            MyApp
          </Link>

          {/* NAVIGATION TABS */}
          <div className="navbar-nav mr-auto">

            {/* TUTORIALS TAB */}
            {/* <li className="nav-item">
              <Link to={"/tutorials"} className="nav-link">
                Tutorials
              </Link>
            </li> */}

            {/* ADD TUTORIAL TAB */}
            {/* <li className="nav-item">
              <Link to={"/add-tutorial"} className="nav-link">
                Add Tutorial
              </Link>
            </li> */}

            {/* PRODUCTS TAB */}
            <li className="nav-item">
              <Link to={"/products"} className="nav-link">
                Products
              </Link>
            </li>

             {/* ADD PRODUCT TAB */}
             <li className="nav-item">
              <Link to={"/add-product"} className="nav-link">
                Add Product
              </Link>
            </li>
          </div>
        </nav>

        {/* SWITCHES WHAT APPEARS DEPENDING ON THE TAB YOU'RE ON (and changes the path) */}
        <div className="container mt-3">
          <Switch>
            {/* <Route exact path={["/", "/tutorials"]} component={TutorialsList} />
            <Route exact path="/add-tutorial" component={AddTutorial} />
            <Route path="/tutorials/:id" component={Tutorial} /> */}

            <Route exact path={["/", "/products"]} component={ProductsList} />
            <Route exact path="/add-product" component={AddProduct} />
            <Route path="/products/:id" component={Product} />

          </Switch>
        </div>
      </div>
    );
  }
}

export default App;
