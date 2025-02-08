package registration_system.dto;

import java.math.BigDecimal;

public class FuncionarioSalarioDTO {
    private String nome;
    private BigDecimal quantidadeDeSalariosMinimos;

    public FuncionarioSalarioDTO(String nome, BigDecimal quantidadeDeSalariosMinimos) {
        this.nome = nome;
        this.quantidadeDeSalariosMinimos = quantidadeDeSalariosMinimos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getQuantidadeDeSalariosMinimos() {
        return quantidadeDeSalariosMinimos;
    }

    public void setQuantidadeDeSalariosMinimos(BigDecimal quantidadeDeSalariosMinimos) {
        this.quantidadeDeSalariosMinimos = quantidadeDeSalariosMinimos;
    }

    @Override
    public String toString() {
        return " Nome: " + this.getNome() + " | Salário: " + this.getQuantidadeDeSalariosMinimos();
    }
}
