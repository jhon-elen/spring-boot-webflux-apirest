package com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.handler;

import com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.models.documents.Producto;
import com.bolsaideas.springboot.webflux.spring_boot_webflux_apirest.app.models.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class ProductoHandler {
    
    @Autowired
    private ProductoService service;
    
    public Mono<ServerResponse> listar(ServerRequest request) {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.findAll(), Producto.class);
    }
    
    public Mono<ServerResponse> ver(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.findById(id).flatMap(p -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(p)))
            .switchIfEmpty(ServerResponse.notFound().build());
    }
    
    public Mono<ServerResponse> crear(ServerRequest request) {
        Mono<Producto> producto = request.bodyToMono(Producto.class);
        
        return producto.flatMap(p -> {
            if (p.getCreatedAt() == null) {
                p.setCreatedAt(new Date());
            }
            return service.save(p);
        }).flatMap(p -> ServerResponse
            .created(URI.create("/api/v2/productos/".concat(p.getId())))
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromObject(p))
        );
    }
    
    public Mono<ServerResponse> editar(ServerRequest request) {
        Mono<Producto> producto = request.bodyToMono(Producto.class);
        String id = request.pathVariable("id");
        
        Mono<Producto> productoDb = service.findById(id);
        
        return productoDb.zipWith(producto, (db, req) -> {
                db.setNombre(req.getNombre());
                db.setPrecio(req.getPrecio());
                db.setCategoria(req.getCategoria());
                return db;
            })
            .flatMap(p -> ServerResponse
                .created(URI.create("/api/v2/productos/".concat(p.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.save(p), Producto.class))
            .switchIfEmpty(ServerResponse.notFound().build());
    }
    
    public Mono<ServerResponse> eliminar(ServerRequest request) {
        String id = request.pathVariable("id");
        
        Mono<Producto> productoDb = service.findById(id);
        
        return productoDb.flatMap(p -> service.delete(p).then(ServerResponse.noContent().build()))
           .switchIfEmpty(ServerResponse.notFound().build());
    }
}
