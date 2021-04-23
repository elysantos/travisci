package br.edu.ifma.travis.model;

import lombok.Data;

@Data
public class Telefone {
    private String codigo;
    private String numero;


    @Override
    public String toString() {
        return "Telefone : (" + codigo + ") " + numero;
    }
}
