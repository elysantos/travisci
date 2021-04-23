package br.edu.ifma.travis.model;

import lombok.Data;

import java.util.List;

@Data
public class Usuario {
    private int id;
    private String cpf;
    private String nome;
    private Genero sexo;
    private TipoUsuario tipoUsuario;
    private String email;
    private String curso;
    private String codigo;
    private String empresa;
    private String setor;
    private Endereco endereco;
    private Telefone telefone;
    List<Veiculo> veiculos;

}
