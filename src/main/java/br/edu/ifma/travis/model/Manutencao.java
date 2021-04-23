package br.edu.ifma.travis.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Manutencao {

    private LocalDate dataManutencao;
    private String servicoRealizado;
    private Veiculo veiculo;
    private int quilometragem;

    @Override
    public String toString() {
        return "Manutencao{" +
                "dataManutencao=" + dataManutencao +
                ", servicoRealizado='" + servicoRealizado + '\'' +
                ", quilometragem=" + quilometragem +
                '}';
    }
}
