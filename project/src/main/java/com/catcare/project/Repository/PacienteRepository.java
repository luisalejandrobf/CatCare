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
        data.put(1, new Paciente(1,"Max", "Abisinio", 3, 25.5, "Fiebre", "Activo", "https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg"));
        data.put(2, new Paciente(2,"Bella", "Persa", 2, 7.8, "Tos", "Activo","https://ca-times.brightspotcdn.com/dims4/default/796e6c9/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/75/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001"));
        data.put(3, new Paciente(3,"Charlie", "Siames", 4, 22.0, "Dolor de estómago", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        data.put(4, new Paciente(4,"Luna", "Maine Coon", 1, 5.5, "Alergia", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        data.put(5, new Paciente(5,"Cooper", "Ragdoll ", 5, 10.2, "Gripe", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        data.put(6, new Paciente(6,"Lucy", "Cornish Rex", 2, 8.3, "Fiebre", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
        data.put(7, new Paciente(7,"Oliver", "Cornish Rex", 3, 15.7, "Tos", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        data.put(8, new Paciente(8,"Daisy", "Devon Rex", 2, 6.9, "Dolor de estómago", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        data.put(9, new Paciente(9,"Rocky", "Golden Retriever", 4, 20.1, "Alergia", "Activo","https://www.semana.com/resizer/QulPdczfzOqr_eiEznThKXUUA4s=/1280x720/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/JE2JDQ2GR5G7ZKS5MBDFR5THTE.jpg"));
        data.put(10, new Paciente(10,"Molly", "British Shorthair", 1, 7.2, "Gripe", "Activo","https://www.infobae.com/new-resizer/xh88gZVUaYWydCiAgN49rAfUhGI=/arc-anglerfish-arc2-prod-infobae/public/UZS53SVISJHAHBC4PDQBVHX52M.jpeg"));
        data.put(11, new Paciente(11,"Buddy", "Scottish Fold", 5, 12.6, "Fiebre", "Activo","https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/22/media/cortadas/gato-fotolia-k8eH-U160340519019xEE-1248x770@Las%20Provincias.jpg"));
        data.put(12, new Paciente(12,"Sophie", "American Shorthair", 2, 9.7, "Tos", "Activo","https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg"));
        data.put(13, new Paciente(13,"Jack", "Scottish Fold", 3, 18.4, "Dolor de estómago", "Activo","https://estaticos-cdn.sport.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg"));
        data.put(14, new Paciente(14,"Sadie", "Devon Rex", 2, 6.3, "Alergia", "Activo","https://www.elpais.com.co/resizer/zzMtz3dP412md6YrxomGW0wk2ZY=/1280x0/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/VUG44EJGYRCU3K4P7FH67RXMBQ.jpg"));
        data.put(15, new Paciente(15,"Tucker", "Siames", 4, 22.3, "Gripe", "Activo","https://fotografias.lasexta.com/clipping/cmsimages02/2018/07/18/54202C79-C95C-4589-8C76-4CC8DB96E85C/98.jpg?crop=960,540,x0,y0&width=1900&height=1069&optimize=high&format=webply"));
        data.put(16, new Paciente(16,"Chloe", "Devon Rex", 1, 5.8, "Fiebre", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        data.put(17, new Paciente(17,"Bear", "Siames", 5, 11.0, "Tos", "Activo","https://images.milenio.com/JUFQtwNFWKlYiQGCTPVgfyD0-BM=/345x237/uploads/media/2020/02/20/tener-un-gatito-podria-tener.jpg"));
        data.put(18, new Paciente(18,"Zoe", "Siames", 2, 7.6, "Dolor de estómago", "Activo","https://ca-times.brightspotcdn.com/dims4/default/796e6c9/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/75/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001"));
        data.put(19, new Paciente(19,"Duke", "Ragdoll ", 3, 16.9, "Alergia", "Activo","https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2021/04/siames-scaled.jpg?fit=2560%2C1707&quality=50&strip=all&ssl=1"));
        data.put(20, new Paciente(20,"Mia", "Devon Rex", 2, 7.1, "Gripe", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/220px-Cat_November_2010-1a.jpg"));
        data.put(21, new Paciente(21,"Leo", "Siames", 4, 21.7, "Fiebre", "Activo","https://as01.epimg.net/diarioas/imagenes/2022/04/20/actualidad/1650466413_240889_1650466661_noticia_normal_recorte1.jpg"));
        data.put(22, new Paciente(22,"Coco", "Siames", 1, 6.0, "Tos", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        data.put(23, new Paciente(23,"Milo", "Siames", 5, 13.2, "Dolor de estómago", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        data.put(24, new Paciente(24,"Rosie", "Siames", 2, 8.7, "Alergia", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        data.put(25, new Paciente(25,"Finn", "Siames", 3, 19.3, "Gripe", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
        data.put(26, new Paciente(26,"Ruby", "Devon Rex", 2, 7.9, "Fiebre", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Collage_of_Six_Cats-02.jpg/800px-Collage_of_Six_Cats-02.jpg"));
        data.put(27, new Paciente(27,"Oscar", "Ragdoll ", 4, 23.8, "Tos", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        data.put(28, new Paciente(28,"Lily", "Maine Coon", 1, 5.3, "Dolor de estómago", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        data.put(29, new Paciente(29,"Teddy", "Siames", 5, 10.7, "Alergia", "Activo","https://www.semana.com/resizer/QulPdczfzOqr_eiEznThKXUUA4s=/1280x720/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/JE2JDQ2GR5G7ZKS5MBDFR5THTE.jpg"));
        data.put(30, new Paciente(30,"Abby", "Siames", 2, 9.1, "Gripe", "Activo","https://www.infobae.com/new-resizer/xh88gZVUaYWydCiAgN49rAfUhGI=/arc-anglerfish-arc2-prod-infobae/public/UZS53SVISJHAHBC4PDQBVHX52M.jpeg"));
        data.put(31, new Paciente(31,"Cody", "Maine Coon", 3, 17.5, "Fiebre", "Activo","https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/22/media/cortadas/gato-fotolia-k8eH-U160340519019xEE-1248x770@Las%20Provincias.jpg"));
        data.put(32, new Paciente(32,"Zara", "Devon Rex", 2, 6.6, "Tos", "Activo", "https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg"));
        data.put(33, new Paciente(33,"Jackson", "Siames", 4, 20.4, "Dolor de estómago", "Activo","https://estaticos-cdn.sport.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg"));
        data.put(34, new Paciente(34,"Nala", "Siames", 1, 7.5, "Alergia", "Activo","https://www.elpais.com.co/resizer/zzMtz3dP412md6YrxomGW0wk2ZY=/1280x0/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/VUG44EJGYRCU3K4P7FH67RXMBQ.jpg"));
        data.put(35, new Paciente(35,"Riley", "Siames", 5, 14.1, "Gripe", "Activo","https://fotografias.lasexta.com/clipping/cmsimages02/2018/07/18/54202C79-C95C-4589-8C76-4CC8DB96E85C/98.jpg?crop=960,540,x0,y0&width=1900&height=1069&optimize=high&format=webply"));
        data.put(36, new Paciente(36,"Maggie", "Devon Rex", 2, 8.9, "Fiebre", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        data.put(37, new Paciente(37,"Winston", "Ragdoll ", 3, 16.2, "Tos", "Activo","https://images.milenio.com/JUFQtwNFWKlYiQGCTPVgfyD0-BM=/345x237/uploads/media/2020/02/20/tener-un-gatito-podria-tener.jpg"));
        data.put(38, new Paciente(38,"Lola", "Siames", 2, 7.2, "Dolor de estómago", "Activo","https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg"));
        data.put(39, new Paciente(39,"Sam", "Maine Coon", 4, 22.9, "Alergia", "Activo","https://ca-times.brightspotcdn.com/dims4/default/796e6c9/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/75/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001"));
        data.put(40, new Paciente(40,"Layla", "Siames", 1, 6.7, "Gripe", "Activo","https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2021/04/siames-scaled.jpg?fit=2560%2C1707&quality=50&strip=all&ssl=1"));
        data.put(41, new Paciente(41,"Zeus", "Siames", 5, 11.8, "Fiebre", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/220px-Cat_November_2010-1a.jpg"));
        data.put(42, new Paciente(42,"Gracie", "Siames", 2, 9.5, "Tos", "Activo","https://as01.epimg.net/diarioas/imagenes/2022/04/20/actualidad/1650466413_240889_1650466661_noticia_normal_recorte1.jpg"));
        data.put(43, new Paciente(43,"Hunter", "Siames", 3, 18.7, "Dolor de estómago", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        data.put(44, new Paciente(44,"Cleo", "Siames", 2, 6.2, "Alergia", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        data.put(45, new Paciente(45,"Harley", "Ragdoll ", 4, 21.0, "Gripe", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        data.put(46, new Paciente(46,"Penny", "Maine Coon", 1, 5.6, "Fiebre", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
        data.put(47, new Paciente(47,"Jax", "Siames", 5, 12.0, "Tos", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Collage_of_Six_Cats-02.jpg/800px-Collage_of_Six_Cats-02.jpg"));
        data.put(48, new Paciente(48,"Sasha", "Siames", 2, 7.8, "Dolor de estómago", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        data.put(49, new Paciente(49,"Maverick", "Siames", 3, 17.3, "Alergia", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        data.put(50, new Paciente(50,"Nina", "Siames", 2, 8.1, "Gripe", "Activo","https://www.semana.com/resizer/QulPdczfzOqr_eiEznThKXUUA4s=/1280x720/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/JE2JDQ2GR5G7ZKS5MBDFR5THTE.jpg"));
        data.put(51, new Paciente(51,"Rusty", "Ragdoll ", 4, 22.1, "Fiebre", "Activo","https://www.infobae.com/new-resizer/xh88gZVUaYWydCiAgN49rAfUhGI=/arc-anglerfish-arc2-prod-infobae/public/UZS53SVISJHAHBC4PDQBVHX52M.jpeg"));
        data.put(52, new Paciente(52,"Mila", "Maine Coon", 1, 6.4, "Tos", "Activo","https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/22/media/cortadas/gato-fotolia-k8eH-U160340519019xEE-1248x770@Las%20Provincias.jpg"));
        data.put(53, new Paciente(53,"Prince", "Siames", 5, 13.5, "Dolor de estómago", "Activo","https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg"));
        data.put(54, new Paciente(54,"Willow", "Siames", 2, 9.0, "Alergia", "Activo","https://estaticos-cdn.sport.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg"));
        data.put(55, new Paciente(55,"Sammy", "Siames", 3, 19.9, "Gripe", "Activo","https://www.elpais.com.co/resizer/zzMtz3dP412md6YrxomGW0wk2ZY=/1280x0/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/VUG44EJGYRCU3K4P7FH67RXMBQ.jpg"));
        data.put(56, new Paciente(56,"Ivy", "Maine Coon", 2, 7.4, "Fiebre", "Activo","https://fotografias.lasexta.com/clipping/cmsimages02/2018/07/18/54202C79-C95C-4589-8C76-4CC8DB96E85C/98.jpg?crop=960,540,x0,y0&width=1900&height=1069&optimize=high&format=webply"));
        data.put(57, new Paciente(57,"Loki", "Ragdoll ", 4, 23.0, "Tos", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        data.put(58, new Paciente(58,"Piper", "Siames", 1, 5.1, "Dolor de estómago", "Activo","https://images.milenio.com/JUFQtwNFWKlYiQGCTPVgfyD0-BM=/345x237/uploads/media/2020/02/20/tener-un-gatito-podria-tener.jpg"));
        data.put(59, new Paciente(59,"Toby", "Devon Rex", 5, 10.3, "Alergia", "Activo","https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg"));
        data.put(60, new Paciente(60,"Hazel", "Siames", 2, 8.2, "Gripe", "Activo","https://ca-times.brightspotcdn.com/dims4/default/796e6c9/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/75/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001"));
        data.put(61, new Paciente(61,"Axel", "Siames", 3, 15.2, "Fiebre", "Activo","https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2021/04/siames-scaled.jpg?fit=2560%2C1707&quality=50&strip=all&ssl=1"));
        data.put(62, new Paciente(62,"Emma", "Ragdoll ", 2, 6.8, "Tos", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/220px-Cat_November_2010-1a.jpg"));
        data.put(63, new Paciente(63,"Chase", "Siames", 4, 20.5, "Dolor de estómago", "Activo","https://as01.epimg.net/diarioas/imagenes/2022/04/20/actualidad/1650466413_240889_1650466661_noticia_normal_recorte1.jpg"));
        data.put(64, new Paciente(64,"Lilly", "Siames", 1, 7.7, "Alergia", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        data.put(65, new Paciente(65,"Dexter", "Siames", 5, 12.4, "Gripe", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        data.put(66, new Paciente(66,"Lola", "Maine Coon", 2, 9.3, "Fiebre", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        data.put(67, new Paciente(67,"Gus", "Maine Coon", 3, 18.1, "Tos", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
        data.put(68, new Paciente(68,"Lulu", "Devon Rex", 2, 7.0, "Dolor de estómago", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Collage_of_Six_Cats-02.jpg/800px-Collage_of_Six_Cats-02.jpg"));
        data.put(69, new Paciente(69,"Kobe", "Siames", 4, 21.2, "Alergia", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        data.put(70, new Paciente(70,"Cupcake", "Siames", 1, 5.4, "Gripe", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        data.put(71, new Paciente(71,"Rex", "Siames", 5, 11.5, "Fiebre", "Activo","https://www.semana.com/resizer/QulPdczfzOqr_eiEznThKXUUA4s=/1280x720/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/JE2JDQ2GR5G7ZKS5MBDFR5THTE.jpg"));
        data.put(72, new Paciente(72,"Mocha", "Siames", 2, 8.5, "Tos", "Activo","https://www.infobae.com/new-resizer/xh88gZVUaYWydCiAgN49rAfUhGI=/arc-anglerfish-arc2-prod-infobae/public/UZS53SVISJHAHBC4PDQBVHX52M.jpeg"));
        data.put(73, new Paciente(73,"Apollo", "Siames", 3, 16.5, "Dolor de estómago", "Activo","https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/22/media/cortadas/gato-fotolia-k8eH-U160340519019xEE-1248x770@Las%20Provincias.jpg"));
        data.put(74, new Paciente(74,"Ella", "Maine Coon", 2, 6.1, "Alergia", "Activo","https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg"));
        data.put(75, new Paciente(75,"Hunter", "Ragdoll ", 4, 22.5, "Gripe", "Activo","https://estaticos-cdn.sport.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg"));
        data.put(76, new Paciente(76,"Minnie", "Devon Rex", 1, 7.4, "Fiebre", "Activo","https://www.elpais.com.co/resizer/zzMtz3dP412md6YrxomGW0wk2ZY=/1280x0/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/VUG44EJGYRCU3K4P7FH67RXMBQ.jpg"));
        data.put(77, new Paciente(77,"Louie", "Devon Rex", 5, 12.9, "Tos", "Activo","https://fotografias.lasexta.com/clipping/cmsimages02/2018/07/18/54202C79-C95C-4589-8C76-4CC8DB96E85C/98.jpg?crop=960,540,x0,y0&width=1900&height=1069&optimize=high&format=webply"));
        data.put(78, new Paciente(78,"Harper", "Siames", 2, 9.2, "Dolor de estómago", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        data.put(79, new Paciente(79,"Bruno", "Siames", 3, 17.8, "Alergia", "Activo","https://images.milenio.com/JUFQtwNFWKlYiQGCTPVgfyD0-BM=/345x237/uploads/media/2020/02/20/tener-un-gatito-podria-tener.jpg"));
        data.put(80, new Paciente(80,"Maddie", "Devon Rex", 2, 7.3, "Gripe", "Activo","https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg"));
        data.put(81, new Paciente(81,"Oliver", "Siames", 4, 20.8, "Fiebre", "Activo","https://ca-times.brightspotcdn.com/dims4/default/796e6c9/2147483647/strip/true/crop/1970x1108+39+0/resize/1200x675!/quality/75/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F12%2Fa5%2F79e097ccf62312d18a025f22ce48%2Fhoyla-recuento-11-cosas-aman-gatos-top-001"));
        data.put(82, new Paciente(82,"Ziggy", "Siames", 1, 5.7, "Tos", "Activo","https://i0.wp.com/imgs.hipertextual.com/wp-content/uploads/2021/04/siames-scaled.jpg?fit=2560%2C1707&quality=50&strip=all&ssl=1"));
        data.put(83, new Paciente(83,"Carter", "Maine Coon", 5, 11.2, "Dolor de estómago", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/220px-Cat_November_2010-1a.jpg"));
        data.put(84, new Paciente(84,"Penelope", "Siames", 2, 8.4, "Alergia", "Activo","https://as01.epimg.net/diarioas/imagenes/2022/04/20/actualidad/1650466413_240889_1650466661_noticia_normal_recorte1.jpg"));
        data.put(85, new Paciente(85,"Rocco", "Siames", 3, 19.1, "Gripe", "Activo","https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067"));
        data.put(86, new Paciente(86,"Honey", "Maine Coon", 2, 6.5, "Fiebre", "Activo","https://www.tiendanimal.es/articulos/wp-content/uploads/2022/03/Gato-Singapura.jpg"));
        data.put(87, new Paciente(87,"Rusty", "Siames", 4, 21.8, "Tos", "Activo","https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png"));
        data.put(88, new Paciente(88,"Nova", "Siames", 1, 7.3, "Dolor de estómago", "Activo","https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg"));
        data.put(89, new Paciente(89,"Hank", "Devon Rex", 5, 12.3, "Alergia", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Collage_of_Six_Cats-02.jpg/800px-Collage_of_Six_Cats-02.jpg"));
        data.put(90, new Paciente(90,"Sunny", "Maine Coon", 2, 8.6, "Gripe", "Activo","https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg"));
        data.put(91, new Paciente(91,"Marley", "Siames", 3, 17.0, "Fiebre", "Activo","https://static.fundacion-affinity.org/cdn/farfuture/hHjlkRJJ0mnR1zVGzWk-SEX1BpGXvE56GGuN6h89MWM/mtime:1528830329/sites/default/files/descubre-como-se-comporta-un-gato.jpg?itok=n2kVSTSl"));
        data.put(92, new Paciente(92,"Gigi", "Ragdoll ", 2, 6.7, "Tos", "Activo","https://www.semana.com/resizer/QulPdczfzOqr_eiEznThKXUUA4s=/1280x720/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/JE2JDQ2GR5G7ZKS5MBDFR5THTE.jpg"));
        data.put(93, new Paciente(93,"Koda", "Siames", 4, 20.0, "Dolor de estómago", "Activo","https://www.infobae.com/new-resizer/xh88gZVUaYWydCiAgN49rAfUhGI=/arc-anglerfish-arc2-prod-infobae/public/UZS53SVISJHAHBC4PDQBVHX52M.jpeg"));
        data.put(94, new Paciente(94,"Olive", "Maine Coon", 1, 7.9, "Alergia", "Activo","https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/22/media/cortadas/gato-fotolia-k8eH-U160340519019xEE-1248x770@Las%20Provincias.jpg"));
        data.put(95, new Paciente(95,"Brutus", "Maine Coon", 5, 12.7, "Gripe", "Activo","https://static.eldiario.es/clip/ab74aa95-3656-424c-8ca1-dce590aabb97_16-9-discover-aspect-ratio_default_0.jpg"));
        data.put(96, new Paciente(96,"Lizzie", "Siames", 2, 8.0, "Fiebre", "Activo","https://estaticos-cdn.sport.es/clip/132634e7-ba6a-4ea6-b531-f0377b7a9eba_alta-libre-aspect-ratio_default_0.jpg"));
        data.put(97, new Paciente(97,"Riley", "Maine Coon", 3, 18.5, "Tos", "Activo","https://www.elpais.com.co/resizer/zzMtz3dP412md6YrxomGW0wk2ZY=/1280x0/smart/filters:format(jpg):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/semana/VUG44EJGYRCU3K4P7FH67RXMBQ.jpg"));
        data.put(98, new Paciente(98,"Lola", "Siames", 2, 6.4, "Dolor de estómago", "Activo","https://fotografias.lasexta.com/clipping/cmsimages02/2018/07/18/54202C79-C95C-4589-8C76-4CC8DB96E85C/98.jpg?crop=960,540,x0,y0&width=1900&height=1069&optimize=high&format=webply"));
        data.put(99, new Paciente(99,"Cash", "Maine Coon", 4, 21.4, "Alergia", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        data.put(100, new Paciente(100,"Mochi", "Siames", 1, 7.1, "Gripe", "Activo","https://images.milenio.com/JUFQtwNFWKlYiQGCTPVgfyD0-BM=/345x237/uploads/media/2020/02/20/tener-un-gatito-podria-tener.jpg"));
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
