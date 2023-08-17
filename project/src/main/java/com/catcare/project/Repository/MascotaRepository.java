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
        data.put(1, new Mascota("Max"));
        data.put(2, new Mascota("Bella"));
        data.put(3, new Mascota("Charlie"));
        data.put(4, new Mascota("Luna"));
        data.put(5, new Mascota("Cooper"));
        data.put(6, new Mascota("Lucy"));
        data.put(7, new Mascota("Oliver"));
        data.put(8, new Mascota("Daisy"));
        data.put(9, new Mascota("Rocky"));
        data.put(10, new Mascota("Molly"));
        data.put(11, new Mascota("Buddy"));
        data.put(12, new Mascota("Sophie"));
        data.put(13, new Mascota("Jack"));
        data.put(14, new Mascota("Sadie"));
        data.put(15, new Mascota("Tucker"));
        data.put(16, new Mascota("Chloe"));
        data.put(17, new Mascota("Bear"));
        data.put(18, new Mascota("Zoe"));
        data.put(19, new Mascota("Duke"));
        data.put(20, new Mascota("Mia"));
        data.put(21, new Mascota("Leo"));
        data.put(22, new Mascota("Coco"));
        data.put(23, new Mascota("Milo"));
        data.put(24, new Mascota("Rosie"));
        data.put(25, new Mascota("Finn"));
        data.put(26, new Mascota("Ruby"));
        data.put(27, new Mascota("Oscar"));
        data.put(28, new Mascota("Lily"));
        data.put(29, new Mascota("Teddy"));
        data.put(30, new Mascota("Abby"));
        data.put(31, new Mascota("Cody"));
        data.put(32, new Mascota("Zara"));
        data.put(33, new Mascota("Jackson"));
        data.put(34, new Mascota("Nala"));
        data.put(35, new Mascota("Riley"));
        data.put(36, new Mascota("Maggie"));
        data.put(37, new Mascota("Winston"));
        data.put(38, new Mascota("Lola"));
        data.put(39, new Mascota("Sam"));
        data.put(40, new Mascota("Layla"));
        data.put(41, new Mascota("Zeus"));
        data.put(42, new Mascota("Gracie"));
        data.put(43, new Mascota("Hunter"));
        data.put(44, new Mascota("Cleo"));
        data.put(45, new Mascota("Harley"));
        data.put(46, new Mascota("Penny"));
        data.put(47, new Mascota("Jax"));
        data.put(48, new Mascota("Sasha"));
        data.put(49, new Mascota("Maverick"));
        data.put(50, new Mascota("Nina"));
        data.put(51, new Mascota("Rusty"));
        data.put(52, new Mascota("Mila"));
        data.put(53, new Mascota("Prince"));
        data.put(54, new Mascota("Willow"));
        data.put(55, new Mascota("Sammy"));
        data.put(56, new Mascota("Ivy"));
        data.put(57, new Mascota("Loki"));
        data.put(58, new Mascota("Piper"));
        data.put(59, new Mascota("Toby"));
        data.put(60, new Mascota("Hazel"));
        data.put(61, new Mascota("Axel"));
        data.put(62, new Mascota("Emma"));
        data.put(63, new Mascota("Chase"));
        data.put(64, new Mascota("Lilly"));
        data.put(65, new Mascota("Dexter"));
        data.put(66, new Mascota("Lola"));
        data.put(67, new Mascota("Gus"));
        data.put(68, new Mascota("Lulu"));
        data.put(69, new Mascota("Kobe"));
        data.put(70, new Mascota("Cupcake"));
        data.put(71, new Mascota("Rex"));
        data.put(72, new Mascota("Mocha"));
        data.put(73, new Mascota("Apollo"));
        data.put(74, new Mascota("Ella"));
        data.put(75, new Mascota("Hunter"));
        data.put(76, new Mascota("Minnie"));
        data.put(77, new Mascota("Louie"));
        data.put(78, new Mascota("Harper"));
        data.put(79, new Mascota("Bruno"));
        data.put(80, new Mascota("Maddie"));
        data.put(81, new Mascota("Oliver"));
        data.put(82, new Mascota("Ziggy"));
        data.put(83, new Mascota("Carter"));
        data.put(84, new Mascota("Penelope"));
        data.put(85, new Mascota("Rocco"));
        data.put(86, new Mascota("Honey"));
        data.put(87, new Mascota("Rusty"));
        data.put(88, new Mascota("Nova"));
        data.put(89, new Mascota("Hank"));
        data.put(90, new Mascota("Sunny"));
        data.put(91, new Mascota("Marley"));
        data.put(92, new Mascota("Gigi"));
        data.put(93, new Mascota("Koda"));
        data.put(94, new Mascota("Olive"));
        data.put(95, new Mascota("Brutus"));
        data.put(96, new Mascota("Lizzie"));
        data.put(97, new Mascota("Riley"));
        data.put(98, new Mascota("Lola"));
        data.put(99, new Mascota("Cash"));
        data.put(100, new Mascota("Mochi"));
    }

    public Mascota getMascota(int id){
        return data.get(id);
    }

    public Collection<Mascota> getAll(){
        return data.values();
    }

}
