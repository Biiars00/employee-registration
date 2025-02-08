package registration_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import registration_system.model.FuncionarioModel;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {

}
