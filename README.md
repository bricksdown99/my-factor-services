# Spring Boot Application my-factor-services

## Usage
Option 1: $java -jar my-factor-services-0.0.1-SNAPSHOT.jar

Option 2: Eclipse RestfulWebServicesApplication.java -> Run As -> Java Application 

## Example
  ### Post Request
    URI: http://localhost:8080/factor-services
    Content-Type: application/json
    Body:
      {
        "floodFactor": 3,
        "buildingSafetyFactor": 4,
        "location": "Pasig"
      }
  ### Output - Json
    Body:
      {
        "location": "Pasig",
        "price": {
            "grossPrice": 999.99,
            "technicalPrice": 888.88,
            "netPrice": 777.77
         }
      }
      
## Features:
1. Endpoints for location Pasig, QC and others are configured in application.properties and easily accessed in a centralized configuration class EndpointConfiguration.java
2. AOP is used to log every method calls from the base package com.microservices
3. The factor service will receive all the 3 factors in a JSON object model (Example JSON object model shown above)
4. The factor service will delegate the calculation responsibility by calling the endpoint corresponding to the requested location specified in the POST request

    endpoint.locPasig=http://localhost:8080/smartratingservice
    endpoint.locQC=http://localhost:8080/excellentratingservice
    endpoint.locOthers=http://localhost:8080/idoeverythingtratingservice
5. All 3 service providers will return the prices as a JSON response to the calling system (factor service)
        a. Gross Price
        b. Technical Price
        c. Net Price
6. The factor service will return a JSON response with the location and prices. (Example JSON object model shown above)
