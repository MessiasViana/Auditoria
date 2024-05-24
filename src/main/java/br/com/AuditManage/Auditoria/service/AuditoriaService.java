package br.com.AuditManage.Auditoria.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.AuditManage.Auditoria.model.Auditoria;
import br.com.AuditManage.Auditoria.repository.AuditoriaRepository;

@Service
public class AuditoriaService {
	
	@Autowired
    private AuditoriaRepository auditoriaRepository;

	public Auditoria criarAuditoria(Auditoria auditoria) {
        if (!auditoriaJaMarcada(auditoria.getDataAgendada())) {
            return auditoriaRepository.save(auditoria);
        } else {
            throw new IllegalArgumentException("Já existe uma auditoria marcada para este horário.");
        }
    }

    private boolean auditoriaJaMarcada(LocalDateTime dataAgendada) {
        return auditoriaRepository.findByDataAgendada(dataAgendada).isPresent();
    }

    public List<Auditoria> listarTodasAuditorias() {
        return auditoriaRepository.findAll();
    }

    public Optional<Auditoria> obterAuditoriaPorId(Long id) {
        return auditoriaRepository.findById(id);
    }

    public void deletarAuditoria(Long id) {
        auditoriaRepository.deleteById(id);
    }

    public Auditoria atualizarAuditoria(Long id, Auditoria auditoriaAtualizada) {
        return auditoriaRepository.findById(id).map(auditoria -> {
            auditoria.setDescricao(auditoriaAtualizada.getDescricao());
            auditoria.setDataAgendada(auditoriaAtualizada.getDataAgendada());
            auditoria.setConcluida(auditoriaAtualizada.isConcluida());
            return auditoriaRepository.save(auditoria);
        }).orElseGet(() -> {
            auditoriaAtualizada.setId(id);
            return auditoriaRepository.save(auditoriaAtualizada);
        });
    }
}
