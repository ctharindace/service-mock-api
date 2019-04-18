# aeroMASTER mock API for aeroINVENTORY
This service will have the mock service for aeroMaster services. 

### Prerequisites

* Java - 8 > 
* Gradle - 4.* 
    
### Building the Project with gradle

* Move in to relevant service-api directory 
    `cd /home/<>/aeroinventory/services/service-mock-api`    
    
* Building with Gradle
    `gradle buildDocker`
    
### Start & Up the service with Docker  
aeroMASTER mock api service will be running on port - 8080
    `docker run -p 8080:8080 --name service-mock-api aeroinventory/service-mock-api:latest`   


