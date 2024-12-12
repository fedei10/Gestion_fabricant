# Mini Project Spring Boot Application

This is a Spring Boot application for managing articles, purchases, and clients. The application provides RESTful APIs to perform CRUD operations on articles, purchases, and clients, as well as additional functionalities like counting total fabricants and retrieving articles by various criteria.

## Technologies Used

- Java
- Spring Boot
- Maven
- JPA (Java Persistence API)
- H2 Database (for development and testing)
- Postman (for API testing)

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/your-repo-name.git
    cd your-repo-name
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

### Running Tests

To run the tests, use the following command:
```sh
mvn test

API Endpoints
Article Endpoints
Get All Articles  
GET /api/articles
Get Article by ID  
GET /api/articles/{id}
Create Article  
POST /api/articles
Delete Article  
DELETE /api/articles/{id}
Update Article  
PUT /api/articles/{id}
Get Articles by Price Range
GET /api/articles/price-range?minPrice={minPrice}&maxPrice={maxPrice}
Get Articles by Stock  
GET /api/articles/stock?stock={stock}
Get Articles by Name  
GET /api/articles/name?nom={nom}
Get Most Purchased Articles by Fabricant  
GET /api/articles/most-purchased/{fabricantId}
Purchase Endpoints
Get All Purchases
GET /restapi/purchases
Get Purchase by ID  
GET /restapi/purchases/{id}
Create Purchase  
POST /restapi/purchases
Delete Purchase  
DELETE /restapi/purchases/{id}
Update Purchase  
PUT /restapi/purchases/{id}
Get Purchases by Client  
GET /restapi/purchases/client/{clientId}
Count Purchases by Client  
GET /restapi/purchases/count/{clientId}
Get Total Revenue
GET /restapi/purchases/revenue
Get Total Revenue by Client ID  
GET /restapi/purchases/purchase/{clientId}
Fabricant Endpoints
Count Total Fabricants
GET /api/fabricants/count
License
This project is licensed under the MIT License. See the LICENSE file for details.  
Acknowledgements
Spring Boot Documentation
H2 Database Documentation
Postman Documentation









