package com.catcare.project.Entity;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import com.catcare.project.Repository.AdministradorRepository;
import com.catcare.project.Repository.ClienteRepository;
import com.catcare.project.Repository.DrogaRepository;
import com.catcare.project.Repository.PacienteRepository;
import com.catcare.project.Repository.TratamientoRepository;
import com.catcare.project.Repository.VeterinarioRepository;

import java.io.InputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;


import jakarta.transaction.Transactional;

@Controller
@Transactional
@Profile("teste2e")
public class DatabaseInitTest implements ApplicationRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    VeterinarioRepository veterinarioRepository;

    @Autowired
    DrogaRepository drogaRepository;

    @Autowired
    TratamientoRepository tratamientoRepository;

    @Autowired
    AdministradorRepository administradorRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Cargue de medicamentos desde el archivo Excel.
        cargarMedicamentosDesdeExcel();



        // Inicializacion de administradores
        administradorRepository.save(new Administrador("9632", "LuisBravo", "1234"));
        administradorRepository.save(new Administrador("8521","FelipeGarcia", "1234"));
        administradorRepository.save(new Administrador("7410","AnaOrtegon", "1234"));
        administradorRepository.save(new Administrador("7896","JuanAngarita", "1234"));



        // Inicialización e inserción  de la base de datos con clientes
        clienteRepository.save(new Cliente("1111", "Luis Alejandro Bravo Ferreira", "luis.bravof@javeriana.edu.co", "3162858895", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("2222", "Felipe Garcia Castiblanco", "felipe.gar@javeriana.edu.co", "32424234334", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("3333", "Ana María Ortegón Sepulveda", "ana.ortegon@javeriana.edu.co", "43242423434", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("4444", "Juan Angarita", "juan.angarita@javeriana.edu.co", "3244342312", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));



        // Inicialización e inserción  de la base de datos con pacientes (mascotas)
        /*
        pacienteRepository.save(new Paciente("Max", "Abisinio", 3, 25.5, "Fiebre", "Activo", "https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg"));
        pacienteRepository.save(new Paciente("Bella", "Persa", 2, 7.8, "Tos", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Charlie", "Siames", 4, 22.0, "Dolor de estómago", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        pacienteRepository.save(new Paciente("Luna", "Maine Coon", 1, 5.5, "Alergia", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        pacienteRepository.save(new Paciente("Cooper", "Ragdoll ", 5, 10.2, "Gripe", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        pacienteRepository.save(new Paciente("Lucy", "Cornish Rex", 2, 8.3, "Fiebre", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
        pacienteRepository.save(new Paciente("Oliver", "Cornish Rex", 3, 15.7, "Tos", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        pacienteRepository.save(new Paciente("Daisy", "Devon Rex", 2, 6.9, "Dolor de estómago", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        */


        // Inicialización e inserción  de la base de datos con veterinarios       
        veterinarioRepository.save(new Veterinario("11112222", "Luisa Ortega", "1234", "Pediatría", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("33334444", "Miguel Urtado", "1234", "Traumatología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
    

    }
       


    // Cargue de medicamentos del excel
    private void cargarMedicamentosDesdeExcel() throws Exception {
        InputStream is = getClass().getResourceAsStream("/MEDICAMENTOS_VETERINARIA.xlsx");
        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);
    
        List<Droga> drogas = new ArrayList<>();
    
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
    
            String nombre = row.getCell(0).getStringCellValue();
            float precioVenta = (float) row.getCell(1).getNumericCellValue();
            float precioCompra = (float) row.getCell(2).getNumericCellValue();
            int unidadesDisponibles = (int) row.getCell(3).getNumericCellValue();
            int unidadesVendidas = (int) row.getCell(4).getNumericCellValue();
    
            Droga droga = new Droga(nombre, precioVenta, precioCompra, unidadesDisponibles, unidadesVendidas);
            drogas.add(droga);
        }
    
        drogaRepository.saveAll(drogas); 
        workbook.close();
    }


    
}