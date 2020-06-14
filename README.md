# spring-api
Spring boot REST API for test

Setup
----------
- Clone and open in Intellij Idea IDE
- Change database connection config in `src/main/resources/application.yml`
- Install maven dependencies using IDE auto import or using the command ``mvn install``
- Browse ``http//localhost:8080/api/v1/roles``

API Doc
----------------
- List all roles 
    ```
    GET /api/v1/roles
    ```
- Create new roles 
    ```
    POST /api/v1/roles
    ```

    Body:
    ```
    {
        "nic": "95000011113v",
        "organization": "University",
        "firstName": "chathura",
        "lastName": "bandara",
        "roleType": "ASSISTANT"
    }
    ```
    Content-Type:
    ```
    application/json
    ```
- Get specific role 
    ```
    GET /api/v1/roles/95000011113v
    ```
- Update role
    ```
    PUT /api/v1/roles
    ```
    Body:
    ```
    {
        "nic": "96000011112v",
        "organization": "School",
        "firstName": "supun",
        "lastName": "chandimal",
        "roleType": "DRIVER"
    }
    ```
    
    Content-Type:
    ```
    application/json
    ```
- Delete role
    ```
    DELETE /api/v1/roles/96000011112v
    ```
-Retrieve role by the organization and the role type
    ```
    GET /api/v1/roles?org=University&roleType=DRIVER
    ```
    
