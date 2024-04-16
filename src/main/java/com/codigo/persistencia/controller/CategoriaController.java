package com.codigo.persistencia.controller;

import com.codigo.persistencia.dao.CategoriaRepository;
import com.codigo.persistencia.entity.Categoria;
import com.codigo.persistencia.entity.Producto;
import com.codigo.persistencia.request.ProductoRequest;
import com.codigo.persistencia.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categoria")
@AllArgsConstructor
@Tag(
        name = "Api de categorias",
        description = "Esta api te permite registrar una categoria"
)
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping("/crearCategoria")
    @Operation(
            summary = "guardar una categoria en base de datos",
            description = "Para usar endPoint debes enviar una objeto categoria, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de categorias")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS 200 significa registro exitoso",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTTP STATUS 201 significa que se creó  de manera exitosa",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS 400 significa que tu REQUEST esta MALLLLL",
                    content = @Content(mediaType = "application/json")
            )
    })

    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        Categoria registrarCategoria;
        registrarCategoria = categoriaService.registrarCategoria(categoria);
        return ResponseEntity.ok(registrarCategoria);
    }

}
