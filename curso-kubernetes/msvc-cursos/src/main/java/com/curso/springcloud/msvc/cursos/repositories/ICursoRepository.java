package com.curso.springcloud.msvc.cursos.repositories;

import com.curso.springcloud.msvc.cursos.model.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface ICursoRepository extends CrudRepository<Curso, Long> {
}
