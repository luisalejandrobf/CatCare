package com.catcare.project.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.catcare.project.Entity.Mascota;

@Repository
public class MascotaRepository {

    private Map<Integer, Mascota> data = new HashMap<>();

    public MascotaRepository() {
        data.put(1, new Mascota("Max", "Golden Retriever", 3, 25.5, "Fiebre", "Activo"));
        data.put(2, new Mascota("Bella", "Poodle", 2, 7.8, "Tos", "Activo"));
        data.put(3, new Mascota("Charlie", "Labrador", 4, 22.0, "Dolor de estómago", "Activo"));
        data.put(4, new Mascota("Luna", "Bulldog", 1, 5.5, "Alergia", "Activo"));
        data.put(5, new Mascota("Cooper", "Chihuahua", 5, 10.2, "Gripe", "Activo"));
        data.put(6, new Mascota("Lucy", "Beagle", 2, 8.3, "Fiebre", "Activo"));
        data.put(7, new Mascota("Oliver", "Labrador", 3, 15.7, "Tos", "Activo"));
        data.put(8, new Mascota("Daisy", "Poodle", 2, 6.9, "Dolor de estómago", "Activo"));
        data.put(9, new Mascota("Rocky", "Golden Retriever", 4, 20.1, "Alergia", "Activo"));
        data.put(10, new Mascota("Molly", "Bulldog", 1, 7.2, "Gripe", "Activo"));
        data.put(11, new Mascota("Buddy", "Chihuahua", 5, 12.6, "Fiebre", "Activo"));
        data.put(12, new Mascota("Sophie", "Beagle", 2, 9.7, "Tos", "Activo"));
        data.put(13, new Mascota("Jack", "Labrador", 3, 18.4, "Dolor de estómago", "Activo"));
        data.put(14, new Mascota("Sadie", "Poodle", 2, 6.3, "Alergia", "Activo"));
        data.put(15, new Mascota("Tucker", "Golden Retriever", 4, 22.3, "Gripe", "Activo"));
        data.put(16, new Mascota("Chloe", "Bulldog", 1, 5.8, "Fiebre", "Activo"));
        data.put(17, new Mascota("Bear", "Chihuahua", 5, 11.0, "Tos", "Activo"));
        data.put(18, new Mascota("Zoe", "Beagle", 2, 7.6, "Dolor de estómago", "Activo"));
        data.put(19, new Mascota("Duke", "Labrador", 3, 16.9, "Alergia", "Activo"));
        data.put(20, new Mascota("Mia", "Poodle", 2, 7.1, "Gripe", "Activo"));
        data.put(21, new Mascota("Leo", "Golden Retriever", 4, 21.7, "Fiebre", "Activo"));
        data.put(22, new Mascota("Coco", "Bulldog", 1, 6.0, "Tos", "Activo"));
        data.put(23, new Mascota("Milo", "Chihuahua", 5, 13.2, "Dolor de estómago", "Activo"));
        data.put(24, new Mascota("Rosie", "Beagle", 2, 8.7, "Alergia", "Activo"));
        data.put(25, new Mascota("Finn", "Labrador", 3, 19.3, "Gripe", "Activo"));
        data.put(26, new Mascota("Ruby", "Poodle", 2, 7.9, "Fiebre", "Activo"));
        data.put(27, new Mascota("Oscar", "Golden Retriever", 4, 23.8, "Tos", "Activo"));
        data.put(28, new Mascota("Lily", "Bulldog", 1, 5.3, "Dolor de estómago", "Activo"));
        data.put(29, new Mascota("Teddy", "Chihuahua", 5, 10.7, "Alergia", "Activo"));
        data.put(30, new Mascota("Abby", "Beagle", 2, 9.1, "Gripe", "Activo"));
        data.put(31, new Mascota("Cody", "Labrador", 3, 17.5, "Fiebre", "Activo"));
        data.put(32, new Mascota("Zara", "Poodle", 2, 6.6, "Tos", "Activo"));
        data.put(33, new Mascota("Jackson", "Golden Retriever", 4, 20.4, "Dolor de estómago", "Activo"));
        data.put(34, new Mascota("Nala", "Bulldog", 1, 7.5, "Alergia", "Activo"));
        data.put(35, new Mascota("Riley", "Chihuahua", 5, 14.1, "Gripe", "Activo"));
        data.put(36, new Mascota("Maggie", "Beagle", 2, 8.9, "Fiebre", "Activo"));
        data.put(37, new Mascota("Winston", "Labrador", 3, 16.2, "Tos", "Activo"));
        data.put(38, new Mascota("Lola", "Poodle", 2, 7.2, "Dolor de estómago", "Activo"));
        data.put(39, new Mascota("Sam", "Golden Retriever", 4, 22.9, "Alergia", "Activo"));
        data.put(40, new Mascota("Layla", "Bulldog", 1, 6.7, "Gripe", "Activo"));
        data.put(41, new Mascota("Zeus", "Chihuahua", 5, 11.8, "Fiebre", "Activo"));
        data.put(42, new Mascota("Gracie", "Beagle", 2, 9.5, "Tos", "Activo"));
        data.put(43, new Mascota("Hunter", "Labrador", 3, 18.7, "Dolor de estómago", "Activo"));
        data.put(44, new Mascota("Cleo", "Poodle", 2, 6.2, "Alergia", "Activo"));
        data.put(45, new Mascota("Harley", "Golden Retriever", 4, 21.0, "Gripe", "Activo"));
        data.put(46, new Mascota("Penny", "Bulldog", 1, 5.6, "Fiebre", "Activo"));
        data.put(47, new Mascota("Jax", "Chihuahua", 5, 12.0, "Tos", "Activo"));
        data.put(48, new Mascota("Sasha", "Beagle", 2, 7.8, "Dolor de estómago", "Activo"));
        data.put(49, new Mascota("Maverick", "Labrador", 3, 17.3, "Alergia", "Activo"));
        data.put(50, new Mascota("Nina", "Poodle", 2, 8.1, "Gripe", "Activo"));
        data.put(51, new Mascota("Rusty", "Golden Retriever", 4, 22.1, "Fiebre", "Activo"));
        data.put(52, new Mascota("Mila", "Bulldog", 1, 6.4, "Tos", "Activo"));
        data.put(53, new Mascota("Prince", "Chihuahua", 5, 13.5, "Dolor de estómago", "Activo"));
        data.put(54, new Mascota("Willow", "Beagle", 2, 9.0, "Alergia", "Activo"));
        data.put(55, new Mascota("Sammy", "Labrador", 3, 19.9, "Gripe", "Activo"));
        data.put(56, new Mascota("Ivy", "Poodle", 2, 7.4, "Fiebre", "Activo"));
        data.put(57, new Mascota("Loki", "Golden Retriever", 4, 23.0, "Tos", "Activo"));
        data.put(58, new Mascota("Piper", "Bulldog", 1, 5.1, "Dolor de estómago", "Activo"));
        data.put(59, new Mascota("Toby", "Chihuahua", 5, 10.3, "Alergia", "Activo"));
        data.put(60, new Mascota("Hazel", "Beagle", 2, 8.2, "Gripe", "Activo"));
        data.put(61, new Mascota("Axel", "Labrador", 3, 15.2, "Fiebre", "Activo"));
        data.put(62, new Mascota("Emma", "Poodle", 2, 6.8, "Tos", "Activo"));
        data.put(63, new Mascota("Chase", "Golden Retriever", 4, 20.5, "Dolor de estómago", "Activo"));
        data.put(64, new Mascota("Lilly", "Bulldog", 1, 7.7, "Alergia", "Activo"));
        data.put(65, new Mascota("Dexter", "Chihuahua", 5, 12.4, "Gripe", "Activo"));
        data.put(66, new Mascota("Lola", "Beagle", 2, 9.3, "Fiebre", "Activo"));
        data.put(67, new Mascota("Gus", "Labrador", 3, 18.1, "Tos", "Activo"));
        data.put(68, new Mascota("Lulu", "Poodle", 2, 7.0, "Dolor de estómago", "Activo"));
        data.put(69, new Mascota("Kobe", "Golden Retriever", 4, 21.2, "Alergia", "Activo"));
        data.put(70, new Mascota("Cupcake", "Bulldog", 1, 5.4, "Gripe", "Activo"));
        data.put(71, new Mascota("Rex", "Chihuahua", 5, 11.5, "Fiebre", "Activo"));
        data.put(72, new Mascota("Mocha", "Beagle", 2, 8.5, "Tos", "Activo"));
        data.put(73, new Mascota("Apollo", "Labrador", 3, 16.5, "Dolor de estómago", "Activo"));
        data.put(74, new Mascota("Ella", "Poodle", 2, 6.1, "Alergia", "Activo"));
        data.put(75, new Mascota("Hunter", "Golden Retriever", 4, 22.5, "Gripe", "Activo"));
        data.put(76, new Mascota("Minnie", "Bulldog", 1, 7.4, "Fiebre", "Activo"));
        data.put(77, new Mascota("Louie", "Chihuahua", 5, 12.9, "Tos", "Activo"));
        data.put(78, new Mascota("Harper", "Beagle", 2, 9.2, "Dolor de estómago", "Activo"));
        data.put(79, new Mascota("Bruno", "Labrador", 3, 17.8, "Alergia", "Activo"));
        data.put(80, new Mascota("Maddie", "Poodle", 2, 7.3, "Gripe", "Activo"));
        data.put(81, new Mascota("Oliver", "Golden Retriever", 4, 20.8, "Fiebre", "Activo"));
        data.put(82, new Mascota("Ziggy", "Bulldog", 1, 5.7, "Tos", "Activo"));
        data.put(83, new Mascota("Carter", "Chihuahua", 5, 11.2, "Dolor de estómago", "Activo"));
        data.put(84, new Mascota("Penelope", "Beagle", 2, 8.4, "Alergia", "Activo"));
        data.put(85, new Mascota("Rocco", "Labrador", 3, 19.1, "Gripe", "Activo"));
        data.put(86, new Mascota("Honey", "Poodle", 2, 6.5, "Fiebre", "Activo"));
        data.put(87, new Mascota("Rusty", "Golden Retriever", 4, 21.8, "Tos", "Activo"));
        data.put(88, new Mascota("Nova", "Bulldog", 1, 7.3, "Dolor de estómago", "Activo"));
        data.put(89, new Mascota("Hank", "Chihuahua", 5, 12.3, "Alergia", "Activo"));
        data.put(90, new Mascota("Sunny", "Beagle", 2, 8.6, "Gripe", "Activo"));
        data.put(91, new Mascota("Marley", "Labrador", 3, 17.0, "Fiebre", "Activo"));
        data.put(92, new Mascota("Gigi", "Poodle", 2, 6.7, "Tos", "Activo"));
        data.put(93, new Mascota("Koda", "Golden Retriever", 4, 20.0, "Dolor de estómago", "Activo"));
        data.put(94, new Mascota("Olive", "Bulldog", 1, 7.9, "Alergia", "Activo"));
        data.put(95, new Mascota("Brutus", "Chihuahua", 5, 12.7, "Gripe", "Activo"));
        data.put(96, new Mascota("Lizzie", "Beagle", 2, 8.0, "Fiebre", "Activo"));
        data.put(97, new Mascota("Riley", "Labrador", 3, 18.5, "Tos", "Activo"));
        data.put(98, new Mascota("Lola", "Poodle", 2, 6.4, "Dolor de estómago", "Activo"));
        data.put(99, new Mascota("Cash", "Golden Retriever", 4, 21.4, "Alergia", "Activo"));
        data.put(100, new Mascota("Mochi", "Bulldog", 1, 7.1, "Gripe", "Activo"));
    }

    public Mascota findById(int id){
        return data.get(id);
    }

    public Collection<Mascota> findAll(){
        return data.values();
    }

}
