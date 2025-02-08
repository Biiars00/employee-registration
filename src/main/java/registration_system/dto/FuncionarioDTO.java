package registration_system.dto;

public class FuncionarioDTO {
    private String nome;
    private String dataNascimento;
    private String salario;
    private String funcao;

    public FuncionarioDTO(String nome, String dataNascimento, String salario, String funcao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
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
