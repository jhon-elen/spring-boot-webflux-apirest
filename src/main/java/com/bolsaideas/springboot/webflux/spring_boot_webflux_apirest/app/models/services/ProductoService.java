package com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.models.services;

import com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.models.documents.Categoria;
import com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.models.documents.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

    Flux<Producto> findAll();

    Flux<Producto> findAllConNombreUpperCase();

    Flux<Producto> findAllConNombreUpperCaseRepeat();

    Mono<Producto> findById(String id);

    Mono<Producto> save(Producto producto);

    Mono<Void> delete(Producto producto);

    Flux<Categoria> findAllCategoria();

    Mono<Categoria> findCategoriaById(String id);

    Mono<Categoria> saveCategoria(Categoria categoria);
    
    Mono<Producto> findByNombre(String nombre);
    
    Mono<Categoria> findCategoriaByNombre(String nombre);
}