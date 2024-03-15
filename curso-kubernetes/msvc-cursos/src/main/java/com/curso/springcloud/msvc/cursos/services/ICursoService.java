package com.curso.springcloud.msvc.cursos.services;

import com.curso.springcloud.msvc.cursos.model.entity.Curso;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICursoService {

    ResponseEntity<List<Curso>> getAll();
    ResponseEntity<Curso> getById(Long id);
    ResponseEntity<Curso> save(Curso curso);

    ResponseEntity<Curso> update(Long id, Curso curso);

    ResponseEntity<Void> delete(Long id);
}
