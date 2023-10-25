package com.catcare.project.e2e;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.catcare.project.Entity.Cliente;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("teste2e") // Se usa un perfil especifico para pruebas e2e
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CasoDeUso1_Tests {
    
    /*
        Descripción: Llega un usuario nuevo a la veterinaria con su mascota. El
        veterinario que está disponible en ese momento intenta ingresar con su usuario
        y contraseña al sistema. Este se equivoca la primera vez, sin embargo, al segundo
        intento logra ingresar sin ningún problema. Va a la sección de registro de
        clientes, pide los datos y da en el botón de “registrar”. Nuevamente el
        veterinario se equivoca en uno de los campos, corrige e intenta nuevamente. El
        cliente queda registrado. Posteriormente va a la sección de mascotas y registra la
        mascota asociándola al dueño. Esta vez todo sale bien a la primera.
        El veterinario pide al dueño que ingrese con su cedula a través del portal de
        clientes. Este ingresa y ve que los datos de la mascota son correctos. Se acaba la
        prueba.
     */

    private final String BASE_URL = "http://localhost:4200";
    private WebDriver driver;
    private WebDriverWait wait;

     
    // Se ejecuta antes de la prueba
    @BeforeEach
    public void init(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        // chromeOptions.addArguments("--headless");

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }


    @Test
    public void CasoDeUso1_Test(){

        driver.get(BASE_URL + "/administrador/veterinarios");

        // Se verifica que hay datos cargados para que el veterinario inicie sesión
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"patientTable\"]//tbody//tr[1]")));
        
        // Se pasa a la landing page
        WebElement btnPerfilAdmninistrador = driver.findElement(By.xpath("//html//body//app-root//app-administrador//div//app-barra-superior-administrador//header//div//ul//li[5]//a"));
        btnPerfilAdmninistrador.click();
            
        WebElement btnCerrarSesionAdministrador = driver.findElement(By.xpath("//html//body//app-root//app-administrador//div//app-barra-superior-administrador//header//div//ul//li[5]//div//a[1]"));
        btnCerrarSesionAdministrador.click();


        // DESARROLLO DEL CASO DE USO

        /*
        Llega un usuario nuevo a la veterinaria con su mascota.
        El veterinario que está disponible en ese momento intenta ingresar con su usuario y contraseña al sistema
        Este se equivoca la primera vez
        */

        WebElement btnLoginVeterinario = driver.findElement(By.xpath("//html//body//app-root//app-landing//header//nav//ul//li[5]//a"));
        btnLoginVeterinario.click();
        WebElement btnSeleccionVeterinario = driver.findElement(By.xpath("//*[@id=\"veterinarioBtn\"]"));
        btnSeleccionVeterinario.click();

        WebElement inputCedula = driver.findElement(By.xpath("//*[@id=\"VetCedula\"]"));
        WebElement inputContrasena= driver.findElement(By.xpath("//*[@id=\"VetPassword\"]"));
        inputCedula.sendKeys("123456789"); // Se equivoca la primera vez (Datos incorrectos)
        inputContrasena.sendKeys("123456789"); // Se equivoca la primera vez (Datos incorrectos)

        WebElement loginVeterinarioSubmit = driver.findElement(By.xpath("//*[@id=\"btnVetSignin\"]"));
        loginVeterinarioSubmit.click();
        Alert alert = driver.switchTo().alert();
        alert.accept(); // Se acepta la alerta de contrasena incorrecta

        // Al segundo intento logra ingresar sin ningún problema.
        inputCedula.clear();
        inputContrasena.clear();
        inputCedula.sendKeys("11112222");
        inputContrasena.sendKeys("1234");
        loginVeterinarioSubmit.click();

        // Va a la sección de registro de clientes
        WebElement btnSeccionClientes = driver.findElement(By.xpath("//html//body//app-root//app-veterinario//div//app-barra-superior-veterinario//header//div//ul//li[1]//a"));
        btnSeccionClientes.click();
        WebElement btnBarraLateralClientes = driver.findElement(By.xpath("//*[@id=\"logo\"]/i/img"));
        btnBarraLateralClientes.click();
        WebElement btnRegistrarClientes = driver.findElement(By.xpath("//*[@id=\"menu_side\"]//div[2]//a[3]//div//h4"));
        btnRegistrarClientes.click();

        // Pide los datos y da en el botón de “registrar”. Nuevamente el veterinario se equivoca en uno de los campos
        WebElement inputNombreCliente = driver.findElement(By.xpath("//*[@id=\"nombre\"]"));
        WebElement inputCedulaCliente = driver.findElement(By.xpath("//*[@id=\"cedula\"]"));
        WebElement inputCorreoCliente = driver.findElement(By.xpath("//*[@id=\"correo\"]"));
        WebElement inputCelularCliente = driver.findElement(By.xpath("//*[@id=\"celular\"]"));
        WebElement inputFotoCliente = driver.findElement(By.xpath("//*[@id=\"foto\"]"));
        String nombreCliente = "Juanito Angarita Castiblanco";
        inputNombreCliente.sendKeys(nombreCliente);
        String cedulaCliente = "787664";
        inputCedulaCliente.sendKeys(cedulaCliente);
        inputCorreoCliente.sendKeys("Juan."); // Se equivoca la primera vez (Dato incorrecto, correo no valido)
        inputCelularCliente.sendKeys("3162736456");
        inputFotoCliente.sendKeys("https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        WebElement btnEnviarRegistroCliente = driver.findElement(By.xpath("//html//body//app-root//app-veterinario//div//app-registrar-cliente//div//div//div//form//button"));
        btnEnviarRegistroCliente.click();
        alert.accept(); // Se acepta la alerta de formulario diligenciado incorrectamente

        // Corrige e intenta nuevamente.
        inputCorreoCliente.clear();
        inputCorreoCliente.sendKeys("juanitoAngaCast@gmail.com");
        btnEnviarRegistroCliente.click();

        // El cliente queda registrado.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"patientTable\"]//tbody//tr"))); // Se espera a que carguen los datos, dado a que se carga otra pagina
        List<WebElement> listClientes = driver.findElements(By.xpath("//*[@id=\"patientTable\"]//tbody//tr"));
        Assertions.assertThat(listClientes.size()).isEqualTo(5); // Quinto cliente registrado

        // Posteriormente va a la sección de mascotas
        WebElement btnSeccionPacientes = driver.findElement(By.xpath("//html//body//app-root//app-veterinario//div//app-barra-superior-veterinario//header//div//ul//li[2]//a"));
        btnSeccionPacientes.click();
        WebElement btnBarraLateralPacientes = driver.findElement(By.xpath("//*[@id=\"logo\"]//i//img"));
        btnBarraLateralPacientes.click();
        WebElement btnRegistrarPacientes = driver.findElement(By.xpath("//*[@id=\"menu_side\"]//div[2]//a[3]//div//h4"));
        btnRegistrarPacientes.click();

        // Y registra la mascota asociándola al dueño
        WebElement inputNombrePaciente = driver.findElement(By.xpath("//*[@id=\"nombre\"]"));
        WebElement inputRazaPaciente = driver.findElement(By.xpath("//*[@id=\"raza\"]"));
        WebElement inputEdadPaciente = driver.findElement(By.xpath("//*[@id=\"edad\"]"));
        WebElement inputPesoPaciente = driver.findElement(By.xpath("//*[@id=\"peso\"]"));
        WebElement inputEnfermedadPaciente = driver.findElement(By.xpath("//*[@id=\"enfermedad\"]"));
        WebElement inputEstadoPaciente = driver.findElement(By.xpath("//*[@id=\"estado\"]"));
        WebElement inputFotoPaciente = driver.findElement(By.xpath("//*[@id=\"foto\"]"));
        WebElement inputDuenoPaciente = driver.findElement(By.xpath("//*[@id=\"cliente\"]"));
        String nombrePaciente = "Paquito";
        String razaPaciente = "Siamés";
        String edadPaciente = "5";
        String pesoPaciente = "10";
        String enfermedadPaciente = "Moquillo";

        inputNombrePaciente.sendKeys(nombrePaciente);
        inputRazaPaciente.sendKeys(razaPaciente);
        inputEdadPaciente.sendKeys(edadPaciente);
        inputPesoPaciente.sendKeys(pesoPaciente);
        inputEnfermedadPaciente.sendKeys(enfermedadPaciente);
        inputFotoPaciente.sendKeys("https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg");

        Select selectEstadoPaciente = new Select(inputEstadoPaciente); // Campo de seleccion
        selectEstadoPaciente.selectByValue("Activo");
        Select selectDuenoPaciente = new Select(inputDuenoPaciente); // Campo de seleccion
        List<WebElement> options = selectDuenoPaciente.getOptions();
        int lastOptionIndex = options.size() - 1; // Ultimo cliente agregado
        selectDuenoPaciente.selectByIndex(lastOptionIndex);

        WebElement btnEnviarRegistroPaciente = driver.findElement(By.xpath("//html//body//app-root//app-veterinario//div//app-registrar-paciente//div//div//div//form//button"));
        btnEnviarRegistroPaciente.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"patientTable\"]//tbody//tr"))); // Se espera a que carguen los datos, dado a que se carga otra pagina
        List<WebElement> listPacientes = driver.findElements(By.xpath("//*[@id=\"patientTable\"]//tbody//tr"));
        Assertions.assertThat(listPacientes.size()).isEqualTo(1); // Primera mascota registrada

        // El veterinario pide al dueño que ingrese con su cedula a través del portal de clientes. 
        WebElement btnPerfilVeterinarioPaciente = driver.findElement(By.xpath("//html//body//app-root//app-veterinario//div//app-barra-superior-veterinario//header//div//ul//li[3]//a"));
        btnPerfilVeterinarioPaciente.click();
            
        WebElement btnCerrarSesionVeterinarioPaciente = driver.findElement(By.xpath("//html//body//app-root//app-veterinario//div//app-barra-superior-veterinario//header//div//ul//li[3]//div//a[1]"));
        btnCerrarSesionVeterinarioPaciente.click();

        // Este ingresa y ve que los datos de la mascota son correctos. 
        WebElement btnLoginCliente = driver.findElement(By.xpath("//html//body//app-root//app-landing//header//nav//ul//li[5]//a"));
        btnLoginCliente.click();
        WebElement btnSeleccionCliente = driver.findElement(By.xpath("//*[@id=\"clienteBtn\"]"));
        btnSeleccionCliente.click();
        WebElement inputCedulaClienteLogin = driver.findElement(By.xpath("//*[@id=\"CliCedula\"]"));
        inputCedulaClienteLogin.sendKeys(cedulaCliente);
        WebElement loginClienteSubmit = driver.findElement(By.xpath("//*[@id=\"btnCliSignin\"]"));
        loginClienteSubmit.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"patientTable\"]//tbody//tr[last()]//td[1]"))); // Se espera a que carguen los datos, dado a que se carga otra pagina
        WebElement outputtNombrePaciente = driver.findElement(By.xpath("//*[@id=\"patientTable\"]//tbody//tr[last()]//td[1]"));
        WebElement outputRazaPaciente = driver.findElement(By.xpath("//*[@id=\"patientTable\"]//tbody//tr[last()]//td[2]"));
        WebElement outputEdadPaciente = driver.findElement(By.xpath("//*[@id=\"patientTable\"]//tbody//tr[last()]//td[3]"));
        WebElement outputPesoPaciente = driver.findElement(By.xpath("//*[@id=\"patientTable\"]//tbody//tr[last()]//td[4]"));
        WebElement outputEnfermedadPaciente = driver.findElement(By.xpath("//*[@id=\"patientTable\"]//tbody//tr[last()]//td[5]"));
        Assertions.assertThat(outputtNombrePaciente.getText()).isEqualTo(nombrePaciente);
        Assertions.assertThat(outputRazaPaciente.getText()).isEqualTo(razaPaciente);
        Assertions.assertThat(outputEdadPaciente.getText()).isEqualTo(edadPaciente);
        Assertions.assertThat(outputPesoPaciente.getText()).isEqualTo(pesoPaciente);
        Assertions.assertThat(outputEnfermedadPaciente.getText()).isEqualTo(enfermedadPaciente);

        // Se acaba la prueba.

    }


    /*
    // Se puede apagar durante el desarrollo de pruebas para verificar el estado final de la misma
    @AfterEach
    void tearDown(){
        driver.quit();
    }
    */

    
}
