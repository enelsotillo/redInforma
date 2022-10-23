package com.example.redInforma.service;

import com.example.redInforma.entety.Usuarios;
import com.example.redInforma.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosImpl implements UsuariosService<Usuarios>{

    @Autowired
    private UsuariosRepository usuariosRepository;
  // constructor para instanciar un metodo o @Autowired es lo mismo
  //  public UsuariosImpl (UsuariosRepository usuariosRepository){
  //      this.usuariosRepository = usuariosRepository;
  //  }

    @Override
    @Transactional //significa pueden transacción a la base datos
    public List<Usuarios> findAll() throws Exception {
        try {
            List<Usuarios> entities = usuariosRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuarios findById(Long id) throws Exception {
        try {
            Optional<Usuarios> entitiesOptional = usuariosRepository.findById(id);
            return entitiesOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuarios save(Usuarios entity) throws Exception {
        try {
             entity = usuariosRepository.save(entity);
             return entity;
        }catch (Exception e){
             throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Usuarios update(Long id, Usuarios entity) throws Exception {
        try {
             Optional<Usuarios> entitiesOptional = usuariosRepository.findById(id);
             Usuarios usuarios = entitiesOptional.get();
             usuarios = usuariosRepository.save(entity);
             return usuarios;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(long id) throws Exception {
        try {
            if (usuariosRepository.existsById(id)){
                usuariosRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}