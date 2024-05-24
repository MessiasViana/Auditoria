package br.com.AuditManage.Auditoria.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.AuditManage.Auditoria.model.Auditoria;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long>{
	Optional<Auditoria> findByDataAgendada(LocalDateTime dataAgendada);
}
