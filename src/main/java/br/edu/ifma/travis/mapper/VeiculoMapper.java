package br.edu.ifma.travis.mapper;

import br.edu.ifma.travis.model.Veiculo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VeiculoMapper {
    List<Veiculo> findAllByUsuario(@Param("usuario") int usuario);

    Veiculo findByUsuarioAndId(@Param("idUsuario") int idUsuario, @Param("id") int id);

    void insert(@Param("veiculo") Veiculo veiculo, @Param("idUsuario") int idUsuario);

    void update(@Param("veiculo") Veiculo veiculo);

    void delete(@Param("idVeiculo") int idVeiculo);

    Veiculo findBySelo(@Param("selo") int selo);

    Veiculo findByPlaca(@Param("placa") String placa);
}
