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
    public void CasoDeUso2_Test() {
        // Abre el sitio web y maximiza la ventana.
        driver.get(BASE_URL);
        driver.manage().window().maximize();

        // Inicia sesión como administrador.
        WebElement botonLogIn = driver.findElement(By.id("btnLogIn"));
        botonLogIn.click();

        // Busca el botón de administrador por su ID y hace clic en él para iniciar sesión como administrador.
        WebElement botonAdmin = driver.findElement(By.id("adminBtn"));
        botonAdmin.click();

        // Busca los campos de entrada para la cédula y la contraseña del administrador por sus IDs.
        WebElement inputCedula = driver.findElement(By.id("AdmCedula"));
        WebElement inputContrasena= driver.findElement(By.id("AdmPassword"));

        // Ingresa la cédula y la contraseña del administrador en los campos correspondientes.
        inputCedula.sendKeys("9632");
        inputContrasena.sendKeys("1234");

        WebElement botonSigIn = driver.findElement(By.id("btnAdmSignin"));
        botonSigIn.click();

        // Accede al panel de control y guarda los datos iniciales.
        WebElement botonDashBoard = driver.findElement(By.id("dashbord"));
        botonDashBoard.click();

        // Guardar los datos iniciales del dashboard
        WebElement totalMedicamentoVendido = driver.findElement(By.id("total-tratamientos"));
        int initialMedicamentoCount = Integer.parseInt(totalMedicamentoVendido.getText());

        WebElement ventasTotalesElem = driver.findElement(By.id("ganancias-totales"));
        String ventasText = ventasTotalesElem.getText().replace("$", "").replace("COP", "").replace(".", "").trim();
        double initialVentasTotales = Double.parseDouble(ventasText);

        // Cierra la sesión de administrador.
        WebElement botonPerfil = driver.findElement(By.id("perfil"));
        botonPerfil.click();

        WebElement botonLogOut = driver.findElement(By.id("cerrarSesion"));
        botonLogOut.click();

        // Inicia sesión como veterinario y realiza acciones.
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

        // Busca una mascota y realiza acciones sobre ella.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("tratamientoLink")));
        WebElement inputBuscarMascota = driver.findElement(By.id("nameFilter"));
        inputBuscarMascota.sendKeys("Bella");

        // Busca todos los elementos con la clase "tratamientoLink" y selecciona el segundo elemento de la lista (índice 1).
        List <WebElement> btnTratamiento = driver.findElements(By.className("tratamientoLink"));
        btnTratamiento.get(1).click();

        // Busca el campo de entrada para añadir una fecha por su ID y lo limpia.
        WebElement añadirFecha = driver.findElement(By.id("fechaDeInicio"));
        añadirFecha.clear();

        // Define la fecha deseada y la ingresa en el campo de fecha.
        String fechaDeseada = "30/10/2023";
        añadirFecha.sendKeys(fechaDeseada);

        // Busca el campo de entrada para seleccionar una droga por su ID y hace clic en él.
        WebElement inputDroga = driver.findElement(By.id("droga"));
        inputDroga.click();

        // Busca todas las opciones de drogas disponibles y selecciona "AMOXICILINA".
        List <WebElement> opcionesDroga = driver.findElements(By.className("opciones"));
        for(WebElement opciones: opcionesDroga){
            if(opciones.getText().equals("AMOXICILINA")){
                opciones.click();
                break;
            }
        }

        // Busca el botón para enviar el tratamiento y hace clic en él.
        WebElement botonEnviarTratamiento = driver.findElement(By.id("botonEnviar"));
        botonEnviarTratamiento.click();

        // Espera hasta que el elemento con la clase "tratamientoLink" esté presente.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("tratamientoLink")));

        // Busca el campo de entrada para buscar una mascota por su nombre y escribe "Bella".
        inputBuscarMascota = driver.findElement(By.id("nameFilter"));
        inputBuscarMascota.sendKeys("Bella");

        // Busca todos los elementos con la clase "historialLink" y selecciona el segundo elemento de la lista (índice 1) para ver el historial.
        List <WebElement> btnHistorial = driver.findElements(By.className("historialLink"));
        btnHistorial.get(1).click();

        // Espera hasta que el elemento con la clase "nombreDroga" esté presente.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("nombreDroga")));

        // Verifica que solo haya un paciente en la lista con el nombre de la droga.
        List<WebElement> listPacientes = driver.findElements(By.className("nombreDroga"));
        Assertions.assertThat(listPacientes.size()).isEqualTo(1);

        // Cierra la sesión de veterinario.
        WebElement botonPerfilVet = driver.findElement(By.id("btnPerfil"));
        botonPerfilVet.click();

        WebElement botonLogOutVet = driver.findElement(By.id("cerrarSesion"));
        botonLogOutVet.click();


        // Inicia sesión nuevamente como administrador y verifica los datos actualizados en el panel de control.
        botonLogIn = driver.findElement(By.id("btnLogIn"));
        botonLogIn.click();

        // Busca y hace clic en el botón de administrador.
        botonAdmin = driver.findElement(By.id("adminBtn"));
        botonAdmin.click();

        // Busca los campos de entrada para la cédula y contraseña del administrador.
        inputCedula = driver.findElement(By.id("AdmCedula"));
        inputContrasena= driver.findElement(By.id("AdmPassword"));

        // Ingresa la cédula y contraseña del administrador.
        inputCedula.sendKeys("9632");
        inputContrasena.sendKeys("1234");

        // Busca y hace clic en el botón para iniciar sesión.
        botonSigIn = driver.findElement(By.id("btnAdmSignin"));
        botonSigIn.click();

        // Busca y hace clic en el botón del tablero o dashboard.
        botonDashBoard = driver.findElement(By.id("dashbord"));
        botonDashBoard.click();

        // Espera hasta que los elementos del tablero estén presentes.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("total-tratamientos")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ganancias-totales")));

        // Busca y obtiene el total de medicamentos vendidos.
        WebElement updatedMedicamentoVendido = driver.findElement(By.id("total-tratamientos"));
        int updatedMedicamentoCount = Integer.parseInt(updatedMedicamentoVendido.getText());

        // Cálculo manual de los tratamientos añadidos
        int tratamientosAnadidos = updatedMedicamentoCount - initialMedicamentoCount;

        // Verificacion Manual de los tratamientos
        Assertions.assertThat(tratamientosAnadidos).isEqualTo(1); // Verifica que se haya añadido un tratamiento

        // Verifica que el total de medicamentos vendidos haya aumentado en 1.
        Assertions.assertThat(updatedMedicamentoCount).isEqualTo(initialMedicamentoCount + 1);

        // Busca y obtiene el total de ventas.
        WebElement updatedVentasTotalesElem = driver.findElement(By.id("ganancias-totales"));
        String updatedVentasText = updatedVentasTotalesElem.getText().replace("$", "").replace("COP", "").replace(".", "").trim();
        double updatedVentasTotales = Double.parseDouble(updatedVentasText);

        // Cálculo manual de las ganancias
        double ganancias = updatedVentasTotales - initialVentasTotales;
        Assertions.assertThat(ganancias).isGreaterThan(0); // Verifica que haya habido ganancias

        // Verifica que el total de ventas haya aumentado.
        Assertions.assertThat(updatedVentasTotales).isGreaterThan(initialVentasTotales);

        // Busca y hace clic en el botón de perfil del administrador.
        WebElement botonPerfilAdmin = driver.findElement(By.id("perfil"));
        botonPerfilAdmin.click();

        // Busca y hace clic en el botón para cerrar sesión del administrador.
        WebElement botonLogOutAdmin = driver.findElement(By.id("cerrarSesion"));
        botonLogOutAdmin.click();
    }
}