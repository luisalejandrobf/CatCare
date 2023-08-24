package com.catcare.project.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.catcare.project.Entity.Paciente;
import org.springframework.stereotype.Repository;

@Repository
public class PacienteRepository {

    private Map<Integer, Paciente> data = new HashMap<>();

    public PacienteRepository() {
        data.put(1, new Paciente(1,"Max", "Golden Retriever", 3, 25.5, "Fiebre", "Activo"));
        data.put(2, new Paciente(2,"Bella", "Poodle", 2, 7.8, "Tos", "Activo"));
        data.put(3, new Paciente(3,"Charlie", "Labrador", 4, 22.0, "Dolor de estómago", "Activo"));
        data.put(4, new Paciente(4,"Luna", "Bulldog", 1, 5.5, "Alergia", "Activo"));
        data.put(5, new Paciente(5,"Cooper", "Chihuahua", 5, 10.2, "Gripe", "Activo"));
        data.put(6, new Paciente(6,"Lucy", "Beagle", 2, 8.3, "Fiebre", "Activo"));
        data.put(7, new Paciente(7,"Oliver", "Labrador", 3, 15.7, "Tos", "Activo"));
        data.put(8, new Paciente(8,"Daisy", "Poodle", 2, 6.9, "Dolor de estómago", "Activo"));
        data.put(9, new Paciente(9,"Rocky", "Golden Retriever", 4, 20.1, "Alergia", "Activo"));
        data.put(10, new Paciente(10,"Molly", "Bulldog", 1, 7.2, "Gripe", "Activo"));
        data.put(11, new Paciente(11,"Buddy", "Chihuahua", 5, 12.6, "Fiebre", "Activo"));
        data.put(12, new Paciente(12,"Sophie", "Beagle", 2, 9.7, "Tos", "Activo"));
        data.put(13, new Paciente(13,"Jack", "Labrador", 3, 18.4, "Dolor de estómago", "Activo"));
        data.put(14, new Paciente(14,"Sadie", "Poodle", 2, 6.3, "Alergia", "Activo"));
        data.put(15, new Paciente(15,"Tucker", "Golden Retriever", 4, 22.3, "Gripe", "Activo"));
        data.put(16, new Paciente(16,"Chloe", "Bulldog", 1, 5.8, "Fiebre", "Activo"));
        data.put(17, new Paciente(17,"Bear", "Chihuahua", 5, 11.0, "Tos", "Activo"));
        data.put(18, new Paciente(18,"Zoe", "Beagle", 2, 7.6, "Dolor de estómago", "Activo"));
        data.put(19, new Paciente(19,"Duke", "Labrador", 3, 16.9, "Alergia", "Activo"));
        data.put(20, new Paciente(20,"Mia", "Poodle", 2, 7.1, "Gripe", "Activo"));
        data.put(21, new Paciente(21,"Leo", "Golden Retriever", 4, 21.7, "Fiebre", "Activo"));
        data.put(22, new Paciente(22,"Coco", "Bulldog", 1, 6.0, "Tos", "Activo"));
        data.put(23, new Paciente(23,"Milo", "Chihuahua", 5, 13.2, "Dolor de estómago", "Activo"));
        data.put(24, new Paciente(24,"Rosie", "Beagle", 2, 8.7, "Alergia", "Activo"));
        data.put(25, new Paciente(25,"Finn", "Labrador", 3, 19.3, "Gripe", "Activo"));
        data.put(26, new Paciente(26,"Ruby", "Poodle", 2, 7.9, "Fiebre", "Activo"));
        data.put(27, new Paciente(27,"Oscar", "Golden Retriever", 4, 23.8, "Tos", "Activo"));
        data.put(28, new Paciente(28,"Lily", "Bulldog", 1, 5.3, "Dolor de estómago", "Activo"));
        data.put(29, new Paciente(29,"Teddy", "Chihuahua", 5, 10.7, "Alergia", "Activo"));
        data.put(30, new Paciente(30,"Abby", "Beagle", 2, 9.1, "Gripe", "Activo"));
        data.put(31, new Paciente(31,"Cody", "Labrador", 3, 17.5, "Fiebre", "Activo"));
        data.put(32, new Paciente(32,"Zara", "Poodle", 2, 6.6, "Tos", "Activo"));
        data.put(33, new Paciente(33,"Jackson", "Golden Retriever", 4, 20.4, "Dolor de estómago", "Activo"));
        data.put(34, new Paciente(34,"Nala", "Bulldog", 1, 7.5, "Alergia", "Activo"));
        data.put(35, new Paciente(35,"Riley", "Chihuahua", 5, 14.1, "Gripe", "Activo"));
        data.put(36, new Paciente(36,"Maggie", "Beagle", 2, 8.9, "Fiebre", "Activo"));
        data.put(37, new Paciente(37,"Winston", "Labrador", 3, 16.2, "Tos", "Activo"));
        data.put(38, new Paciente(38,"Lola", "Poodle", 2, 7.2, "Dolor de estómago", "Activo"));
        data.put(39, new Paciente(39,"Sam", "Golden Retriever", 4, 22.9, "Alergia", "Activo"));
        data.put(40, new Paciente(40,"Layla", "Bulldog", 1, 6.7, "Gripe", "Activo"));
        data.put(41, new Paciente(41,"Zeus", "Chihuahua", 5, 11.8, "Fiebre", "Activo"));
        data.put(42, new Paciente(42,"Gracie", "Beagle", 2, 9.5, "Tos", "Activo"));
        data.put(43, new Paciente(43,"Hunter", "Labrador", 3, 18.7, "Dolor de estómago", "Activo"));
        data.put(44, new Paciente(44,"Cleo", "Poodle", 2, 6.2, "Alergia", "Activo"));
        data.put(45, new Paciente(45,"Harley", "Golden Retriever", 4, 21.0, "Gripe", "Activo"));
        data.put(46, new Paciente(46,"Penny", "Bulldog", 1, 5.6, "Fiebre", "Activo"));
        data.put(47, new Paciente(47,"Jax", "Chihuahua", 5, 12.0, "Tos", "Activo"));
        data.put(48, new Paciente(48,"Sasha", "Beagle", 2, 7.8, "Dolor de estómago", "Activo"));
        data.put(49, new Paciente(49,"Maverick", "Labrador", 3, 17.3, "Alergia", "Activo"));
        data.put(50, new Paciente(50,"Nina", "Poodle", 2, 8.1, "Gripe", "Activo"));
        data.put(51, new Paciente(51,"Rusty", "Golden Retriever", 4, 22.1, "Fiebre", "Activo"));
        data.put(52, new Paciente(52,"Mila", "Bulldog", 1, 6.4, "Tos", "Activo"));
        data.put(53, new Paciente(53,"Prince", "Chihuahua", 5, 13.5, "Dolor de estómago", "Activo"));
        data.put(54, new Paciente(54,"Willow", "Beagle", 2, 9.0, "Alergia", "Activo"));
        data.put(55, new Paciente(55,"Sammy", "Labrador", 3, 19.9, "Gripe", "Activo"));
        data.put(56, new Paciente(56,"Ivy", "Poodle", 2, 7.4, "Fiebre", "Activo"));
        data.put(57, new Paciente(57,"Loki", "Golden Retriever", 4, 23.0, "Tos", "Activo"));
        data.put(58, new Paciente(58,"Piper", "Bulldog", 1, 5.1, "Dolor de estómago", "Activo"));
        data.put(59, new Paciente(59,"Toby", "Chihuahua", 5, 10.3, "Alergia", "Activo"));
        data.put(60, new Paciente(60,"Hazel", "Beagle", 2, 8.2, "Gripe", "Activo"));
        data.put(61, new Paciente(61,"Axel", "Labrador", 3, 15.2, "Fiebre", "Activo"));
        data.put(62, new Paciente(62,"Emma", "Poodle", 2, 6.8, "Tos", "Activo"));
        data.put(63, new Paciente(63,"Chase", "Golden Retriever", 4, 20.5, "Dolor de estómago", "Activo"));
        data.put(64, new Paciente(64,"Lilly", "Bulldog", 1, 7.7, "Alergia", "Activo"));
        data.put(65, new Paciente(65,"Dexter", "Chihuahua", 5, 12.4, "Gripe", "Activo"));
        data.put(66, new Paciente(66,"Lola", "Beagle", 2, 9.3, "Fiebre", "Activo"));
        data.put(67, new Paciente(67,"Gus", "Labrador", 3, 18.1, "Tos", "Activo"));
        data.put(68, new Paciente(68,"Lulu", "Poodle", 2, 7.0, "Dolor de estómago", "Activo"));
        data.put(69, new Paciente(69,"Kobe", "Golden Retriever", 4, 21.2, "Alergia", "Activo"));
        data.put(70, new Paciente(70,"Cupcake", "Bulldog", 1, 5.4, "Gripe", "Activo"));
        data.put(71, new Paciente(71,"Rex", "Chihuahua", 5, 11.5, "Fiebre", "Activo"));
        data.put(72, new Paciente(72,"Mocha", "Beagle", 2, 8.5, "Tos", "Activo"));
        data.put(73, new Paciente(73,"Apollo", "Labrador", 3, 16.5, "Dolor de estómago", "Activo"));
        data.put(74, new Paciente(74,"Ella", "Poodle", 2, 6.1, "Alergia", "Activo"));
        data.put(75, new Paciente(75,"Hunter", "Golden Retriever", 4, 22.5, "Gripe", "Activo"));
        data.put(76, new Paciente(76,"Minnie", "Bulldog", 1, 7.4, "Fiebre", "Activo"));
        data.put(77, new Paciente(77,"Louie", "Chihuahua", 5, 12.9, "Tos", "Activo"));
        data.put(78, new Paciente(78,"Harper", "Beagle", 2, 9.2, "Dolor de estómago", "Activo"));
        data.put(79, new Paciente(79,"Bruno", "Labrador", 3, 17.8, "Alergia", "Activo"));
        data.put(80, new Paciente(80,"Maddie", "Poodle", 2, 7.3, "Gripe", "Activo"));
        data.put(81, new Paciente(81,"Oliver", "Golden Retriever", 4, 20.8, "Fiebre", "Activo"));
        data.put(82, new Paciente(82,"Ziggy", "Bulldog", 1, 5.7, "Tos", "Activo"));
        data.put(83, new Paciente(83,"Carter", "Chihuahua", 5, 11.2, "Dolor de estómago", "Activo"));
        data.put(84, new Paciente(84,"Penelope", "Beagle", 2, 8.4, "Alergia", "Activo"));
        data.put(85, new Paciente(85,"Rocco", "Labrador", 3, 19.1, "Gripe", "Activo"));
        data.put(86, new Paciente(86,"Honey", "Poodle", 2, 6.5, "Fiebre", "Activo"));
        data.put(87, new Paciente(87,"Rusty", "Golden Retriever", 4, 21.8, "Tos", "Activo"));
        data.put(88, new Paciente(88,"Nova", "Bulldog", 1, 7.3, "Dolor de estómago", "Activo"));
        data.put(89, new Paciente(89,"Hank", "Chihuahua", 5, 12.3, "Alergia", "Activo"));
        data.put(90, new Paciente(90,"Sunny", "Beagle", 2, 8.6, "Gripe", "Activo"));
        data.put(91, new Paciente(91,"Marley", "Labrador", 3, 17.0, "Fiebre", "Activo"));
        data.put(92, new Paciente(92,"Gigi", "Poodle", 2, 6.7, "Tos", "Activo"));
        data.put(93, new Paciente(93,"Koda", "Golden Retriever", 4, 20.0, "Dolor de estómago", "Activo"));
        data.put(94, new Paciente(94,"Olive", "Bulldog", 1, 7.9, "Alergia", "Activo"));
        data.put(95, new Paciente(95,"Brutus", "Chihuahua", 5, 12.7, "Gripe", "Activo"));
        data.put(96, new Paciente(96,"Lizzie", "Beagle", 2, 8.0, "Fiebre", "Activo"));
        data.put(97, new Paciente(97,"Riley", "Labrador", 3, 18.5, "Tos", "Activo"));
        data.put(98, new Paciente(98,"Lola", "Poodle", 2, 6.4, "Dolor de estómago", "Activo"));
        data.put(99, new Paciente(99,"Cash", "Golden Retriever", 4, 21.4, "Alergia", "Activo"));
        data.put(100, new Paciente(100,"Mochi", "Bulldog", 1, 7.1, "Gripe", "Activo"));
    }

    public Paciente findById(int id){
        return data.get(id);
    }

    public Collection<Paciente> findAll(){
        return data.values();
    }

    public void deleteById(int id){
        data.remove(id);
    }

    public void updateById(Paciente paciente){
        data.put(paciente.getId(), paciente);
    }

    public void add(Paciente paciente){
        int tam = data.size();
        int lastId = data.get(tam).getId();
        paciente.setId(lastId+1);
        data.put(lastId+1, paciente);
    }

    public int size() {
        return data.size();
    }

}
