package br.edu.ifma.travis.mapper;

import br.edu.ifma.travis.model.Endereco;
import br.edu.ifma.travis.model.Telefone;
import br.edu.ifma.travis.model.Usuario;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UsuarioMapper {
    List<Usuario> findAll();


    void insertEndereco(@Param("endereco") Endereco endereco);

    void insert(@Param("usuario") Usuario usuario);

    void insertTelefone(@Param("id") int id, @Param("telefone") Telefone telefone);

    void delete(@Param("id") int id);

    Usuario find(@Param("id") int id);

    void update(@Param("usuario") Usuario usuario);

    void deleteEndereco(@Param("id") Integer id);

    void deleteTelefone(@Param("id") int id);
}
