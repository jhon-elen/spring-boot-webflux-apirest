# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.bolsaideas.springboot.webflux.spring-boot-webflux-apirest' is invalid and this project uses 'com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.0/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.0/maven-plugin/build-image.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.0/reference/using/devtools.html)
* [Spring Data Reactive MongoDB](https://docs.spring.io/spring-boot/3.4.0/reference/data/nosql.html#data.nosql.mongodb)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/3.4.0/reference/web/reactive.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

