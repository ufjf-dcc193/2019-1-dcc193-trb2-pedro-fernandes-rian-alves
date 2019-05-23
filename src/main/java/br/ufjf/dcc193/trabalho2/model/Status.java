package br.ufjf.dcc193.trabalho2.model;

public enum Status {
    AFAZER(0,"A fazer"),
    AVALIADO(1, "Avaliado"),
    IMPEDIDO(2, "Impedido"),
    VALIDADO(3, "Validado"),
    INVALIDADO(4, "Invalidado");

    private Integer codigo;
    private String descricao;

    private Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod){
        if (cod==null)
            return null;
        for (Status status : Status.values()){
            if (cod.equals(status.getCodigo())) {
                return status;
            }
        }

        throw new IllegalArgumentException("Id inválido: " +cod);
    }
}
