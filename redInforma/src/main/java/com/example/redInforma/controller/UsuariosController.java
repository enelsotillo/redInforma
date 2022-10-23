package com.example.redInforma.controller;

import com.example.redInforma.entety.Usuarios;
import com.example.redInforma.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //tipo servicio controlador
@CrossOrigin(origins = "*") //se puede accder desde cualquier sitio o podemos definir una unica acceso
@RequestMapping(path = "api/acceso/usuarios") //path ruta para acceder a la pagina
public class UsuariosController {
    @Autowired
    public UsuariosService usuariosService;
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        try {
            // aqui pedimos que realice la consulta y adicional con un status Http Ok y en un cuerpo
            return ResponseEntity.status(HttpStatus.OK).body(usuariosService.findAll());
        } catch (Exception e) {
            //aquí utilizaremos un formato JSON
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error. por favor intente mas tarde.\"}");

        }
    }
    @GetMapping("/{id}")
    //ruta en el path
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuariosService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error. por favor intente mas tarde.\"}");
        }
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Usuarios entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuariosService.save(entity));
        }catch (Exception e){
            //body le damos una repuesta en formato JSON
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error. por favor intente mas tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Usuarios entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuariosService.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error. por favor intente mas tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usuariosService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error. por favor intente mas tarde.\"}");
        }

    }
}
