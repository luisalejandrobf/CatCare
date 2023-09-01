package com.catcare.project.Entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.catcare.project.Repository.ClienteRepository;
import com.catcare.project.Repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        clienteRepository.save(new Cliente("1221351234", "Luis Alejandro Bravo Ferreira", "luis.bravof@javeriana.edu.co", "3162858895", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("23113124523", "Felipe Garcia Castiblanco", "felipe.gar@javeriana.edu.co", "32424234334", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("23523532523", "Ana María Ortegón Sepulveda", "ana.ortegon@javeriana.edu.co", "43242423434", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("532532523", "María García Pérez", "Elena.garcia@hotmail.com", "3112345678", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("5435235234", "Ana Martínez González", "ana.martinez@gmail.com", "3334567890", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("1521514123", "Carlos Sánchez Ruiz", "carlos.sanchez@hotmail.com", "3445678901", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("2141515123", "Isabel López Ramírez", "isabel.lopez@gmail.com", "3556789012", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("3454235234", "Andrés Hernández Herrera", "andres.hernandez@gmail.com", "3667890123", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("211514521412", "Waldina López", "wald.lopez@gmail.com", "3556789012", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("544342134", "Hernando Hernández Herrera", "hernando.hernandez@gmail.com", "3667890123", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("542646", "Juan Romero", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("234353253253223", "Andrés Medina", "Andres@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("4325355345345", "Sofía Mendoza", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("5435345435678", "Daniela Castro", "Daniela@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("3434534543556", "Luisa Delgado", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("6734534534589", "Alejandro Silva", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("235433534545", "Valentina Morales", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("43534534534534", "Felipe Morales", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("234345345345", "Carolina Romero ", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("7834534543590", "Andrés Rodriguez", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("134543534234", "Carlos Martinez", "Carlos@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("233453454323", "Ulises Lopez", "Ulises@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("3345345434", "Sofía Gonzalez", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("5345345678", "Karla Lopez", "Karla@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("343534534456", "Luisa Flores", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("673453454389", "Alejandro Rivera", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("233454353445", "Isabella Torres", "Isabella@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("7435435345890", "Felipe Morales", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("2345435435345", "Natalia Flores", "Natalia@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("783453453490", "Gabriel Ramirez", "Gabriel@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("123453454334", "Juan Gonzalez", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("2345345435323", "Andrés Hernandez", "Andres@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("3434534543534", "Raquel Ramirez", "Raquel@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("5345345345678", "María Martinez", "Maria@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("3434534543556", "Valentina Ramirez", "Valentina@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("6783453453459", "Ricardo Ortega", "Ricardo@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("233453454354345", "Natalia Cruz", "Natalia@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("7853453453453490", "Felipe Sanchez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("2334534545", "Natalia Martinez", "Natalia@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("78534534543590", "Andrés Garcia", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("123453454334", "Juan Rodriguez", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("2334534523", "Andrés Perez", "Andres@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("3345345435434", "Sofía Torres", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("5345435435678", "María Reyes", "Maria@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("3345345435456", "Luisa Gonzalez", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("6734534543589", "Alejandro Hernandez", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("2334534545", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("784353454390", "Felipe Ramirez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("2343534545", "Ximena Ortega", "Ximena@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("7834534534590", "Andrés Mendoza", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("1234534534", "Gabriel Hernandez", "Gabriel@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("233454354323", "Hugo Gonzalez", "Hugo@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("3434534534534", "Sofía Torres", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("5634534578", "Laura Ramirez", "Laura@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("3443534534556", "Gabriela Mendoza", "Gabriela@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("6743534534589", "Eduardo Ortega", "Eduardo@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("243534534345", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("783453454390", "Tomas Ramirez", "Tomas@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("2334534534545", "Carolina Ortiz", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("75345435890", "Andrés Mendoza", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("124354354334", "Luis Rodriguez", "Luis@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("2334534523", "Carlos Garcia", "Carlos@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("334543543434", "Fernanda Hernandez", "Fernanda@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("53453452378", "Laura Gonzalez", "Laura@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("3413412434534556", "Luisa Ramirez", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("67834534549", "Ivan Ortega", "Ivan@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("2334534543545", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("78345435390", "Felipe Ramirez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("2346346345", "Carolina Ortiz", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("7346346345890", "Andrés Mendoza", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("123453454334", "Juan Hernandez", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("233463463423", "Andrés Perez", "Andres@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("3423432434", "Sofía Torres", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("56345345643638", "Valentina Martinez", "Valentina@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("34534634634566", "Luisa Ortega", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("6345345345789", "Alejandro Hernandez", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("224235235345", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("7823523532490", "Felipe Ramirez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("2363463464345", "Julia Martinez", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("7235325623890", "Andrés Mendoza", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("1236236234", "Juan Hernandez", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("2236523623323", "Lalo Perez", "Lalo@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("3324235434", "Sofía Torres", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("562363278", "María Gutierrez", "Maria@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("332423562456", "Luisa Ortega", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("6723632689", "Alejandro Hernandez", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("234235345", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("7262236590", "Felipe Ramirez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("2332432456245", "Julia Martinez", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("783642652590", "Pepito Mendoza", "Pepito@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("1223632623534", "Juan Hernandez", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        clienteRepository.save(new Cliente("2332423623523", "Juan Perez", "Juan@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        clienteRepository.save(new Cliente("3432423432423434", "Sofía Torres", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        clienteRepository.save(new Cliente("53246235262678", "María Gutierrez", "Elena@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        clienteRepository.save(new Cliente("346223523456", "Luisa Ortega", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        clienteRepository.save(new Cliente("62623234234789", "Alejandro Hernandez", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        clienteRepository.save(new Cliente("23324235675445", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        clienteRepository.save(new Cliente("782362334230", "Felipe Ramirez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        clienteRepository.save(new Cliente("2342632476235", "Julia Martinez", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        clienteRepository.save(new Cliente("452532525235", "Juanita Lopez", "juanitaLp@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));

        pacienteRepository.save(new Paciente("Max", "Abisinio", 3, 25.5, "Fiebre", "Activo", "https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg"));
        pacienteRepository.save(new Paciente("Bella", "Persa", 2, 7.8, "Tos", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Charlie", "Siames", 4, 22.0, "Dolor de estómago", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        pacienteRepository.save(new Paciente("Luna", "Maine Coon", 1, 5.5, "Alergia", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        pacienteRepository.save(new Paciente("Cooper", "Ragdoll ", 5, 10.2, "Gripe", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        pacienteRepository.save(new Paciente("Lucy", "Cornish Rex", 2, 8.3, "Fiebre", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
        pacienteRepository.save(new Paciente("Oliver", "Cornish Rex", 3, 15.7, "Tos", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        pacienteRepository.save(new Paciente("Daisy", "Devon Rex", 2, 6.9, "Dolor de estómago", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        pacienteRepository.save(new Paciente("Rocky", "Golden Retriever", 4, 20.1, "Alergia", "Activo","https://www.semana.com/resizer/QulPdczfzOqr_eiEznThKXUUA4s=/1280x720/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/JE2JDQ2GR5G7ZKS5MBDFR5THTE.jpg"));
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

        // Relacionar clientes con mascotas
        // TO-DO
        
        // Relacionar 30 clientes con 3 pacientes cada uno
        List<Cliente> clientes = clienteRepository.findAll();
        List<Paciente> pacientes = pacienteRepository.findAll();

        for (int i = 0; i < 25; i++) {
            Cliente cliente = clientes.get(i);
        
            for (int j = 0; j < 4; j++) {
                Paciente paciente = pacientes.get(i * 4 + j);
                paciente.setCliente(cliente); // Al paciente se le asigna el cliente
                pacienteRepository.save(paciente);
                cliente.getPacientes().add(paciente); // Al cliente se le asigna el paciente
            }
        
            clienteRepository.save(cliente);
        }

    }
}