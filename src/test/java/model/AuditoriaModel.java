package model;

import com.google.gson.annotations.Expose;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuditoriaModel {

    @Expose(serialize = false)
    private Long id;

    @Expose
    private String descricao;

    @Expose
    private String dataAgendada;

    @Expose
    private boolean concluida;
}
