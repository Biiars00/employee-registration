package registration_system.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import registration_system.dto.AniversariantesDoMesDTO;
import registration_system.dto.FuncionarioDTO;
import registration_system.dto.FuncionarioIdadeDTO;
import registration_system.dto.FuncionarioSalarioDTO;
import registration_system.model.FuncionarioModel;
import registration_system.service.FuncionarioService;

@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping(path = "/api-iniflex/listar-funcionarios")
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios() {
        List<FuncionarioDTO> funcionarios = funcionarioService.listarFuncionarios();

        if (funcionarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping(path = "/api-iniflex/cadastrar-funcionario")
    public ResponseEntity<FuncionarioModel> cadastrarFuncionario(@RequestBody FuncionarioModel dadosDoFuncionario) {
        FuncionarioModel funcionario = funcionarioService.cadastrarFuncionario(dadosDoFuncionario);

        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping(path = "/api-iniflex/remover-funcionario/{id}")
    public ResponseEntity<Void> removerFuncionario(@PathVariable("id") Long id) {
        funcionarioService.removerFuncionario(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/api-iniflex/aumentar-salarios")
    public ResponseEntity<List<FuncionarioDTO>> aumentarSalario(
            @RequestBody Map<String, BigDecimal> percentualSalario) {
        BigDecimal aumentoSalarial = percentualSalario.get("salario");

        List<FuncionarioDTO> salariosAtualizados = funcionarioService.aumentarSalario(aumentoSalarial);

        return ResponseEntity.ok(salariosAtualizados);
    }

    @GetMapping(path = "/api-iniflex/total-salarios")
    public ResponseEntity<String> totalDeSalarios() {
        String salarios = funcionarioService.totalDeSalarios();

        return ResponseEntity.ok(salarios);
    }

    @GetMapping(path = "/api-iniflex/quantidade-salarios-minimos")
    public ResponseEntity<List<FuncionarioSalarioDTO>> quantidadeSalariosMinimos() {
        List<FuncionarioSalarioDTO> quantidadeDeSalarios = funcionarioService.quantidadeSalariosMinimos();

        return ResponseEntity.ok(quantidadeDeSalarios);
    }

    @GetMapping(path = "/api-iniflex/funcionario-maior-idade")
    public ResponseEntity<FuncionarioIdadeDTO> funcionarioComMaiorIdade() {
        FuncionarioIdadeDTO funcionario = funcionarioService.funcionarioComMaiorIdade();

        return ResponseEntity.ok(funcionario);
    }

    @PostMapping(path = "/api-iniflex/aniversariantes-mes")
    public ResponseEntity<List<FuncionarioModel>> aniversariantesDoMes(@RequestBody AniversariantesDoMesDTO meses) {
        List<FuncionarioModel> aniversariantes = funcionarioService.aniversariantesDoMes(meses.getMeses());

        return ResponseEntity.ok(aniversariantes);
    }

    @GetMapping(path = "/api-iniflex/funcionarios-funcao")
    public ResponseEntity<Map<String, List<FuncionarioModel>>> funcionariosPorFuncao() {
        Map<String, List<FuncionarioModel>> funcionarios = funcionarioService.funcionariosPorFuncao();

        return ResponseEntity.ok(funcionarios);
    }
}
