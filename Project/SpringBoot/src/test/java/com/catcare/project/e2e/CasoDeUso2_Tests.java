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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("teste2ecaso2") // Se usa un perfil especifico para pruebas e2e
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CasoDeUso2_Tests {
    
    private final String BASE_URL = "http://localhost:4200";
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeEach
    public void init() {

        
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        // chromeOptions.addArguments("--headless");

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /* EDGE DRIVERS
        WebDriverManager.edgedriver().setup();

        EdgeOptions edgeOptions = new EdgeOptions();

        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--disable-extensions");
        // edgeOptions.addArguments("--headless");

        this.driver = new EdgeDriver(edgeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         */
    }

    @Test
    public void CasoDeUso2_Test(){

        driver.get(BASE_URL);
        driver.manage().window().maximize();

        WebElement botonLogIn = driver.findElement(By.id("btnLogIn"));
        botonLogIn.click();

        WebElement botonAdmin = driver.findElement(By.id("adminBtn"));
        botonAdmin.click();

        WebElement inputCedula = driver.findElement(By.id("AdmCedula"));
        WebElement inputContrasena= driver.findElement(By.id("AdmPassword"));
        inputCedula.sendKeys("9632"); 
        inputContrasena.sendKeys("1234"); 

        WebElement botonSigIn = driver.findElement(By.id("btnAdmSignin"));
        botonSigIn.click();

        WebElement botonDashBoard = driver.findElement(By.id("dashbord"));
        botonDashBoard.click();

        //Acá debes guardar los datos iniciales del dashboard
        //Ten en cuenta que las ganancias vienen con puntos y el cop y el signo $ entonces debes hacer que el dato llegue sin eso
        //Para traer los datos le haces lo de WebElement y luego parseas el texto del WebElement
        //Espero te rinda :)


        WebElement botonPerfil = driver.findElement(By.id("perfil"));
        botonPerfil.click();

        WebElement botonLogOut = driver.findElement(By.id("cerrarSesion"));
        botonLogOut.click();


        WebElement btnLoginVeterinario = driver.findElement(By.className("login"));
        btnLoginVeterinario.click();
        WebElement btnSeleccionVeterinario = driver.findElement(By.id("veterinarioBtn"));
        btnSeleccionVeterinario.click();

        WebElement inputCedulaVet = driver.findElement(By.id("VetCedula"));
        WebElement inputContrasenaVet = driver.findElement(By.id("VetPassword"));
        inputCedulaVet.sendKeys("78901234567805"); 
        inputContrasenaVet.sendKeys("k7l8"); 

        WebElement loginVeterinarioSubmit = driver.findElement(By.id("btnVetSignin"));
        loginVeterinarioSubmit.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("tratamientoLink")));
        WebElement inputBuscarMascota = driver.findElement(By.id("nameFilter"));
        inputBuscarMascota.sendKeys("Bella"); 

        
        List <WebElement> btnTratamiento = driver.findElements(By.className("tratamientoLink"));
        btnTratamiento.get(1).click();

        WebElement añadirFecha = driver.findElement(By.id("fechaDeInicio"));
        añadirFecha.clear();
        String fechaDeseada = "01/12/2023"; 
        añadirFecha.sendKeys(fechaDeseada);

        WebElement inputDroga = driver.findElement(By.id("droga"));
        inputDroga.click();

        List <WebElement> opcionesDroga = driver.findElements(By.className("opciones"));
        for(WebElement opciones: opcionesDroga){
            if(opciones.getText().equals("AMOXICILINA")){
                opciones.click();
                break;
            }
        }

        WebElement botonEnviarTratamiento = driver.findElement(By.id("botonEnviar"));
        botonEnviarTratamiento.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("tratamientoLink")));

        inputBuscarMascota = driver.findElement(By.id("nameFilter"));
        inputBuscarMascota.sendKeys("Bella"); 

        
        List <WebElement> btnHistorial = driver.findElements(By.className("historialLink"));
        btnHistorial.get(1).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("nombreDroga"))); 
        List<WebElement> listPacientes = driver.findElements(By.className("nombreDroga"));
        Assertions.assertThat(listPacientes.size()).isEqualTo(1); 

        WebElement botonPerfilVet = driver.findElement(By.id("btnPerfil"));
        botonPerfilVet.click();

        WebElement botonLogOutVet = driver.findElement(By.id("cerrarSesion"));
        botonLogOutVet.click();


    }
}
