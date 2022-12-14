# Car Factory
___


## Example Usage of Car Factory API

### Postman Collection
* You can import postman collection from  'CarFactory.postman_collection.json'
---
### Perform a get request to retrieve all valid car types.
```shell script
'GET' http://localhost:8080/api/cars
```

* #### Sample  GET /api/cars response:
```shell script
{
    "type": "Sedan",
    "color": "Black",
    "model": "A431"
}
```
### Perform a post request to produce a car.
* #### Request URL:  http://localhost:8080/api/cars/produce
* #### Sample  Post /api/cars/produce request:
```shell script
{
    "type": "Cabrio",
}
```
* #### Sample  Post /api/cars/produce response:
```shell script
{
    "type": "Cabrio",
    "message": "Cabrio Car has produced."
}
```
---

