package com.catcare.project.Entity;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import com.catcare.project.Repository.AdministradorRepository;
import com.catcare.project.Repository.ClienteRepository;
import com.catcare.project.Repository.DrogaRepository;
import com.catcare.project.Repository.PacienteRepository;
import com.catcare.project.Repository.RoleRepository;
import com.catcare.project.Repository.TratamientoRepository;
import com.catcare.project.Repository.UserRepository;
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
@Profile("default")
public class DatabaseInit implements ApplicationRunner {

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

    // Security
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    private UserEntity saveUserAdministrador(Administrador administrador){
        UserEntity user = new UserEntity();
        user.setUsername(administrador.getCedula());
        user.setPassword(passwordEncoder.encode(administrador.getContrasena()));
        Role roles = roleRepository.findByName("ADMINISTRADOR").get();
        user.setRoles(List.of(roles));
        return userRepository.save(user);
    }

    private UserEntity saveUserVeterinario(Veterinario veterinario){
        UserEntity user = new UserEntity();
        user.setUsername(veterinario.getCedula());
        user.setPassword(passwordEncoder.encode(veterinario.getContrasena()));
        Role roles = roleRepository.findByName("VETERINARIO").get();
        user.setRoles(List.of(roles));
        return userRepository.save(user);
    }

    private UserEntity saveUserCliente(Cliente cliente){
        UserEntity user = new UserEntity();
        user.setUsername(cliente.getCedula());
        user.setPassword(passwordEncoder.encode("123"));
        Role roles = roleRepository.findByName("CLIENTE").get();
        user.setRoles(List.of(roles));
        return userRepository.save(user);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Cargue de medicamentos desde el archivo Excel.
        cargarMedicamentosDesdeExcel();



        // SECURITY

        // Create roles
        roleRepository.save(new Role("ADMINISTRADOR"));
        roleRepository.save(new Role("VETERINARIO"));
        roleRepository.save(new Role("CLIENTE"));

        // SECURITY STEPS
        // 1. Crear objeto
        // 2. Guardar en tabla user
        // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        // 4. Guardar el objeto en la tabla respectiva

        Administrador administradorSave;
        Veterinario veterinarioSave;
        Cliente clienteSave;

        UserEntity userEntity;



        // Inicializacion de administradores
        // USAR EL PATRÓN BUILDER PARA CREAR LAS INSTANCIAS DE 1 DE SUS ENTIDADES

        // Administrador 1
        administradorSave = new Administrador().builder().cedula("9632").usuario("LuisBravo").contrasena("1234").build(); // 1. Crear objeto
        // Administrador administrador = new Administrador("9632", "LuisBravo", "1234");
        userEntity = saveUserAdministrador(administradorSave); // 2. Guardar en tabla user
        administradorSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        administradorRepository.save(administradorSave); // 4. Guardar el objeto en la tabla respectiva
        //
        // Administrador 2
        administradorSave = new Administrador().builder().cedula("8521").usuario("FelipeGarcia").contrasena("1234").build();
        // administrador = new Administrador("8521","FelipeGarcia", "1234");
        userEntity = saveUserAdministrador(administradorSave);
        administradorSave.setUser(userEntity);
        administradorRepository.save(administradorSave);
        // Administrador 3
        administradorSave = new Administrador().builder().cedula("7410").usuario("AnaOrtegon").contrasena("1234").build();
        // administrador = new Administrador("7410","AnaOrtegon", "1234");
        userEntity = saveUserAdministrador(administradorSave);
        administradorSave.setUser(userEntity);
        administradorRepository.save(administradorSave);
        //
        // Administrador 4
        administradorSave = new Administrador().builder().cedula("7896").usuario("JuanAngarita").contrasena("1234").build();
        // administrador = new Administrador("7896","JuanAngarita", "1234");
        userEntity = saveUserAdministrador(administradorSave);
        administradorSave.setUser(userEntity);
        administradorRepository.save(administradorSave);



        // Inicialización e inserción  de la base de datos con clientes
        clienteSave = new Cliente("12211351234", "Luis Alejandro Bravo Ferreira", "luis.bravof@javeriana.edu.co", "3162858895", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"); // 1. Crear el objeto
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("231113124523", "Felipe Garcia Castiblanco", "felipe.gar@javeriana.edu.co", "32424234334", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("231523532523", "Ana María Ortegón Sepulveda", "ana.ortegon@javeriana.edu.co", "43242423434", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("5132532523", "María García Pérez", "Maria.garcia2131@hotmail.com", "3112345678", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("15435235234", "Ana Martínez González", "ana.martinez54352@gmail.com", "3334567890", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("15215141231", "Carlos Sánchez Ruiz", "carlos.sanchez234234@hotmail.com", "3445678901", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("21415151213", "Isabel López Ramírez", "isabel.lopez123@gmail.com", "3556789012", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("34542352134", "Andrés Hernández Herrera", "andres23.hernandez@gmail.com", "3667890123", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2115145121412", "Waldina López", "wald.lopez414@gmail.com", "3556789012", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM=");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("5443421134", "Hernando Hernández Herrera", "hernando15.hernandez@gmail.com", "3667890123", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("5426416", "Juan Romero", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2343153253253223", "Andrés Medina", "Andres515@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("431125355345345", "Sofía Mendoza", "Sofia12@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("51435345435678", "Daniela Castro", "Daniela234324@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("3434534543556", "Luisa Delgado", "Luisa213123@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("167345345345819", "Alejandro Silva", "Alejandro34234@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2354335345415", "Valentina Morales", "Valentina12313@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("435345345314534", "Felipe Morales", "Felipe214214@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2343453451345", "Carolina Romero ", "Carolina213213@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM=");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("78345345143590", "Andrés Rodriguez", "AndresR14@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("1345435134234", "Carlos Martinez", "Carlossss23@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2334531454323", "Ulises Lopez", "Ulisessss12@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("33453145434", "Sofía Gonzalez", "Sofia23@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("5345345678", "Karla Lopez", "Karla122@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("3435134534456", "Luisa Flores", "Luisaaaa121@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("6734534514389", "Alejandro Rivera", "Alejandro12@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2334541353445", "Isabella Torres", "Isabella123@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("74351435345890", "Felipe Morales", "Felipe2323@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("23454354315345", "Natalia Flores", "Natalia23@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM=");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("78345311453490", "Gabriel Ramirez", "Gabriel2323@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("123453454334", "Juan Gonzalez", "Juan2323@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("23453454135323", "Andrés Hernandez", "Andres2323@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("34345345143534", "Raquel Ramirez", "Raquel12313@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("53453453145678", "María Martinez", "Maria123213@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("34345314543556", "Valentina Ramirez", "Valentina2131231@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("6783453453459", "Ricardo Ortega", "Ricardo21321314@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2334534543541345", "Natalia Cruz", "Natalia2323@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("785345113453453490", "Felipe Sanchez", "Felipe2323@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("23345345145", "Natalia Martinez", "Natalia12@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM=");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("785345134543590", "Andrés Garcia", "Andres12@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("1234531454334", "Juan Rodriguez", "Juan323@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2334534111523", "Andrés Perez", "Andres1212@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("33453451435434", "Sofía Torres", "Sofia2133@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("53454351435678", "María Reyes", "Maria23234@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("3345345435456", "Luisa Gonzalez", "Luisa443@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("67345314543589", "Alejandro Hernandez", "Alejandro3434@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("233453411545", "Valentina Sanchez", "Valentina2323@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("7843534154390", "Felipe Ramirez", "Felipe11@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("234351134545", "Ximena Ortega", "Ximena111@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM=");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("78341534534590", "Andrés Mendoza", "Andres1212@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("123411111534534", "Gabriel Hernandez", "Gabriel1212@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2334151114354323", "Hugo Gonzalez", "Hugo1212@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("34345111134534534", "Sofía Torres", "Sofia2323231@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("56345113114578", "Laura Ramirez", "Laura43@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("34411111113534534556", "Gabriela Mendoza", "Gabriela23@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("67431534534589", "Eduardo Ortega", "Eduardo12@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2435341534345", "Valentina Sanchez", "Valentina123@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("7834534154390", "Tomas Ramirez", "Tomas35@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2334534534545", "Carolina Ortiz", "Carolina6767@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM=");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("7534541135890", "Andrés Mendoza", "Andres67@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("12435411354334", "Luis Rodriguez", "Luis5656@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2334511134523", "Carlos Garcia", "Carlos45@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("3345435413434", "Fernanda Hernandez", "Fernanda34@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("534531111452378", "Laura Gonzalez", "Laura53@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("3413111412434534556", "Luisa Ramirez", "Luisa122@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("678314534549", "Ivan Ortega", "Ivan323@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("233411534543545", "Valentina Sanchez", "Valentina12134@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("7834154315390", "Felipe Ramirez", "Felipe23231@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("23463416345", "Carolina Ortiz", "Carolina12323@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM=");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("73463461345890", "Andrés Mendoza", "Andres122@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("1213453454334", "Juan Hernandez", "Juan1213@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("23346131463423", "Andrés Perez", "Andres1132@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("34234312434", "Sofía Torres", "Sofia12442@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("563453456413638", "Valentina Martinez", "Valentina232434@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("345134634634566", "Luisa Ortega", "Luisa1244@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("63453415345789", "Alejandro Hernandez", "Alejandro12314@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2242352235345", "Valentina Sanchez", "Valentina53@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("7823523532490", "Felipe Ramirez", "Felipe6343@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("236134631464345", "Julia Martinez", "Carolina235@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM=");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("7235325623890", "Andrés Mendoza", "Andres523@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("123622136234", "Juan Hernandez", "Juan535@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("223652323623323", "Lalo Perez", "Lalo234523@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("332422335434", "Sofía Torres", "Sofia231@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("562312363278", "María Gutierrez", "Maria323@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("3324132323562456", "Luisa Ortega", "Luisa231@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("672323632689", "Alejandro Hernandez", "Alejandro121@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("23423121324235345", "Valentina Sanchez", "Valentina12434@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("726223236590", "Felipe Ramirez", "Felipe12423@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2332431312456245", "Julia Martinez", "Carolina345@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM=");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("783642652590", "Pepito Mendoza", "Pepito342@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("122362232623534", "Juan Hernandez", "Juan321@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("233242362323523", "Juan Perez", "Juan212@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("3432423432423434", "Sofía Torres", "Sofia423@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("53246235262678", "María Gutierrez", "Elena1211@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("34622352312456", "Luisa Ortega", "Luisa124@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("6262323423554789", "Alejandro Hernandez", "Alejandro1242@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("2332423523675445", "Valentina Sanchez", "Valentina121@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("78236234234230", "Felipe Ramirez", "Felipe12@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("234245632476235", "Julia Martinez", "Carolina1212@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM=");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva
        //
        clienteSave = new Cliente("45253252325235", "Juanita Lopez", "juanitaLp1213@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM=");
        userEntity = saveUserCliente(clienteSave); // 2. Guardar en tabla user
        clienteSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        clienteRepository.save(clienteSave); // 4. Guardar el objeto en la tabla respectiva



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
        pacienteRepository.save(new Paciente("Ruby", "Devon Rex", 2, 7.9, "Fiebre", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Collage_of_Six_Cats-02.jpg/800px-Collage_of_Six_Cats-02.jpg"));
        pacienteRepository.save(new Paciente("Oscar", "Ragdoll ", 4, 23.8, "Tos", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        pacienteRepository.save(new Paciente("Lily", "Maine Coon", 1, 5.3, "Dolor de estómago", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        pacienteRepository.save(new Paciente("Teddy", "Siames", 5, 10.7, "Alergia", "Activo","https://www.semana.com/resizer/QulPdczfzOqr_eiEznThKXUUA4s=/1280x720/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/JE2JDQ2GR5G7ZKS5MBDFR5THTE.jpg"));
        pacienteRepository.save(new Paciente("Abby", "Siames", 2, 9.1, "Gripe", "Activo","https://www.infobae.com/new-resizer/xh88gZVUaYWydCiAgN49rAfUhGI=/arc-anglerfish-arc2-prod-infobae/public/UZS53SVISJHAHBC4PDQBVHX52M.jpeg"));
        pacienteRepository.save(new Paciente("Cody", "Maine Coon", 3, 17.5, "Fiebre", "Activo","https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/22/media/cortadas/gato-fotolia-k8eH-U160340519019xEE-1248x770@Las%20Provincias.jpg"));
        pacienteRepository.save(new Paciente("Zara", "Devon Rex", 2, 6.6, "Tos", "Activo", "https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg"));
        pacienteRepository.save(new Paciente("Jackson", "Siames", 4, 20.4, "Dolor de estómago", "Activo","https://estaticos-cdn.sport.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg"));
        pacienteRepository.save(new Paciente("Nala", "Siames", 1, 7.5, "Alergia", "Activo","https://www.elpais.com.co/resizer/zzMtz3dP412md6YrxomGW0wk2ZY=/1280x0/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/VUG44EJGYRCU3K4P7FH67RXMBQ.jpg"));
        pacienteRepository.save(new Paciente("Riley", "Siames", 5, 14.1, "Gripe", "Activo","https://fotografias.lasexta.com/clipping/cmsimages02/2018/07/18/54202C79-C95C-4589-8C76-4CC8DB96E85C/98.jpg?crop=960,540,x0,y0&width=1900&height=1069&optimize=high&format=webply"));
        pacienteRepository.save(new Paciente("Maggie", "Devon Rex", 2, 8.9, "Fiebre", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Winston", "Ragdoll ", 3, 16.2, "Tos", "Activo","https://images.milenio.com/JUFQtwNFWKlYiQGCTPVgfyD0-BM=/345x237/uploads/media/2020/02/20/tener-un-gatito-podria-tener.jpg"));
        pacienteRepository.save(new Paciente("Lola", "Siames", 2, 7.2, "Dolor de estómago", "Activo","https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg"));
        pacienteRepository.save(new Paciente("Sam", "Maine Coon", 4, 22.9, "Alergia", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Layla", "Siames", 1, 6.7, "Gripe", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Zeus", "Siames", 5, 11.8, "Fiebre", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/220px-Cat_November_2010-1a.jpg"));
        pacienteRepository.save(new Paciente("Gracie", "Siames", 2, 9.5, "Tos", "Activo","https://as01.epimg.net/diarioas/imagenes/2022/04/20/actualidad/1650466413_240889_1650466661_noticia_normal_recorte1.jpg"));
        pacienteRepository.save(new Paciente("Hunter", "Siames", 3, 18.7, "Dolor de estómago", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        pacienteRepository.save(new Paciente("Cleo", "Siames", 2, 6.2, "Alergia", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        pacienteRepository.save(new Paciente("Harley", "Ragdoll ", 4, 21.0, "Gripe", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        pacienteRepository.save(new Paciente("Penny", "Maine Coon", 1, 5.6, "Fiebre", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
        pacienteRepository.save(new Paciente("Jax", "Siames", 5, 12.0, "Tos", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Collage_of_Six_Cats-02.jpg/800px-Collage_of_Six_Cats-02.jpg"));
        pacienteRepository.save(new Paciente("Sasha", "Siames", 2, 7.8, "Dolor de estómago", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        pacienteRepository.save(new Paciente("Maverick", "Siames", 3, 17.3, "Alergia", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        pacienteRepository.save(new Paciente("Nina", "Siames", 2, 8.1, "Gripe", "Activo","https://www.semana.com/resizer/QulPdczfzOqr_eiEznThKXUUA4s=/1280x720/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/JE2JDQ2GR5G7ZKS5MBDFR5THTE.jpg"));
        pacienteRepository.save(new Paciente("Rusty", "Ragdoll ", 4, 22.1, "Fiebre", "Activo","https://www.infobae.com/new-resizer/xh88gZVUaYWydCiAgN49rAfUhGI=/arc-anglerfish-arc2-prod-infobae/public/UZS53SVISJHAHBC4PDQBVHX52M.jpeg"));
        pacienteRepository.save(new Paciente("Mila", "Maine Coon", 1, 6.4, "Tos", "Activo","https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/22/media/cortadas/gato-fotolia-k8eH-U160340519019xEE-1248x770@Las%20Provincias.jpg"));
        pacienteRepository.save(new Paciente("Prince", "Siames", 5, 13.5, "Dolor de estómago", "Activo","https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg"));
        pacienteRepository.save(new Paciente("Willow", "Siames", 2, 9.0, "Alergia", "Activo","https://estaticos-cdn.sport.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg"));
        pacienteRepository.save(new Paciente("Sammy", "Siames", 3, 19.9, "Gripe", "Activo","https://www.elpais.com.co/resizer/zzMtz3dP412md6YrxomGW0wk2ZY=/1280x0/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/VUG44EJGYRCU3K4P7FH67RXMBQ.jpg"));
        pacienteRepository.save(new Paciente("Ivy", "Maine Coon", 2, 7.4, "Fiebre", "Activo","https://fotografias.lasexta.com/clipping/cmsimages02/2018/07/18/54202C79-C95C-4589-8C76-4CC8DB96E85C/98.jpg?crop=960,540,x0,y0&width=1900&height=1069&optimize=high&format=webply"));
        pacienteRepository.save(new Paciente("Loki", "Ragdoll ", 4, 23.0, "Tos", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Piper", "Siames", 1, 5.1, "Dolor de estómago", "Activo","https://images.milenio.com/JUFQtwNFWKlYiQGCTPVgfyD0-BM=/345x237/uploads/media/2020/02/20/tener-un-gatito-podria-tener.jpg"));
        pacienteRepository.save(new Paciente("Toby", "Devon Rex", 5, 10.3, "Alergia", "Activo","https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg"));
        pacienteRepository.save(new Paciente("Hazel", "Siames", 2, 8.2, "Gripe", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Axel", "Siames", 3, 15.2, "Fiebre", "Activo","https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2021/04/siames-scaled.jpg?fit=2560%2C1707&quality=50&strip=all&ssl=1"));
        pacienteRepository.save(new Paciente("Emma", "Ragdoll ", 2, 6.8, "Tos", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/220px-Cat_November_2010-1a.jpg"));
        pacienteRepository.save(new Paciente("Chase", "Siames", 4, 20.5, "Dolor de estómago", "Activo","https://as01.epimg.net/diarioas/imagenes/2022/04/20/actualidad/1650466413_240889_1650466661_noticia_normal_recorte1.jpg"));
        pacienteRepository.save(new Paciente("Lilly", "Siames", 1, 7.7, "Alergia", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        pacienteRepository.save(new Paciente("Dexter", "Siames", 5, 12.4, "Gripe", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        pacienteRepository.save(new Paciente("Lola", "Maine Coon", 2, 9.3, "Fiebre", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        pacienteRepository.save(new Paciente("Gus", "Maine Coon", 3, 18.1, "Tos", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
        pacienteRepository.save(new Paciente("Lulu", "Devon Rex", 2, 7.0, "Dolor de estómago", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Collage_of_Six_Cats-02.jpg/800px-Collage_of_Six_Cats-02.jpg"));
        pacienteRepository.save(new Paciente("Kobe", "Siames", 4, 21.2, "Alergia", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        pacienteRepository.save(new Paciente("Cupcake", "Siames", 1, 5.4, "Gripe", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        pacienteRepository.save(new Paciente("Rex", "Siames", 5, 11.5, "Fiebre", "Activo","https://www.semana.com/resizer/QulPdczfzOqr_eiEznThKXUUA4s=/1280x720/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/JE2JDQ2GR5G7ZKS5MBDFR5THTE.jpg"));
        pacienteRepository.save(new Paciente("Mocha", "Siames", 2, 8.5, "Tos", "Activo","https://www.infobae.com/new-resizer/xh88gZVUaYWydCiAgN49rAfUhGI=/arc-anglerfish-arc2-prod-infobae/public/UZS53SVISJHAHBC4PDQBVHX52M.jpeg"));
        pacienteRepository.save(new Paciente("Apollo", "Siames", 3, 16.5, "Dolor de estómago", "Activo","https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/22/media/cortadas/gato-fotolia-k8eH-U160340519019xEE-1248x770@Las%20Provincias.jpg"));
        pacienteRepository.save(new Paciente("Ella", "Maine Coon", 2, 6.1, "Alergia", "Activo","https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg"));
        pacienteRepository.save(new Paciente("Hunter", "Ragdoll ", 4, 22.5, "Gripe", "Activo","https://estaticos-cdn.sport.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg"));
        pacienteRepository.save(new Paciente("Minnie", "Devon Rex", 1, 7.4, "Fiebre", "Activo","https://www.elpais.com.co/resizer/zzMtz3dP412md6YrxomGW0wk2ZY=/1280x0/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/VUG44EJGYRCU3K4P7FH67RXMBQ.jpg"));
        pacienteRepository.save(new Paciente("Louie", "Devon Rex", 5, 12.9, "Tos", "Activo","https://fotografias.lasexta.com/clipping/cmsimages02/2018/07/18/54202C79-C95C-4589-8C76-4CC8DB96E85C/98.jpg?crop=960,540,x0,y0&width=1900&height=1069&optimize=high&format=webply"));
        pacienteRepository.save(new Paciente("Harper", "Siames", 2, 9.2, "Dolor de estómago", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Bruno", "Siames", 3, 17.8, "Alergia", "Activo","https://images.milenio.com/JUFQtwNFWKlYiQGCTPVgfyD0-BM=/345x237/uploads/media/2020/02/20/tener-un-gatito-podria-tener.jpg"));
        pacienteRepository.save(new Paciente("Maddie", "Devon Rex", 2, 7.3, "Gripe", "Activo","https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg"));
        pacienteRepository.save(new Paciente("Oliver", "Siames", 4, 20.8, "Fiebre", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Ziggy", "Siames", 1, 5.7, "Tos", "Activo","https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2021/04/siames-scaled.jpg?fit=2560%2C1707&quality=50&strip=all&ssl=1"));
        pacienteRepository.save(new Paciente("Carter", "Maine Coon", 5, 11.2, "Dolor de estómago", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/220px-Cat_November_2010-1a.jpg"));
        pacienteRepository.save(new Paciente("Penelope", "Siames", 2, 8.4, "Alergia", "Activo","https://as01.epimg.net/diarioas/imagenes/2022/04/20/actualidad/1650466413_240889_1650466661_noticia_normal_recorte1.jpg"));
        pacienteRepository.save(new Paciente("Rocco", "Siames", 3, 19.1, "Gripe", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        pacienteRepository.save(new Paciente("Honey", "Maine Coon", 2, 6.5, "Fiebre", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        pacienteRepository.save(new Paciente("Rusty", "Siames", 4, 21.8, "Tos", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        pacienteRepository.save(new Paciente("Nova", "Siames", 1, 7.3, "Dolor de estómago", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
        pacienteRepository.save(new Paciente("Hank", "Devon Rex", 5, 12.3, "Alergia", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Collage_of_Six_Cats-02.jpg/800px-Collage_of_Six_Cats-02.jpg"));
        pacienteRepository.save(new Paciente("Sunny", "Maine Coon", 2, 8.6, "Gripe", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        pacienteRepository.save(new Paciente("Marley", "Siames", 3, 17.0, "Fiebre", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        pacienteRepository.save(new Paciente("Gigi", "Ragdoll ", 2, 6.7, "Tos", "Activo","https://www.semana.com/resizer/QulPdczfzOqr_eiEznThKXUUA4s=/1280x720/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/JE2JDQ2GR5G7ZKS5MBDFR5THTE.jpg"));
        pacienteRepository.save(new Paciente("Koda", "Siames", 4, 20.0, "Dolor de estómago", "Activo","https://www.infobae.com/new-resizer/xh88gZVUaYWydCiAgN49rAfUhGI=/arc-anglerfish-arc2-prod-infobae/public/UZS53SVISJHAHBC4PDQBVHX52M.jpeg"));
        pacienteRepository.save(new Paciente("Olive", "Maine Coon", 1, 7.9, "Alergia", "Activo","https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/22/media/cortadas/gato-fotolia-k8eH-U160340519019xEE-1248x770@Las%20Provincias.jpg"));
        pacienteRepository.save(new Paciente("Brutus", "Maine Coon", 5, 12.7, "Gripe", "Activo","https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg"));
        pacienteRepository.save(new Paciente("Lizzie", "Siames", 2, 8.0, "Fiebre", "Activo","https://estaticos-cdn.sport.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg"));
        pacienteRepository.save(new Paciente("Riley", "Maine Coon", 3, 18.5, "Tos", "Activo","https://www.elpais.com.co/resizer/zzMtz3dP412md6YrxomGW0wk2ZY=/1280x0/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/VUG44EJGYRCU3K4P7FH67RXMBQ.jpg"));
        pacienteRepository.save(new Paciente("Lola", "Siames", 2, 6.4, "Dolor de estómago", "Activo","https://fotografias.lasexta.com/clipping/cmsimages02/2018/07/18/54202C79-C95C-4589-8C76-4CC8DB96E85C/98.jpg?crop=960,540,x0,y0&width=1900&height=1069&optimize=high&format=webply"));
        pacienteRepository.save(new Paciente("Cash", "Maine Coon", 4, 21.4, "Alergia", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Mochi", "Siames", 1, 7.1, "Gripe", "Activo","https://images.milenio.com/JUFQtwNFWKlYiQGCTPVgfyD0-BM=/345x237/uploads/media/2020/02/20/tener-un-gatito-podria-tener.jpg"));



        // Inicialización e inserción  de la base de datos con veterinarios       
        veterinarioSave = new Veterinario("67890123456789", "Luisa Ortega", "1234", "Pediatría", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo"); // 1. Crear el objeto
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("78901234567890", "Miguel Urtado", "m3n4", "Traumatología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("89012345678901", "Ana Morales", "o5p6", "Radiología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("90123456789012", "Jorge Salinas", "q7r8", "Endocrinología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("01234567890123", "Sandra Bullock", "s9t0", "Gastroenterología", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("12345678901234", "Carlos Mena", "a1b2", "Cardiología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Inactivo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("23456789012345", "Martina Ruiz", "c3d4", "Dermatología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("34567890123456", "Juan Pérez", "e5f6", "Neurología", "https://img.freepik.com/fotos-premium/gato-mesa-mientras-veterinario-guapo-examinando_85574-7701.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("45678901234567", "Gabriela Torres", "g1h2", "Urología", "https://img.freepik.com/foto-gratis/veterinario-cuidando-mascota_23-2149198624.jpg?size=626&ext=jpg&ga=GA1.2.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("56789012345678", "Roberto Méndez", "i3j4", "Neurocirugía", "https://img.freepik.com/fotos-premium/medico-veterinario-comprobando-gato-clinica-veterinaria_255667-35310.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("678901123456789", "Andrea Fernández", "k5l6", "Nefrología", "https://img.freepik.com/fotos-premium/feliz-veterinaria-doctora-sosteniendo-gato-pie-hospital-veterinario_116547-67769.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("789012324567890", "David Morán", "m7n8", "Oftalmología", "https://img.freepik.com/fotos-premium/experto-veterinario-examina-salud-gatito-chequeo-rutina-clinica-ai_894067-8651.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=ais", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("890123453678901", "Paula Vargas", "o9p0", "Anestesiología", "https://img.freepik.com/fotos-premium/retrato-joven-veterinario-dos-gatos-sobre-fondo-blanco-ia-generativa_634053-8266.jpg?size=626&ext=jpg&ga=GA1.2.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("901234567489012", "Antonio Aguilar", "q1r2", "Oncología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("012345678950123", "Patricia Castillo", "s3t4", "Hematología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("123456789016234", "Enrique Montoya", "u5v6", "Reumatología", "https://img.freepik.com/fotos-premium/gato-mesa-mientras-veterinario-guapo-examinando_85574-7701.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("234567890123745", "Luisa Peña", "w7x8", "Infectología", "https://img.freepik.com/foto-gratis/veterinario-cuidando-mascota_23-2149198624.jpg?size=626&ext=jpg&ga=GA1.2.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("3456789012345986", "Jorge Salazar", "y9z0", "Dermatología", "https://img.freepik.com/fotos-premium/medico-veterinario-comprobando-gato-clinica-veterinaria_255667-35310.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("456789012345607", "Sandra Mora", "a0b1", "Pediatría", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("567089012345678", "Rafael Estrada", "c2d3", "Cardiología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("678900123456789", "Carmen Ortiz", "e4f5", "Gastroenterología", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Inactivo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("789012304567890", "Miguel Ángel Ramírez", "g6h7", "Endocrinología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("890123450678901", "Verónica Guzmán", "i8j9", "Radiología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("901230456789012", "Adrián Blanco", "k0l1", "Traumatología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("012345607890123", "Bárbara Muñoz", "m2n3", "Neurología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("123450678901234", "Carlos Alberto Cruz", "o4p5", "Urología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("234567890012345", "Diana Carolina Soto", "q6r7", "Neurocirugía", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("345067890123456", "Fernando Martín Gómez", "s8t9", "Nefrología", "https://img.freepik.com/fotos-premium/gato-mesa-mientras-veterinario-guapo-examinando_85574-7701.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("456078901234567", "Gloria Patricia Díaz", "u0v1", "Oftalmología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("567890012345678", "Hector Manuel Rojas", "w2x3", "Anestesiología", "https://img.freepik.com/fotos-premium/medico-veterinario-comprobando-gato-clinica-veterinaria_255667-35310.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Inactivo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("678901023456789", "Iván Darío Torres", "y4z5", "Oncología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("780901234567890", "Javier Enrique Rodríguez", "a6b7", "Hematología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("890123456708901", "Karen Johana Rincón", "c8d9", "Reumatología", "https://img.freepik.com/foto-gratis/veterinario-cuidando-mascota_23-2149198624.jpg?size=626&ext=jpg&ga=GA1.2.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("901234560789012", "Laura Victoria Gómez", "e0f1", "Infectología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("012034567890123", "Manuel Alejandro Pérez", "g2h3", "Dermatología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("102345678901234", "Natalia Andrea Ramírez", "i4j5", "Pediatría", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("234567890102345", "Óscar Julián Martínez", "k6l7", "Cardiología", "https://img.freepik.com/fotos-premium/gato-mesa-mientras-veterinario-guapo-examinando_85574-7701.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("345678901230456", "Paola Andrea Castro", "m8n9", "Gastroenterología", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("456789012345067", "Ricardo José Vargas", "o0p1", "Endocrinología", "https://img.freepik.com/fotos-premium/medico-veterinario-comprobando-gato-clinica-veterinaria_255667-35310.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Inactivo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("567890123456708", "Sandra Milena Pinto", "q2r3", "Radiología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("678090123456789", "Tomás Antonio Morales", "s4t5", "Traumatología", "https://img.freepik.com/fotos-premium/experto-veterinario-examina-salud-gatito-chequeo-rutina-clinica-ai_894067-8651.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=ais", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("708901234567890", "Viviana Marcela Suárez", "u6v7", "Neurología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("890012345678901", "Walter Enrique Peña", "w8x9", "Urología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("901023456789012", "Yolanda del Pilar Moreno", "y0z1", "Neurocirugía", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("012304567890123", "Zulma Yaneth Ortiz", "a2b3", "Nefrología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("123450678901234", "Alfonso Rafael Castillo", "c4d5", "Oftalmología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("234567089012345", "Beatriz Elena Guzmán", "e6f7", "Anestesiología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("345678900123456", "César Augusto Rincón", "g8h9", "Oncología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("456789010234567", "Dora Liliana Romero", "i0j1", "Hematología", "https://img.freepik.com/foto-gratis/veterinario-cuidando-mascota_23-2149198624.jpg?size=626&ext=jpg&ga=GA1.2.42545629.1693093912&semt=sph", "Inactivo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("567890123045678", "Ernesto Antonio Vargas", "k2l3", "Reumatología", "https://img.freepik.com/fotos-premium/gato-mesa-mientras-veterinario-guapo-examinando_85574-7701.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("678901234506789", "Fanny Carolina Díaz", "m4n5", "Infectología", "https://img.freepik.com/foto-gratis/veterinario-cuidando-mascota_23-2149198624.jpg?size=626&ext=jpg&ga=GA1.2.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("789012345670890", "Germán Alberto Torres", "o6p7", "Dermatología", "https://img.freepik.com/fotos-premium/medico-veterinario-comprobando-gato-clinica-veterinaria_255667-35310.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("890123456789001", "Hernán Darío Gómez", "q8r9", "Pediatría", "https://img.freepik.com/fotos-premium/experto-veterinario-examina-salud-gatito-chequeo-rutina-clinica-ai_894067-8651.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=ais", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("1234567890123004", "Katia Marcela Pérez", "w4x5", "Endocrinología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("023456789012346", "Leonardo Fabián López", "y6z7", "Radiología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("304567890123457", "Mariana Patricia García", "a8b9", "Traumatología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("450678901234568", "Nicolas Enrique Martínez", "c0d1", "Neurología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("567089012345679", "Olga Lucía Hernández", "e2f3", "Urología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("678900123456780", "Pedro Juan Guerra", "g4h5", "Neurocirugía", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("789010234567891", "Quintín Rafael Vega", "i6j7", "Nefrología", "https://img.freepik.com/fotos-premium/gato-mesa-mientras-veterinario-guapo-examinando_85574-7701.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("890123045678902", "Ramiro Samuel Ruiz", "k8l9", "Oftalmología", "https://img.freepik.com/fotos-premium/medico-veterinario-comprobando-gato-clinica-veterinaria_255667-35310.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("901234506789013", "Silvia Tatiana Mora", "m0n1", "Anestesiología", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("012345670890124", "Tomás Ulises Ramírez", "o2p3", "Oncología", "https://img.freepik.com/fotos-premium/experto-veterinario-examina-salud-gatito-chequeo-rutina-clinica-ai_894067-8651.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=ais", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("123456789001235", "Úrsula Valentina Pérez", "q4r5", "Hematología", "https://img.freepik.com/foto-gratis/veterinario-cuidando-mascota_23-2149198624.jpg?size=626&ext=jpg&ga=GA1.2.42545629.1693093912&semt=sph", "Inactivo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("234567890102347", "Víctor Valentín Gómez", "s6t7", "Reumatología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("345678901230458", "Walter William Morales", "u8v9", "Infectología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("456789012345069", "Ximena Yolanda Díaz", "w0x1", "Dermatología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("567890123456700", "Yahir Zachary Castro", "y2z3", "Pediatría", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("678901234567810", "Zara Zoe Salazar", "a4b5", "Cardiología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("078901234567892", "Alessandro Antonio Vargas", "c6d7", "Gastroenterología", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("809012345678903", "Blanca Beatriz Salinas", "e8f9", "Endocrinología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("900123456789014", "Catalina Claudia Serrano", "g0h1", "Radiología", "https://img.freepik.com/fotos-premium/feliz-veterinaria-doctora-sosteniendo-gato-pie-hospital-veterinario_116547-67769.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("012034567890125", "Dario Diego Torres", "i2j3", "Traumatología", "https://img.freepik.com/fotos-premium/gato-mesa-mientras-veterinario-guapo-examinando_85574-7701.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("123405678901236", "Ernesto Efraín Pinto", "k4l5", "Neurología", "https://img.freepik.com/fotos-premium/medico-veterinario-comprobando-gato-clinica-veterinaria_255667-35310.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("234560789012348", "Fernanda Fabiola Parra", "m6n7", "Urología", "https://img.freepik.com/foto-gratis/veterinario-cuidando-mascota_23-2149198624.jpg?size=626&ext=jpg&ga=GA1.2.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("345678090123459", "Gabriela Graciela Peña", "o8p9", "Neurocirugía", "https://img.freepik.com/fotos-premium/feliz-veterinaria-doctora-sosteniendo-gato-pie-hospital-veterinario_116547-67769.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("456789001234560", "Homero Héctor Ortega", "q0r1", "Nefrología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("567890120345671", "Isabel Ivonne Olivares", "s2t3", "Oftalmología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("678901234056782", "Julián Jorge Osorio", "u4v5", "Anestesiología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("789012345607893", "Karla Karina Ortega", "w6x7", "Oncología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Inactivo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("890123456780904", "León Leonardo Palacios", "y8z9", "Hematología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("901234567890015", "Mónica Mariana Páez", "a0b1", "Reumatología", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("012345678901206", "Nelson Nicolás Rincón", "c2d3", "Infectología", "https://img.freepik.com/fotos-premium/medico-veterinario-comprobando-gato-clinica-veterinaria_255667-35310.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("123456789012370", "Óscar Orlando Romero", "e4f5", "Dermatología", "https://img.freepik.com/fotos-premium/gato-mesa-mientras-veterinario-guapo-examinando_85574-7701.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("203456789012349", "Pamela Patricia Rojas", "g6h7", "Pediatría", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("340567890123450", "René Ricardo Ruiz", "i8j9", "Cardiología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("456078901234561", "Sonia Susana Soto", "k0l1", "Gastroenterología", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("567809012345672", "Tania Tatiana Torres", "m2n3", "Endocrinología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("678900123456783", "Ubaldo Ulises Vargas", "o4p5", "Radiología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("789012034567894", "Viviana Vanessa Velasco", "q6r7", "Traumatología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("890123405678905", "Wilson Wilfredo Vera", "s8t9", "Neurología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("901234560789016", "Xavier Ximeno Villanueva", "u0v1", "Urología", "https://img.freepik.com/fotos-premium/gato-mesa-mientras-veterinario-guapo-examinando_85574-7701.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("012345678090127", "Yolanda Yaneth Zambrano", "w2x3", "Neurocirugía", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("123456789001238", "Zacarías Zenón Zapata", "y4z5", "Nefrología", "https://img.freepik.com/fotos-premium/joven-guapo-barba_251136-3566.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("234567890120350", "Ariadna Andrea Arango", "a7b8", "Cardiología", "https://img.freepik.com/foto-gratis/acercamiento-al-medico-veterinario-cuidando-mascota_23-2149267966.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("345678901234061", "Bruno Benjamín Blanco", "c9d0", "Dermatología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("456789012345702", "Camila Carolina Cifuentes", "e1f2", "Neurología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100168.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Inactivo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("567890123456830", "Damián David Díaz", "g3h4", "Gastroenterología", "https://img.freepik.com/fotos-premium/joven-veterinario-asiatico-matorrales-anteojos-examina-gato-mascota_448865-3730.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("678090123456794", "Elena Estefanía Espinosa", "i5j6", "Radiología", "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva
        //
        veterinarioSave = new Veterinario("789012304567805", "Felipe Francisco Fuentes", "k7l8", "Traumatología", "https://img.freepik.com/foto-gratis/veterinario-masculino-que-examina-infeccion-oido-gato-otoscopio-clinica-veterinaria_613910-21567.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph", "Activo");
        userEntity = saveUserVeterinario(veterinarioSave); // 2. Guardar en tabla user
        veterinarioSave.setUser(userEntity); // 3. Agregar al objeto del paso 1 el ID obtenido en el paso 2.
        veterinarioRepository.save(veterinarioSave); // 4. Guardar el objeto en la tabla respectiva


        
        //Inicialización e inserción  de la base de datos con los tratamientos 
        Random random = new Random();

        List<Long> pacienteIds = pacienteRepository.findAllIds();
        List<Long> drogaIds = drogaRepository.findAllIds();
        List<Long> veterinarioIds = veterinarioRepository.findAllIds();

        for (int i = 0; i < 100; i++) {
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
        } else {
            // Nothing
        }




        // Relacionar clientes con mascotas
        // Relacionar 25 clientes con 4 pacientes cada uno
        List<Cliente> clientes = clienteRepository.findAll();
        List<Paciente> pacientes = pacienteRepository.findAll();

        for (int i = 0; i < 25; i++) {
            Cliente cliente = clientes.get(i);
        
            for (int j = 0; j < 4; j++) {
                Paciente paciente = pacientes.get(i * 4 + j);
                paciente.setCliente(cliente); // Al paciente se le asigna el cliente
                pacienteRepository.save(paciente);
                // cliente.getPacientes().add(paciente); // Al cliente se le asigna el paciente
            }
        
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