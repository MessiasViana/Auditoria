package hook;

import br.com.AuditManage.Auditoria.AuditoriaApplication;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Hook {
    private static ConfigurableApplicationContext context;

    @Before
    public void setUp() {
        if (context == null) {
            context = SpringApplication.run(AuditoriaApplication.class);
            System.out.println("Ambiente inicializado.");
        }
    }


    @After
    public void tearDown() {
        // Aqui você pode fechar o contexto se necessário
        if (context != null) {
            context.close();
            context = null;
            System.out.println("Ambiente finalizado.");
        }
    }
}
