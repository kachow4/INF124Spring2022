// main code, includes express in your code
const express = require("express");
const bodyParser = require("body-parser");

// running react on one server and react on the other, so you have 2 different addresses (8080 and 8081)
const cors = require("cors");

// initialize express (get all functions and properties)
const app = express();

var corsOptions = {
  origin: "http://localhost:8081"
};

app.use(cors(corsOptions));

// parse requests of content-type - application/json
app.use(bodyParser.json());

// parse requests of content-type - application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: true }));

// where the code starts, include models
const db = require("./app/models");

// connection stuff
db.sequelize.sync();
// // drop the table if it already exists
// db.sequelize.sync({ force: true }).then(() => {
//   console.log("Drop and re-sync db.");
// });

// simple route, "/" routes to homepage, the function is what happens at the specified route 
// app.get("/", (req, res) => {
//   res.json({ message: "Welcome to bezkoder application." });
// });

// routes to a file that shows all routes in the application
require("./app/routes/tutorial.routes")(app);
require("./app/routes/product.routes")(app);

// set port, listen for requests
const PORT = process.env.PORT || 8080;

// start the server
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}.`);
});
