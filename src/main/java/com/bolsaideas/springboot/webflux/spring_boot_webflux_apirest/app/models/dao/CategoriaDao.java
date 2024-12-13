package com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.models.dao;

import com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.models.documents.Categoria;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoriaDao extends ReactiveMongoRepository<Categoria, String> {

}