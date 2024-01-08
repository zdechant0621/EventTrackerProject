# EventTrackerProject

# ===City Shot Glass Tracker===

# ===Overview===

The point of this tracker is to be able to track all the cities I've traveled to and whether or not I bought a shot glass representing that city to add to my collection.


# Development

As a huge advocate of traveling, and someone who got to travel a lot to different places via my previous job, I developed a love of collecting shot glasses for places I've been. I'm not exactly sure where it started, but over the years I collected hundreds of them and display them in a case to showcase all my travels.


# ===Technologies Used===

- Java			
- MySQL			
- MAMP			
- SpringBoot		
- GitHub			
- JPA				
- JDBC
- J-Unit
- Gradle
- SpringToolSuite 4
- EC2
- JSON
- REST
- POSTMAN

# Lessons Learned

- Efficiency with deciphering Stack Traces
- Effective use of DAO and controllers
- Thorough knowledge of Request Mapping and Parameters
- Writing thorough J-Unit tests
- Usage of uni-directionadl and bi-directional relationships

## API Endpoints
| HTTP Verb | URI               | Request Body | Response Body | Status Codes |
|-----------|-------------------|--------------|---------------|--------------|
| GET       | /api/cities       | None         | List of cities| 200 OK       |
| GET       | /api/cities/{id}  | None         | Single habit  | 200 OK, 404 Not Found |
| POST      | /api/cities       | Habit data   | Created habit | 201 Created, 400 Bad Request |
| PUT       | /api/cities/{id}  | Updated data | Updated habit | 200 OK, 404 Not Found, 400 Bad Request |
| DELETE    | /api/cities/{id}  | None         | None          | 204 No Content, 404 Not Found |
