package br.com.AuditManage.Auditoria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.AuditManage.Auditoria.model.Auditoria;
import br.com.AuditManage.Auditoria.service.AuditoriaService;

@RestController
@RequestMapping("/api/auditorias")
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    @PostMapping
    public ResponseEntity<?> criarAuditoria(@RequestBody Auditoria auditoria) {
        try {
            Auditoria criada = auditoriaService.criarAuditoria(auditoria);
            return ResponseEntity.ok("Auditoria criada com sucesso com ID: " + criada.getId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Auditoria>> listarTodasAuditorias() {
        List<Auditoria> auditorias = auditoriaService.listarTodasAuditorias();
        return ResponseEntity.ok(auditorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterAuditoriaPorId(@PathVariable Long id) {
        Optional<Auditoria> auditoria = auditoriaService.obterAuditoriaPorId(id);
        
        if(auditoria.isPresent()) {
        	return ResponseEntity.ok(auditoria);
        } else {
        	return ResponseEntity.status(404).body("Auditoria não encontrada com ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAuditoria(@PathVariable Long id) {
        Optional<Auditoria> auditoriaOpt = auditoriaService.obterAuditoriaPorId(id);
        if (auditoriaOpt.isPresent()) {
            auditoriaService.deletarAuditoria(id);
            return ResponseEntity.ok("Auditoria removida com sucesso com ID: " + id);
        } else {
            return ResponseEntity.status(404).body("Auditoria não encontrada com ID: " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarAuditoria(@PathVariable Long id, @RequestBody Auditoria auditoria) {
        Optional<Auditoria> auditoriaOpt = auditoriaService.obterAuditoriaPorId(id);
        if (auditoriaOpt.isPresent()) {
            Auditoria atualizada = auditoriaService.atualizarAuditoria(id, auditoria);
            return ResponseEntity.ok(atualizada);
        } else {
            return ResponseEntity.status(404).body("Auditoria não encontrada com ID: " + id);
        }
    }
}
