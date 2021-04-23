package br.edu.ifma.travis.model;

import lombok.Data;

@Data
public class Endereco {
    private Integer id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String complemento;
    private int numero;
    private String cidade;
    private String uf;

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", numero=" + numero +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
