package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

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
