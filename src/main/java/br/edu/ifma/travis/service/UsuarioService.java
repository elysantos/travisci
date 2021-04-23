package br.edu.ifma.travis.service;

import br.edu.ifma.travis.mapper.UsuarioMapper;
import br.edu.ifma.travis.model.Usuario;
import br.edu.ifma.travis.util.exceptions.BDException;
import br.edu.ifma.travis.util.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioMapper usuarioMapper;
    public List<Usuario> findAll() {
        return usuarioMapper.findAll();
    }


    public void insert(Usuario usuario) throws Exception {
        try{
            if(usuario.getEndereco() !=  null){
                usuarioMapper.insertEndereco(usuario.getEndereco());
            }
            usuarioMapper.insert(usuario);
            if(usuario.getTelefone() != null){
                usuarioMapper.insertTelefone(usuario.getId(), usuario.getTelefone());
            }
        }catch (RuntimeException e){
            throw new BDException(e.getMessage());
        }
    }

    public void delete(int id) throws BDException, NotFoundException {
        try{
            Usuario usuario = usuarioMapper.find(id);
            if(usuario == null){
                throw new NotFoundException("Item não encontrado");
            }
            usuarioMapper.delete(id);
            if(usuario.getEndereco() !=  null){
                usuarioMapper.deleteEndereco(usuario.getEndereco().getId());
            }
            if(usuario.getTelefone() != null){
                usuarioMapper.deleteTelefone(usuario.getId());
            }
        }catch (RuntimeException e ){
            throw new BDException(e.getMessage());
        }
    }

    public void update(int id, Usuario usuario) throws NotFoundException, BDException {
        try{
            Usuario usuarioAntigo = usuarioMapper.find(id);
            if(usuarioAntigo != null && usuario.getId() != id){
                usuarioMapper.update(usuario);
            }else{
                throw new NotFoundException("Não encontrado usuário para o id passado");
            }
        }catch (RuntimeException e ){
            throw new BDException(e.getMessage());
        }
    }

    public Usuario findOne(int id) throws NotFoundException {
        Usuario usuario = usuarioMapper.find(id);
        if(usuario == null){
            throw new NotFoundException("Usuário não encontrado");
        }
        return usuario;
    }
}
