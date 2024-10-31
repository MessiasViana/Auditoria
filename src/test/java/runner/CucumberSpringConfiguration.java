package runner;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.AuditManage.Auditoria.AuditoriaApplication;
import org.springframework.test.context.TestPropertySource;

@CucumberContextConfiguration
@TestPropertySource(properties = "server.port=8080")
@SpringBootTest(classes =
        {AuditoriaApplication.class,CucumberTests.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberSpringConfiguration {
}
