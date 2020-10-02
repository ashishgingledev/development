**Client-side service discovery?**
<br>Services typically need to call one another. 

<br>In a monolithic application, services invoke one another through language-level method or procedure calls. 
In a traditional distributed system deployment, services run at fixed, well known locations (hosts and ports) 
and so can easily call one another using HTTP/REST or some RPC mechanism.
 
 However, a modern microservice-based application typically runs in a virtualized or containerized environments
 where the number of instances of a service and their locations changes dynamically.
 
 Consequently, you must implement a mechanism for that enables the clients of service 
 to make requests to a dynamically changing set of ephemeral service instances.
 
 Here the Service Registry will come to rescue
 When making a request to a service, 
 the client obtains the location of a service instance by querying a Service Registry, which knows the locations of all service instances.
 
 
 Client-side discovery has the following benefits:
 
 Fewer moving parts and network hops compared to Server-side Discovery
 Client-side discovery also has the following drawbacks:
 
 This pattern couples the client to the Service Registry
 You need to implement client-side service discovery logic for 
 each programming language/framework used by your application, e.g Java/Scala, JavaScript/NodeJS.
  For example, Netflix Prana provides an HTTP proxy-based approach to service discovery for non-JVM clients.
  
  
  So in Nutshell -
  client ====>ServiceDiscovery(Eureka)=====>Target Service.
  
  
  **Server Side Discovery**
  ONly difference is When making a request to a service, the client makes a request via a router (a.k.a load balancer) that runs at a well known location. 
  The router queries a service registry, which might be built into the router, and forwards the request to an available service instance.
  
  So
  client ===>Load Balancer ==> Service Discovery(Eureka) ======> Target Service