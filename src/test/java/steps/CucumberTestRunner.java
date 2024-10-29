package steps;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",  // Caminho para os arquivos .feature
    glue = {"steps"}  // Pacote onde estão os arquivos com os steps definidos
)
public class CucumberTestRunner {

}
