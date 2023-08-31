package com.catcare.project.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;

import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {

    private Map<Integer, Cliente> data = new HashMap<>();

    public ClienteRepository() {
        data.put(1, new Cliente(1, "1221351234", "Luis Alejandro Bravo Ferreira", "luis.bravof@javeriana.edu.co", "3162858895", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(2, new Cliente(2, "23113124523", "Felipe Garcia Castiblanco", "felipe.gar@javeriana.edu.co", "32424234334", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        data.put(3, new Cliente(3, "23523532523", "Ana Elena Ortegon Sepulveda", "ana.ortegon@javeriana.edu.co", "43242423434", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        data.put(4, new Cliente(4, "532532523", "María García Pérez", "Elena.garcia@hotmail.com", "3112345678", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        data.put(5, new Cliente(5, "5435235234", "Ana Martínez González", "ana.martinez@gmail.com", "3334567890", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        data.put(6, new Cliente(6, "1521514123", "Carlos Sánchez Ruiz", "carlos.sanchez@hotmail.com", "3445678901", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        data.put(7, new Cliente(7, "2141515123", "Isabel López Ramírez", "isabel.lopez@gmail.com", "3556789012", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        data.put(8, new Cliente(8, "3454235234", "Andrés Hernández Herrera", "andres.hernandez@gmail.com", "3667890123", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        data.put(9, new Cliente(9, "211514521412", "Waldina López", "wald.lopez@gmail.com", "3556789012", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        data.put(10, new Cliente(10, "544342134", "Hernando Hernández Herrera", "hernando.hernandez@gmail.com", "3667890123", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(11, new Cliente(11, "542646", "Juan Romero", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(12, new Cliente(12, "234353253253223", "Andrés Medina", "Andres@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        data.put(13, new Cliente(13, "4325355345345", "Sofía Mendoza", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        data.put(14, new Cliente(14, "5435345435678", "Daniela Castro", "Daniela@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        data.put(15, new Cliente(15, "3434534543556", "Luisa Delgado", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        data.put(16, new Cliente(16, "6734534534589", "Alejandro Silva", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        data.put(17, new Cliente(17, "235433534545", "Valentina Morales", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        data.put(18, new Cliente(18, "43534534534534", "Felipe Morales", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        data.put(19, new Cliente(19, "234345345345", "Carolina Romero ", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        data.put(20, new Cliente(20, "7834534543590", "Andrés Rodriguez", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(21, new Cliente(21, "134543534234", "Carlos Martinez", "Carlos@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(22, new Cliente(22, "233453454323", "Ulises Lopez", "Ulises@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        data.put(23, new Cliente(23, "3345345434", "Sofía Gonzalez", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        data.put(24, new Cliente(24, "5345345678", "Karla Lopez", "Karla@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        data.put(25, new Cliente(25, "343534534456", "Luisa Flores", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        data.put(26, new Cliente(26, "673453454389", "Alejandro Rivera", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        data.put(27, new Cliente(27, "233454353445", "Isabella Torres", "Isabella@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        data.put(28, new Cliente(28, "7435435345890", "Felipe Morales", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        data.put(29, new Cliente(29, "2345435435345", "Natalia Flores", "Natalia@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        data.put(30, new Cliente(30, "783453453490", "Gabriel Ramirez", "Gabriel@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(31, new Cliente(31, "123453454334", "Juan Gonzalez", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(32, new Cliente(32, "2345345435323", "Andrés Hernandez", "Andres@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        data.put(33, new Cliente(33, "3434534543534", "Raquel Ramirez", "Raquel@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        data.put(34, new Cliente(34, "5345345345678", "María Martinez", "Maria@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        data.put(35, new Cliente(35, "3434534543556", "Valentina Ramirez", "Valentina@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        data.put(36, new Cliente(36, "6783453453459", "Ricardo Ortega", "Ricardo@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        data.put(37, new Cliente(37, "233453454354345", "Natalia Cruz", "Natalia@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        data.put(38, new Cliente(38, "7853453453453490", "Felipe Sanchez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        data.put(39, new Cliente(39, "2334534545", "Natalia Martinez", "Natalia@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        data.put(40, new Cliente(40, "78534534543590", "Andrés Garcia", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(41, new Cliente(41, "123453454334", "Juan Rodriguez", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(42, new Cliente(42, "2334534523", "Andrés Perez", "Andres@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        data.put(43, new Cliente(43, "3345345435434", "Sofía Torres", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        data.put(44, new Cliente(44, "5345435435678", "María Reyes", "Maria@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        data.put(45, new Cliente(45, "3345345435456", "Luisa Gonzalez", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        data.put(46, new Cliente(46, "6734534543589", "Alejandro Hernandez", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        data.put(47, new Cliente(47, "2334534545", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        data.put(48, new Cliente(48, "784353454390", "Felipe Ramirez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        data.put(49, new Cliente(49, "2343534545", "Ximena Ortega", "Ximena@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        data.put(50, new Cliente(50, "7834534534590", "Andrés Mendoza", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(51, new Cliente(51, "1234534534", "Gabriel Hernandez", "Gabriel@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(52, new Cliente(52, "233454354323", "Hugo Gonzalez", "Hugo@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        data.put(53, new Cliente(53, "3434534534534", "Sofía Torres", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        data.put(54, new Cliente(54, "5634534578", "Laura Ramirez", "Laura@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        data.put(55, new Cliente(55, "3443534534556", "Gabriela Mendoza", "Gabriela@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        data.put(56, new Cliente(56, "6743534534589", "Eduardo Ortega", "Eduardo@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        data.put(57, new Cliente(57, "243534534345", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        data.put(58, new Cliente(58, "783453454390", "Tomas Ramirez", "Tomas@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        data.put(59, new Cliente(59, "2334534534545", "Carolina Ortiz", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        data.put(60, new Cliente(60, "75345435890", "Andrés Mendoza", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(61, new Cliente(61, "124354354334", "Luis Rodriguez", "Luis@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(62, new Cliente(62, "2334534523", "Carlos Garcia", "Carlos@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        data.put(63, new Cliente(63, "334543543434", "Fernanda Hernandez", "Fernanda@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        data.put(64, new Cliente(64, "53453452378", "Laura Gonzalez", "Laura@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        data.put(65, new Cliente(65, "3413412434534556", "Luisa Ramirez", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        data.put(66, new Cliente(66, "67834534549", "Ivan Ortega", "Ivan@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        data.put(67, new Cliente(67, "2334534543545", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        data.put(68, new Cliente(68, "78345435390", "Felipe Ramirez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        data.put(69, new Cliente(69, "2346346345", "Carolina Ortiz", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        data.put(70, new Cliente(70, "7346346345890", "Andrés Mendoza", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(71, new Cliente(71, "123453454334", "Juan Hernandez", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(72, new Cliente(72, "233463463423", "Andrés Perez", "Andres@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        data.put(73, new Cliente(73, "3423432434", "Sofía Torres", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        data.put(74, new Cliente(74, "56345345643638", "Valentina Martinez", "Valentina@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        data.put(75, new Cliente(75, "34534634634566", "Luisa Ortega", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        data.put(76, new Cliente(76, "6345345345789", "Alejandro Hernandez", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        data.put(77, new Cliente(77, "224235235345", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        data.put(78, new Cliente(78, "7823523532490", "Felipe Ramirez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        data.put(79, new Cliente(79, "2363463464345", "Julia Martinez", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        data.put(80, new Cliente(80, "7235325623890", "Andrés Mendoza", "Andres@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(81, new Cliente(81, "1236236234", "Juan Hernandez", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(82, new Cliente(82, "2236523623323", "Lalo Perez", "Lalo@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        data.put(83, new Cliente(83, "3324235434", "Sofía Torres", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        data.put(84, new Cliente(84, "562363278", "María Gutierrez", "Maria@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        data.put(85, new Cliente(85, "332423562456", "Luisa Ortega", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        data.put(86, new Cliente(86, "6723632689", "Alejandro Hernandez", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        data.put(87, new Cliente(87, "234235345", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        data.put(88, new Cliente(88, "7262236590", "Felipe Ramirez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        data.put(89, new Cliente(89, "2332432456245", "Julia Martinez", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        data.put(90, new Cliente(90, "783642652590", "Pepito Mendoza", "Pepito@gmail.com", "3155145243521312", "https://images.pexels.com/photos/874158/pexels-photo-874158.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(91, new Cliente(91, "1223632623534", "Juan Hernandez", "Juan@gmail.com", "315532423412", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        data.put(92, new Cliente(92, "2332423623523", "Juan Perez", "Juan@gmail.com", "31551512324324", "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"));
        data.put(93, new Cliente(93, "3432423432423434", "Sofía Torres", "Sofia@gmail.com", "31532432412", "https://img.freepik.com/foto-gratis/retrato-mujer-joven-rubia-seria-concentrada-viste-camisa-lunares-mantiene-manos-juntas-ve-pensativo-pensando-aislado-sobre-pared-blanca_295783-1160.jpg"));
        data.put(94, new Cliente(94, "53246235262678", "María Gutierrez", "Elena@gmail.com", "315515132432412", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"));
        data.put(95, new Cliente(95, "346223523456", "Luisa Ortega", "Luisa@gmail.com", "315513242341312", "https://pymstatic.com/6399/conversions/mejores-virtudes-persona-wide_webp.webp"));
        data.put(96, new Cliente(96, "62623234234789", "Alejandro Hernandez", "Alejandro@gmail.com", "3155234324234312", "https://images.ecestaticos.com/vU8sC8tLdkx-2YYh1fkOGL8vfeY=/0x0:990x557/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F62c%2Fe5d%2F314%2F62ce5d3141c0b670144a692b7f6a21fa.jpg"));
        data.put(97, new Cliente(97, "23324235675445", "Valentina Sanchez", "Valentina@gmail.com", "3155151234242", "https://images.hola.com/imagenes/estar-bien/20221018219233/buenas-personas-caracteristicas/1-153-242/getty-chica-feliz-t.jpg?tx=w_680"));
        data.put(98, new Cliente(98, "782362334230", "Felipe Ramirez", "Felipe@gmail.com", "3155324345121312", "https://www.isesinstituto.com/sites/default/files/istock-1158245282.jpg"));
        data.put(99, new Cliente(99, "2342632476235", "Julia Martinez", "Carolina@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
        data.put(100, new Cliente(100, "452532525235", "Juanita Lopez", "juanitaLp@gmail.com", "3155151232432412", "https://media.istockphoto.com/id/1465591757/es/foto/exitosa-arquitecta-senior-de-pie-en-su-oficina-con-los-brazos-cruzados.jpg?b=1&s=612x612&w=0&k=20&c=ruG7n9AqWckQD9T9f_Qq__hii2RqZUoRKYk-bB9ZCNM="));
    }

    public Cliente findById(int id) {
        return data.get(id);
    }

    public Cliente findByCedula(String cedula) {
        for (Cliente cliente : data.values()) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null; // Return null if cedula is not found
    }
    
    public Collection<Cliente> findAll() {
        return data.values();
    }

    public void deleteById(int id) {
        data.remove(id);
    }

    public void updateById(Cliente cliente) {
        data.put(cliente.getId(), cliente);
    }

    public void add(Cliente cliente) {
        int tam = data.size();
        int lastId = data.get(tam).getId();
        cliente.setId(lastId + 1);
        data.put(lastId + 1, cliente);
    }

    public int size() {
        return data.size();
    }

}
