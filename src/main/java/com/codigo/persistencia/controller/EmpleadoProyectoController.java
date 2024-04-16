package com.codigo.persistencia.controller;

import com.codigo.persistencia.entity.EmpleadoProyecto;
import com.codigo.persistencia.service.EmpleadoProyectoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/empleadoProyecto/")
@AllArgsConstructor
public class EmpleadoProyectoController {

    private final EmpleadoProyectoService empleadoProyectoService;

    @PostMapping("/crearEmpleadoProyecto")
    public ResponseEntity<EmpleadoProyecto> agregarEmpleadoAProyecto(@RequestBody EmpleadoProyecto empleadoProyecto) {
        EmpleadoProyecto nuevoEmpleadoProyecto = empleadoProyectoService.guardar(empleadoProyecto);
        return ResponseEntity.ok(nuevoEmpleadoProyecto);
    }

    @GetMapping("/{empleadoId}/{proyectoId}")
    public ResponseEntity<EmpleadoProyecto> obtenerEmpleadoProyecto(@PathVariable Long empleadoId, @PathVariable Long proyectoId) {
        EmpleadoProyecto empleadoProyecto = empleadoProyectoService.buscarPorId(empleadoId, proyectoId);
        if (empleadoProyecto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleadoProyecto);
    }

    @DeleteMapping("/{empleadoId}/{proyectoId}")
    public ResponseEntity<Void> eliminarEmpleadoProyecto(@PathVariable Long empleadoId, @PathVariable Long proyectoId) {
        empleadoProyectoService.eliminar(empleadoId, proyectoId);
        return ResponseEntity.ok().build();
    }
}
