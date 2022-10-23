package com.example.redInforma.service;

import java.util.List;
 //utilizando codigo generico
public interface UsuariosService<E>{
    public List<E> findAll() throws Exception; //lista de todos los usuarios
    public E findById(Long id) throws  Exception; // nos trae un usuario
    public E save(E entity) throws Exception; // crea o guadar un suario nuevo
    public E update(Long id, E entity) throws Exception; //modifica o actualiza un usuario
    public boolean delete(long id) throws Exception; //eliminar un usuario
}
