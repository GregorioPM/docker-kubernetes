package com.curso.springcloud.msvc.usuarios.services;

import com.curso.springcloud.msvc.usuarios.models.entity.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    ResponseEntity<List<Usuario>> getAll();

    ResponseEntity<Usuario> getById(Long id);

    ResponseEntity<Usuario> save(Usuario usuario);

    ResponseEntity<Usuario> update(Long id, Usuario usuario);

    ResponseEntity<Void> delete(Long id);
}
