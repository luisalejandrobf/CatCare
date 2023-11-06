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
@Profile("teste2ecaso2")
public class DatabaseInitTest2 implements ApplicationRunner {

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
        Administrador administrador = new Administrador("9632", "LuisBravo", "1234");
        administradorRepository.save(administrador);
        administrador = new Administrador("8521","FelipeGarcia", "1234");
        administradorRepository.save(administrador);
        administrador = new Administrador("7410","AnaOrtegon", "1234");
        administradorRepository.save(administrador);
        administrador = new Administrador("7896","JuanAngarita", "1234");
        administradorRepository.save(administrador);


        // Inicialización e inserción  de la base de datos con clientes

        clienteRepository.save(new Cliente("63453415345789", "Alejandro Hernandez", "Alejandro12314@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("2242352235345", "Valentina Sanchez", "Valentina53@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("7823523532490", "Felipe Ramirez", "Felipe6343@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("236134631464345", "Julia Martinez", "Carolina235@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("7235325623890", "Andrés Mendoza", "Andres523@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("123622136234", "Juan Hernandez", "Juan535@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("223652323623323", "Lalo Perez", "Lalo234523@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("332422335434", "Sofía Torres", "Sofia231@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("562312363278", "María Gutierrez", "Maria323@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("3324132323562456", "Luisa Ortega", "Luisa231@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("672323632689", "Alejandro Hernandez", "Alejandro121@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("23423121324235345", "Valentina Sanchez", "Valentina12434@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("726223236590", "Felipe Ramirez", "Felipe12423@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("2332431312456245", "Julia Martinez", "Carolina345@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("783642652590", "Pepito Mendoza", "Pepito342@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("122362232623534", "Juan Hernandez", "Juan321@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("233242362323523", "Juan Perez", "Juan212@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("3432423432423434", "Sofía Torres", "Sofia423@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("53246235262678", "María Gutierrez", "Elena1211@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("34622352312456", "Luisa Ortega", "Luisa124@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("6262323423554789", "Alejandro Hernandez", "Alejandro1242@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("2332423523675445", "Valentina Sanchez", "Valentina121@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("78236234234230", "Felipe Ramirez", "Felipe12@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("234245632476235", "Julia Martinez", "Carolina1212@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("45253252325235", "Juanita Lopez", "juanitaLp1213@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));


         // Inicialización e inserción  de la base de datos con pacientes (mascotas)
        pacienteRepository.save(new Paciente("Max", "Abisinio", 3, 25.5, "Fiebre", "Activo", "https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg"));
        pacienteRepository.save(new Paciente("Bella", "Persa", 2, 7.8, "Tos", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Charlie", "Siames", 4, 22.0, "Dolor de estómago", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        pacienteRepository.save(new Paciente("Luna", "Maine Coon", 1, 5.5, "Alergia", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        pacienteRepository.save(new Paciente("Cooper", "Ragdoll ", 5, 10.2, "Gripe", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        pacienteRepository.save(new Paciente("Lucy", "Cornish Rex", 2, 8.3, "Fiebre", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
        pacienteRepository.save(new Paciente("Oliver", "Cornish Rex", 3, 15.7, "Tos", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        pacienteRepository.save(new Paciente("Daisy", "Devon Rex", 2, 6.9, "Dolor de estómago", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        pacienteRepository.save(new Paciente("Rocky", "Abisinio", 4, 20.1, "Alergia", "Activo","https://www.semana.com/resizer/QulPdczfzOqr_eiEznThKXUUA4s=/1280x720/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/JE2JDQ2GR5G7ZKS5MBDFR5THTE.jpg"));
        pacienteRepository.save(new Paciente("Molly", "British Shorthair", 1, 7.2, "Gripe", "Activo","https://www.infobae.com/new-resizer/xh88gZVUaYWydCiAgN49rAfUhGI=/arc-anglerfish-arc2-prod-infobae/public/UZS53SVISJHAHBC4PDQBVHX52M.jpeg"));
        pacienteRepository.save(new Paciente("Buddy", "Scottish Fold", 5, 12.6, "Fiebre", "Activo","https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/22/media/cortadas/gato-fotolia-k8eH-U160340519019xEE-1248x770@Las%20Provincias.jpg"));
        pacienteRepository.save(new Paciente("Sophie", "American Shorthair", 2, 9.7, "Tos", "Activo","https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg"));
        pacienteRepository.save(new Paciente("Jack", "Scottish Fold", 3, 18.4, "Dolor de estómago", "Activo","https://estaticos-cdn.sport.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg"));
        pacienteRepository.save(new Paciente("Sadie", "Devon Rex", 2, 6.3, "Alergia", "Activo","https://www.elpais.com.co/resizer/zzMtz3dP412md6YrxomGW0wk2ZY=/1280x0/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/VUG44EJGYRCU3K4P7FH67RXMBQ.jpg"));
        pacienteRepository.save(new Paciente("Tucker", "Siames", 4, 22.3, "Gripe", "Activo","https://fotografias.lasexta.com/clipping/cmsimages02/2018/07/18/54202C79-C95C-4589-8C76-4CC8DB96E85C/98.jpg?crop=960,540,x0,y0&width=1900&height=1069&optimize=high&format=webply"));
        pacienteRepository.save(new Paciente("Chloe", "Devon Rex", 1, 5.8, "Fiebre", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Bear", "Siames", 5, 11.0, "Tos", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Zoe", "Siames", 2, 7.6, "Dolor de estómago", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Duke", "Ragdoll ", 3, 16.9, "Alergia", "Activo","https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2021/04/siames-scaled.jpg?fit=2560%2C1707&quality=50&strip=all&ssl=1"));
        pacienteRepository.save(new Paciente("Mia", "Devon Rex", 2, 7.1, "Gripe", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/220px-Cat_November_2010-1a.jpg"));
        pacienteRepository.save(new Paciente("Leo", "Siames", 4, 21.7, "Fiebre", "Activo","https://as01.epimg.net/diarioas/imagenes/2022/04/20/actualidad/1650466413_240889_1650466661_noticia_normal_recorte1.jpg"));
        pacienteRepository.save(new Paciente("Coco", "Siames", 1, 6.0, "Tos", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        pacienteRepository.save(new Paciente("Milo", "Siames", 5, 13.2, "Dolor de estómago", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        pacienteRepository.save(new Paciente("Rosie", "Siames", 2, 8.7, "Alergia", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        pacienteRepository.save(new Paciente("Finn", "Siames", 3, 19.3, "Gripe", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
       
        


        // Inicialización e inserción  de la base de datos con veterinarios       
        
        veterinarioRepository.save(new Veterinario("34567890123459", "Gabriela Graciela Peña", "o8p9", "Neurocirugía", "https://img.freepik.com/fotos-premium/feliz-veterinaria-doctora-sosteniendo-gato-pie-hospital-veterinario_116547-67769.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("45678901234560", "Homero Héctor Ortega", "q0r1", "Nefrología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("56789012345671", "Isabel Ivonne Olivares", "s2t3", "Oftalmología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("67890123456782", "Julián Jorge Osorio", "u4v5", "Anestesiología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("78901234567893", "Karla Karina Ortega", "w6x7", "Oncología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Inactivo"));
        veterinarioRepository.save(new Veterinario("89012345678904", "León Leonardo Palacios", "y8z9", "Hematología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("90123456789015", "Mónica Mariana Páez", "a0b1", "Reumatología", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("01234567890126", "Nelson Nicolás Rincón", "c2d3", "Infectología", "https://img.freepik.com/fotos-premium/medico-veterinario-comprobando-gato-clinica-veterinaria_255667-35310.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("12345678901237", "Óscar Orlando Romero", "e4f5", "Dermatología", "https://img.freepik.com/fotos-premium/gato-mesa-mientras-veterinario-guapo-examinando_85574-7701.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("23456789012349", "Pamela Patricia Rojas", "g6h7", "Pediatría", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("34567890123450", "René Ricardo Ruiz", "i8j9", "Cardiología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("45678901234561", "Sonia Susana Soto", "k0l1", "Gastroenterología", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("56789012345672", "Tania Tatiana Torres", "m2n3", "Endocrinología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("67890123456783", "Ubaldo Ulises Vargas", "o4p5", "Radiología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("78901234567894", "Viviana Vanessa Velasco", "q6r7", "Traumatología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("89012345678905", "Wilson Wilfredo Vera", "s8t9", "Neurología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("90123456789016", "Xavier Ximeno Villanueva", "u0v1", "Urología", "https://img.freepik.com/fotos-premium/gato-mesa-mientras-veterinario-guapo-examinando_85574-7701.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("01234567890127", "Yolanda Yaneth Zambrano", "w2x3", "Neurocirugía", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("12345678901238", "Zacarías Zenón Zapata", "y4z5", "Nefrología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("23456789012350", "Ariadna Andrea Arango", "a7b8", "Cardiología", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("34567890123461", "Bruno Benjamín Blanco", "c9d0", "Dermatología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("45678901234572", "Camila Carolina Cifuentes", "e1f2", "Neurología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Inactivo"));
        veterinarioRepository.save(new Veterinario("56789012345683", "Damián David Díaz", "g3h4", "Gastroenterología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("67890123456794", "Elena Estefanía Espinosa", "i5j6", "Radiología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        veterinarioRepository.save(new Veterinario("78901234567805", "Felipe Francisco Fuentes", "k7l8", "Traumatología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"));
        

        
        //Inicialización e inserción  de la base de datos con los tratamientos 
        Random random = new Random(1);

        List<Long> pacienteIds = pacienteRepository.findAllIds();
        List<Long> drogaIds = drogaRepository.findAllIds();
        List<Long> veterinarioIds = veterinarioRepository.findAllIds();

        for (int i = 0; i < 25; i++) {
            long pacienteId = pacienteIds.get(random.nextInt(pacienteIds.size()));
            long drogaId = drogaIds.get(random.nextInt(drogaIds.size()));
            long veterinarioId = veterinarioIds.get(random.nextInt(veterinarioIds.size()));

            Paciente paciente = pacienteRepository.findById(pacienteId).orElse(null);

            // When Unidades disponibles > 0
            // Then crear un tratamiento para la mascota
            // And modificar unidades disponibles y unidades vendidas
            Droga droga = drogaRepository.findById(drogaId).orElse(null);
            if (droga.getUnidadesDisponibles()==0){
                continue; // Saltar
            }
            else {
                droga.setUnidadesDisponibles(droga.getUnidadesDisponibles()-1);
                droga.setUnidadesVendidas(droga.getUnidadesVendidas()+1);
                drogaRepository.save(droga);
            }


            Veterinario veterinario = veterinarioRepository.findById(veterinarioId).orElse(null);

            if(paciente != null && droga != null && veterinario != null) {
                Tratamiento tratamiento = new Tratamiento();
                tratamiento.setPaciente(paciente);
                tratamiento.setDroga(droga);
                tratamiento.setVeterinario(veterinario);
                tratamiento.setFechaDeInicio(new java.sql.Date(System.currentTimeMillis())); // Fecha actual como ejemplo
                tratamientoRepository.save(tratamiento);
            }
        }
        

        // Crear Tratamientos para el paciente y veterinario con ID 1 (Tests)
        if (true) {
            Paciente paciente = pacienteRepository.findById(1L).orElse(null);
            Veterinario veterinario = veterinarioRepository.findById(1L).orElse(null);
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.setPaciente(paciente);
            long drogaId = drogaIds.get(random.nextInt(drogaIds.size()));
            Droga droga = drogaRepository.findById(drogaId).orElse(null);
            tratamiento.setDroga(droga);
            droga.setUnidadesDisponibles(droga.getUnidadesDisponibles()-1);
            droga.setUnidadesVendidas(droga.getUnidadesVendidas()+1);
            drogaRepository.save(droga);
            tratamiento.setVeterinario(veterinario);
            tratamiento.setFechaDeInicio(new java.sql.Date(System.currentTimeMillis())); // Current date as an example

            tratamientoRepository.save(tratamiento);
        } 



        // Relacionar clientes con mascotas
        // Relacionar 25 clientes con 4 pacientes cada uno
        List<Cliente> clientes = clienteRepository.findAll();
        List<Paciente> pacientes = pacienteRepository.findAll();

        for (int i = 0; i < 25; i++) {
            Cliente cliente = clientes.get(i);
        
                Paciente paciente = pacientes.get(i);
                paciente.setCliente(cliente); // Al paciente se le asigna el cliente
                pacienteRepository.save(paciente);
                // cliente.getPacientes().add(paciente); // Al cliente se le asigna el paciente
            // clienteRepository.save(cliente);
        }
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