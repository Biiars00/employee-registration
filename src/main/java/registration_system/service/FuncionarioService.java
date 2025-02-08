package registration_system.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import registration_system.dto.FuncionarioDTO;
import registration_system.dto.FuncionarioIdadeDTO;
import registration_system.dto.FuncionarioSalarioDTO;
import registration_system.model.FuncionarioModel;
import registration_system.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public String formatarDataNascimento(LocalDate data) {
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatarData);
    }

    public String formatarSalario(BigDecimal valor) {
        @SuppressWarnings("deprecation")
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatador.format(valor);
    }

    public List<FuncionarioModel> funcionariosOrdenados() {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();
        funcionarios.sort((a, b) -> a.getNome().compareTo(b.getNome()));

        return funcionarios;
    }

    public List<FuncionarioDTO> listarFuncionarios() {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();
        funcionarios.sort((a, b) -> a.getNome().compareTo(b.getNome()));

        List<FuncionarioDTO> funcionariosDto = new ArrayList<>();

        for (FuncionarioModel funcionario : funcionarios) {
            LocalDate dataNascimento = funcionario.getDataNascimento();
            String dataNascimentoFormatada = formatarDataNascimento(dataNascimento);

            BigDecimal salario = funcionario.getSalario();
            String salarioFormatado = formatarSalario(salario);

            FuncionarioDTO funcionarioDto = new FuncionarioDTO(
                    funcionario.getNome(),
                    dataNascimentoFormatada,
                    salarioFormatado,
                    funcionario.getFuncao());

            funcionariosDto.add(funcionarioDto);
        }
        System.out.println(funcionariosDto);

        return funcionariosDto;
    }

    public FuncionarioModel cadastrarFuncionario(FuncionarioModel funcionario) {
        System.out.println(funcionarioRepository.save(funcionario));
        return funcionarioRepository.save(funcionario);
    }

    public void removerFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public List<FuncionarioDTO> aumentarSalario(BigDecimal aumentoSalarial) {
        List<FuncionarioModel> funcionarios = funcionariosOrdenados();

        BigDecimal totalSalarios = BigDecimal.ZERO;

        List<FuncionarioDTO> funcionariosDto = new ArrayList<>();

        for (FuncionarioModel funcionario : funcionarios) {
            BigDecimal aumentoSalario = funcionario.getSalario().multiply(aumentoSalarial)
                    .divide(new BigDecimal("100"));
            BigDecimal salarioAtualizado = funcionario.getSalario().add(aumentoSalario);
            System.out.println("SALÁRIO ATUALIZADO ----->>>" + salarioAtualizado);

            funcionario.setSalario(salarioAtualizado);
            totalSalarios = totalSalarios.add(salarioAtualizado);
            System.out.println("TOTAL DE SALÁRIOS ----->>>" + totalSalarios);

            LocalDate dataNascimento = funcionario.getDataNascimento();
            String dataNascimentoFormatada = formatarDataNascimento(dataNascimento);

            BigDecimal salario = funcionario.getSalario();
            String salarioFormatado = formatarSalario(salario);
            System.out.println("SALÁRIO FORMATADO ----->>>" + salarioFormatado);

            FuncionarioDTO funcionarioDto = new FuncionarioDTO(
                    funcionario.getNome(),
                    dataNascimentoFormatada,
                    salarioFormatado,
                    funcionario.getFuncao());

            funcionariosDto.add(funcionarioDto);

        }
        System.out.println(funcionariosDto);

        return funcionariosDto;
    }

    public String totalDeSalarios() {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();

        BigDecimal totalSalarios = BigDecimal.ZERO;
        String salariosFormatados = "";

        for (FuncionarioModel funcionario : funcionarios) {
            BigDecimal salarios = funcionario.getSalario();
            totalSalarios = totalSalarios.add(salarios);

            salariosFormatados = formatarSalario(totalSalarios);
        }
        System.out.println(salariosFormatados);

        return salariosFormatados;
    }

    public List<FuncionarioSalarioDTO> quantidadeSalariosMinimos() {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();

        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        List<FuncionarioSalarioDTO> funcionariosSalarioDto = new ArrayList<>();

        for (FuncionarioModel funcionario : funcionarios) {
            BigDecimal salario = funcionario.getSalario();
            BigDecimal salariosMinimos = salario.divide(salarioMinimo, 1, RoundingMode.HALF_UP);

            FuncionarioSalarioDTO funcionarioSalarioDto = new FuncionarioSalarioDTO(funcionario.getNome(),
                    salariosMinimos);
            funcionariosSalarioDto.add(funcionarioSalarioDto);

            System.out.println(funcionarioSalarioDto);
        }

        return funcionariosSalarioDto;
    }

    public FuncionarioIdadeDTO funcionarioComMaiorIdade() {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();
        funcionarios.sort((a, b) -> a.getDataNascimento().compareTo(b.getDataNascimento()));

        FuncionarioModel maiorIdade = funcionarios.get(0);

        LocalDate dataNascimento = maiorIdade.getDataNascimento();
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();

        System.out.println(new FuncionarioIdadeDTO(maiorIdade.getNome(), idade));

        return new FuncionarioIdadeDTO(maiorIdade.getNome(), idade);
    }

    public List<FuncionarioModel> aniversariantesDoMes(List<Integer> meses) {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();

        List<FuncionarioModel> aniversariantesDoMes = funcionarios.stream().filter((func) -> {
            int mesNascimento = func.getDataNascimento().getMonthValue();

            return meses.contains(mesNascimento);

        }).collect(Collectors.toList());

        System.out.println(aniversariantesDoMes);

        return aniversariantesDoMes;
    }

    public Map<String, List<FuncionarioModel>> funcionariosPorFuncao() {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();

        Map<String, List<FuncionarioModel>> gruposPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(FuncionarioModel::getFuncao));

        System.out.println(gruposPorFuncao);

        return gruposPorFuncao;
    }
}
