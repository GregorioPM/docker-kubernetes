package com.curso.springcloud.msvc.cursos.controllers;

import com.curso.springcloud.msvc.cursos.model.entity.Curso;
import com.curso.springcloud.msvc.cursos.services.ICursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CursoController {

    private final ICursoService service;

    public CursoController(ICursoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody Curso curso) {
        return service.save(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@RequestBody Curso curso, @PathVariable Long id) {
        return service.update(id, curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
