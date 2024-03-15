package com.curso.springcloud.msvc.cursos.services.impl;

import com.curso.springcloud.msvc.cursos.model.entity.Curso;
import com.curso.springcloud.msvc.cursos.repositories.ICursoRepository;
import com.curso.springcloud.msvc.cursos.services.ICursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoSevice implements ICursoService {

    private final ICursoRepository repository;

    public CursoSevice(ICursoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<Curso>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body((List<Curso>) repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<Curso> getById(Long id) {
        Optional<Curso> curso = repository.findById(id);
        return curso.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    @Transactional
    public ResponseEntity<Curso> save(Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(curso));
    }

    @Override
    @Transactional
    public ResponseEntity<Curso> update(Long id, Curso curso) {
        Optional<Curso> optCurso = repository.findById(id);
        if (optCurso.isPresent()){
            Curso cursoDb = optCurso.get();
            cursoDb.setNombre(curso.getNombre());
            return ResponseEntity.status(HttpStatus.OK).body(repository.save(cursoDb));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> delete(Long id) {
        Optional<Curso> optCurso = repository.findById(id);
        if (optCurso.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
