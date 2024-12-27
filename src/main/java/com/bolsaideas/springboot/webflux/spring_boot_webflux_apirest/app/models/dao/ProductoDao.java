package com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.models.dao;

import com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.models.documents.Producto;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProductoDao extends ReactiveMongoRepository<Producto, String> {

    Mono<Producto> findByNombre(String nombre);
    
    @Query("{ 'nombre': ?0 }")
    Mono<Producto> obtenerPorNombre(String nombre);
}
