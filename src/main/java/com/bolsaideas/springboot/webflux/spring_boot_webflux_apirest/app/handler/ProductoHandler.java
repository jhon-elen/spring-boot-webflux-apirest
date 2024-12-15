package com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.handler;

import com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.models.documents.Producto;
import com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.models.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductoHandler {
    
    @Autowired
    private ProductoService service;
    
    public Mono<ServerResponse> listar(ServerRequest request) {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.findAll(), Producto.class);
    }
}
