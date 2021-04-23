package br.edu.ifma.travis.model;

public enum Genero {
    MASCULINO(0,"Masculino"),
    FEMININO(1, "Feminino"),
    OUTRO(2, "Outro"),
    NAO_INFORMADO(3, "Não Informado");

    Genero(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    private int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public static Genero valueOf(int id){
        for(Genero genero : Genero.values()){
            if(genero.id == id){
                return genero;
            }
        }
        return Genero.NAO_INFORMADO;
    }
}
