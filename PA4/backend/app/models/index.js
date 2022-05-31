// credentials for database
const dbConfig = require("../config/db.config.js");

// allow us to easily contact the database
const Sequelize = require("sequelize");
// syntax to connect to database
const sequelize = new Sequelize(dbConfig.DB, dbConfig.USER, dbConfig.PASSWORD, {
  host: dbConfig.HOST,
  dialect: dbConfig.dialect,
  operatorsAliases: false,

  pool: {
    max: dbConfig.pool.max,
    min: dbConfig.pool.min,
    acquire: dbConfig.pool.acquire,
    idle: dbConfig.pool.idle
  }
});

const db = {};

db.Sequelize = Sequelize;
db.sequelize = sequelize;

// getting database table
db.tutorials = require("./tutorial.model.js")(sequelize, Sequelize);
db.products = require("./product.model.js")(sequelize, Sequelize);

// save the database
module.exports = db;
