import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";

import App from "./App";
import * as serviceWorker from "./serviceWorker";

//takes 2 arguments (html code to be rednered, html element where html code will be displayed)
ReactDOM.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>, //first arg
  document.getElementById("root") //second arg
);

serviceWorker.unregister();
