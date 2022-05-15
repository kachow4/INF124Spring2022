Team Members: Katie Chow, Huan Quang Nguyen, Katie Chow

Site Navigation:
- There are 8 pages in total: Home, Products, Product Details, Successfully Added to Cart, Team, Cart/Checkout, Order Details, and an extra page for if the cart is empty and an order is submitted.

- there are 4 tabs in the navigation bar: Home, Products, Team, and Cart (all pages should include the top nav bar for easy navigation access)

Home Page --> The user will land on the homepage when starting the deployment on Tomcat. This is merely a landing page for users to enter the site. Using the top nav bar allows the user to exit this page.

Products Page --> This page hosts the items offered on our site. Under the nav bar is where the 5 most recently ordered products appear using the include function. The page is vertically scrollable and hovering over an item will zoom in on the product. Clicking on an item will take the user to that item's detailed page which will have more info on the product selected. (Requirement 1)

Product Details Page --> This page includes more pictures in bigger screen sizes and has a description of what the product is. Within this page is an "Add to Cart" button which will add the item to the user's cart for ordering. When clicking on this button, the user will be navigated to a success page, letting them know the product was added to the cart. (Requirement 2)

Successfully Added to Cart --> This page is merely a message page to inform/update the user that an item was added to their cart. There is a button on this page to navigate back to the products page.

Team Page --> This page hosts a description of the site and a short biography section for our 3 team members. 

Cart/Checkout --> This page shows all the products currently in the user's cart. Under the list of products is a form that allows users to checkout their cart. This form includes all the requirements for validation so that no errors will occur when entering data into the database. Clicking on the "Submit Order" button will either forward() the user to the Order Details page or the "Your Cart is Empty" Page. (Requirement 3 and 4)

Order Details --> This page shows all the order details that the user filled out on the form in the Cart/Checkout page. It also shows all the items that the user ordered. There is a button to allow the user to navigate back to the homepage. (Requirement 4)

Empty Cart Page --> This page is merely a message page that tells the user they can't submit an order because their cart is empty. There is a button to allow the user to return back to the products page.