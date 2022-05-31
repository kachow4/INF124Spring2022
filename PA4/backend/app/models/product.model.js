// create products table
module.exports = (sequelize, Sequelize) => {
    const Product = sequelize.define("product", {
        name: {
        type: Sequelize.STRING
      },
      brand: {
        type: Sequelize.STRING
      },
      price: {
        type: Sequelize.DOUBLE
      },
      description: {
        type: Sequelize.STRING
      },
      published: {
        type: Sequelize.BOOLEAN
      }
    });
  
    return Product;
  };
  