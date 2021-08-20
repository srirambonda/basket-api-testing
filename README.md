# Basket Open API testing with Serenity framework

[![Basket API Testing](https://github.com/srirambonda/basket-api-testing/actions/workflows/maven.yml/badge.svg)](https://github.com/srirambonda/basket-api-testing/actions/workflows/maven.yml)

## Prerequisites to run this Project:

* `java` and `maven`

## Commands to run the Project:
``` bash
# Clone the repository:
$ git clone https://github.com/srirambonda/basket-api-testing.git

# Set the directory path:
$ cd basket-api-testing

# Run test scenarios:
$ mvn clean verify
```
## Write new test cases:

  * Navigate to following path basket-api-testing/src/test/resources/features/basket/
  * On the basket folder Right-click and select New > File
  * In order for framework to automatically detect the features, make sure that they carry the 'feature' file extension.  
    For example, basket.feature
  * Write the first automation script. In BDD terms the scenario would look like the following:

      ```
      @tag
      Feature: {Defines what feature you will be testing in the tests below}
      Scenario: {Defines what scenario you will be testing}
      Given {Tells the pre-condition of the test}
      When {Defines the condition of the test}
      And {Defines additional conditions of the test}
      Then {States the post condition. You can say that it is the expected result of the test}
    ```

  * Sample feature file with one scenario:
    
        @test
        Feature: Functional verification of Basket REST APIs
        Scenario: update the basket with right details
        Given the following basket:
        | forward_url |
        | "https://google.com" |
        When  I update the basket for "baskettesting1"
        Then status of response is 204

## Endpoint Interactions:

* Base URL: https://rbaskets.in/api/baskets

* CRUD METHODS implemented: POST, GET, UPDATE, DELETE

*   POST (Adds one or more new entries) :
Creates a new basket. A unique token id will be returned 
    
    *   URL: https://rbaskets.in/api/baskets/{name}

    *   Response Body:
    ```
    {
        "token": "RsLM2zS5clgowfZDz92ob36aDCe4gvyMPL27digqVxrw"
    }
    ```

*   UPDATE (Changes specific fields in existing entries):
Updates the field named forward_url for the existing basket created above by passing the token in request header

    *   URL: https://rbaskets.in/api/baskets/{name}

    *   Request Headers:
    ```Authorization=RsLM2zS5clgowfZDz92ob36aDCe4gvyMPL27digqVxrw```

    *   Content Body:
    ```
    {
        "forward_url": "https://google.com"
    }
    ```

*   GET (Retrieves entries that match certain criteria (if there are any)):
Retrieves the basket details which was created above by passing the token in request header

    *   URL: https://rbaskets.in/api/baskets/{name}

    *   Request Headers:
    ```Authorization=RsLM2zS5clgowfZDz92ob36aDCe4gvyMPL27digqVxrw```

    *   Response Body
    ```
    {
        "forward_url": "https://google.com",
        "proxy_response": false,
        "insecure_tls": false,
        "expand_path": false,
        "capacity": 200
    }
    ```

*   DELETE (Entirely removes the existing entry):
Deletes the basket details which was created above by passing the token in request header

    *   URL: https://rbaskets.in/api/baskets/{name}

    *   Request Headers:
    ```Authorization=RsLM2zS5clgowfZDz92ob36aDCe4gvyMPL27digqVxrw```
    
##   Test Reports Path:
*   'target/site/serenity/index.html'

The report contains 4 tabs ( "Overall Test Results" , "Requirements", "Capabilities" , "Features" )

*   **Overall Test Results :**  Displays execution result in the form of a Pie Chart
Contains Execution Time and displays Fastest, slowest & Avg time of test
Functional Coverage Overview: after clicking on Feature it Navigates to Feature tab.

*   **Requirements :** Displays the requirement overview which contains all the Features and scenarios with hierarchy

*   **Capabilities :** It displays All the capabilities like feature folders

*   **Features :** Gives an overview of all the features in the project, scenarios and steps.
It is also possible to verify test results, input and output messages by clicking on magnifier symbol next to each scenario
