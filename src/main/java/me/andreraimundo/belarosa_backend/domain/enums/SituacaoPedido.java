package me.andreraimundo.belarosa_backend.domain.enums;

public enum SituacaoPedido {
    
    PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    private SituacaoPedido(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }
    
    public int getCod() {
        return cod;
    }

    public String getdescricao() {
        return descricao;
    }  

    public static SituacaoPedido toEnum (Integer cod) {
        if (cod  == null) {
            return null;
        }
        for (SituacaoPedido x: SituacaoPedido.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido: " + cod);
    }

}
    