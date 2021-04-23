package br.edu.ifma.travis.controller;

import br.edu.ifma.travis.model.Usuario;
import br.edu.ifma.travis.service.UsuarioService;
import br.edu.ifma.travis.service.VeiculoService;
import br.edu.ifma.travis.util.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUsuario(@PathVariable("id") int id){
        try{
            return new ResponseEntity(usuarioService.findOne(id), HttpStatus.OK);
        }catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<String> addUsuario(@RequestBody Usuario usuario){
        try{
            usuarioService.insert(usuario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@PathVariable("id") int id,
                                                @RequestBody Usuario usuario){
        try{
            usuarioService.update(id, usuario);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") int id){
        try{
            usuarioService.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
