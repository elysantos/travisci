package br.edu.ifma.travis.model;

public enum TipoUsuario {
    SERVIDOR(1, "Servidor"),
    ALUNO(2, "Aluno"),
    TERCEIRIZADO(3, "Terceirizado");

    TipoUsuario(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    private int id;
    private String descricao;

    public static TipoUsuario valueOf(int id){
        for(TipoUsuario tipoUsuario : TipoUsuario.values()){
            if(tipoUsuario.id == id){
                return tipoUsuario;
            }
        }
        return null;
    }

    public int getId() {
        return this.id;
    }
}
