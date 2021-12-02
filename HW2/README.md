- You can create database by running ```java -jar derbyrun.jar server start``` command

- Open Postman application and there you will be able to perform RESTful services

- Adding -> Select POST function and http://localhost:8080/shop with body ```{
  "name": "shop - 10",
  "address": "address - 10"
  }```

- Deleting -> Select DELETE function and http://localhost:8080/shop/1 and after shop write the id number of shop that you want to delete

- GET -> Select GET function and ```http://localhost:8080/shop```. This will show all available shops.
