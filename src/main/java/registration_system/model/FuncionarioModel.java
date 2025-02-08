package registration_system.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FuncionarioModel extends PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal salario;

    @Column
    private String funcao;

    public FuncionarioModel() {
        super(null, null);
    }

    public FuncionarioModel(Long id, String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.id = id;
        this.salario = salario;
        this.funcao = funcao;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return " Nome: " + this.getNome() + " | Data de Nascimento: " +
                this.getDataNascimento()
                + " | Salário: " + this.getSalario()
                + " | Função: "
                + this.getFuncao();
    }
}
