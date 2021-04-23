package br.edu.ifma.travis.controller;

import br.edu.ifma.travis.model.Veiculo;
import br.edu.ifma.travis.service.VeiculoService;
import br.edu.ifma.travis.util.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios/{usuario}/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAll(@PathVariable("usuario") int usuario){
        return new ResponseEntity<>(veiculoService.findByUsuario(usuario), HttpStatus.OK);
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Veiculo> getPorPlaca(@PathVariable("usuario") int idUsuario,
                                              @PathVariable("placa") String placa){
        return new ResponseEntity<>(veiculoService.findByPlaca(placa), HttpStatus.OK);
    }

    @GetMapping("/selo/{selo}")
    public ResponseEntity<Veiculo> getPorSelo(@PathVariable("usuario") int idUsuario,
                                              @PathVariable("selo") int selo){
        return new ResponseEntity<>(veiculoService.findBySelo(selo), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getOne(@PathVariable("usuario") int usuario,
                                         @PathVariable("id") int id){
        try{
            return new ResponseEntity(veiculoService.findOne(usuario, id), HttpStatus.OK);
        }catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<String> add(@PathVariable("usuario") int idUsuario,
                                      @RequestBody Veiculo veiculo){
        try{
            veiculoService.inserir(idUsuario, veiculo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("usuario") int idUsuario,
                                         @PathVariable("id") int idVeiculo,
                                         @RequestBody Veiculo veiculo){
        try{
            veiculoService.update(idUsuario, idVeiculo, veiculo);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("usuario") int idUsuario,
                                         @PathVariable("id") int idVeiculo){
        try{
            veiculoService.delete(idUsuario, idVeiculo);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
