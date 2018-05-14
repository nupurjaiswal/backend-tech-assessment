# Intuit Assignment

 -  Exercise Difficulty: Moderate
 -   How did you feel about the exercise itself?: 7
 -   How do you feel about coding an exercise as a step in the interview process?  10
 -   What would you change in the exercise and/or process? I had a lot of fun working on this exercise. I wouldn't want to change anything about it.
 

## Development

  - Technologies Used: Spring Boot, H2 (embedded database), JPA, Tomcat(embedded)
  - API development: Postman
  
## Implementation

####  NOTE:
Sample sellers and buyers data is generated at the Application startup. Please check the GET /sellers and GET /buyers endpoint. 

### Endpoints:
 - **POST /seller**  
The first step for seller is to add his company name in /seller endpoint. His id will be generated automatically. He will then be able to post project using his unique ID.
```sh
POST http://localhost:8080/sellers
{
  "companyName": "Search Tech"
}
```
The seller will get his unique ID in the response.

 - **POST /project**  
The second step for seller is to post project with the below fields:
```sh
POST http://localhost:8080/projects
{
	"projectName": "Relevancy Tuning",
	"description": "The aim of this project is to optimize the existing search engine results.",
	"maxBudget": 100,
	"deadline": "5-16-2018",
	"sellerId": 1
}
```

 - **POST /buyers**  
For buyer, in order to post a bid, he should first add his name in /buyer endpoint to get his ID. Then only he will be able to bid on projects. 

```sh
POST http://localhost:8080/buyers
{
	"buyerName": "Harry"
}
```

Buyer will get his unique ID in response.   
Buyers can check the existing projects using **GET /projects** endpoint to get the project ID as shown below:  

```sh
GET http://localhost:8080/projects
[
    {
        "id": 12,
        "projectName": "Relevancy Tuning",
        "description": "The aim of this project is to optimize the existing search engine",
        "maxBudget": 100,
        "minBid": "NaN",
        "deadline": "05-16-2018",
        "sellerId": 1,
        "allBids": []
    }
]
```

 - **POST /projects/{projectId}/bids**  
Buyer can post the bid by specifying the project id in the path variable as shown below: 
```sh
POST localhost:8080/projects/12/bids
{
	"buyerId": 9,
	"bid": 90
}
    
```

 - **GET /sellers**  
 This endpoint will return all the sellers with their IDs
```sh
GET http://localhost:8080/sellers
{
[
    {
        "id": 1,
        "companyName": "Intuit"
    },
    {
        "id": 2,
        "companyName": "Apple"
    },
    {
        "id": 3,
        "companyName": "Google"
    }
]
}
    
```
In the same way, **GET /buyers** will return all the buyers with their IDs. You can also get information of a particular seller using endpoint **GET /sellers/{id}** and a particular buyer using endpoint **GET /buyers/{id}**

 - **GET /projects/{id}**  
This endpoint will return a project with the specified ID.
```sh
GET http://localhost:8080/projects/12
{
    "id": 12,
    "projectName": "Relevancy Tuning",
    "description": "The aim of this project is to optimize the existing search engine",
    "maxBudget": 100,
    "minBid": 89,
    "deadline": "05-16-2018",
    "sellerId": 1,
    "allBids": [
        {
            "id": 1,
            "buyerId": 9,
            "bid": 90,
            "projectId": 12
        },
        {
            "id": 2,
            "buyerId": 5,
            "bid": 89,
            "projectId": 12
        }
    ]
}
```
 

## Test Cases:
 - Seller wont't be able to post a project before creating the seller entry in /sellers endpoint.
 - Buyer wont't be able to bid on a project before creating the buyer entry in /buyers endpoint.
 - Seller won't be able to post a project which has deadline in the past. Check the below example:
 ```sh
 POST http://localhost:8080/projects
 {
	"projectName": "GSA Migration",
	"description": "The aim of this project is to migrate the GSA to Solr",
	"maxBudget": 50000,
	"deadline": "5-16-2000",
	"sellerId": 1
}
 ```
 Seller will get an error saying "Please enter the deadline of the Project greater than today's date."

- Buyer should always post the bid amount less than or equal to the maximum budget of the project. Suppose the max budget of the project is 100, then the buyer post the bid amount less than or equal to 100 or he will get an error. Check the below example:
 ```sh
 POST localhost:8080/projects/12/bids
 {
	"buyerId": 9,
	"bid": 111
}
  ```
  Buyer will get an error saying "Please enter the bid less than or equal to the project maximum budget: 100.0"

- Buyer should always post the bid amount less than the current minimum bid of the project. Suppose the current min bid of the project is 89, then the buyer should post the bid amount less than 89 or he will get an error saying "Please enter the bid less than the current minimum: {currentMinValue}"





 



    




























  