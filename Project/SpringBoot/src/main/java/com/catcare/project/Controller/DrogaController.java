package com.catcare.project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.catcare.project.DTOs.ClienteDTO;
import com.catcare.project.DTOs.ClienteMapper;
import com.catcare.project.DTOs.DrogaDTO;
import com.catcare.project.DTOs.DrogaMapper;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Droga;
import com.catcare.project.Service.DrogaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/catcare/drogas")
@CrossOrigin(origins = "http://localhost:4200") // Permitir realizar peticiones desde angular
public class DrogaController {

    @Autowired
    DrogaService drogaService;

    // Envía la lista de drogas desde drogaService a Thymeleaf para que
    // el HTML pueda acceder a ella.
    // http://localhost:8090/catcare/drogas/all
    @GetMapping("/all")
    @Operation(summary = "Devuelve todas las drogas")
    public List<Droga> mostrarDrogas() {
        return (List<Droga>) drogaService.SearchAll();
    }

    @GetMapping("/allFiltered")
    @Operation(summary = "Devuelve todas las drogas")
    public ResponseEntity<List<DrogaDTO>> mostrarDrogas_filtered() {

        List<Droga> listaDrogas = new ArrayList<>(drogaService.SearchAll());
        List<DrogaDTO> listaDrogasDTO = new ArrayList<>();
    
        for (Droga droga : listaDrogas) {
            DrogaDTO drogaDTO = DrogaMapper.INSTANCE.convert(droga);
            listaDrogasDTO.add(drogaDTO);
        }
    
        return new ResponseEntity<>(listaDrogasDTO, HttpStatus.OK);

    }


    // http://localhost:8090/catcare/drogas/find?id=1
    @GetMapping("/find")
    @Operation(summary = "Devuelve una droga")
    public Droga mostrarInfoDrogas(@RequestParam("id") Long id) {

        // Busca una droga por su ID utilizando el servicio drogaService
        Droga droga = drogaService.SearchById(id);

        if (droga != null) {
            // Verifica si se encontró la droga
        } else {
            // Si no se encontró el dr, retornar vacio
            droga = new Droga();
        }

        return droga;
    }

    // El metodo para agregar solo envia a la pagina, se deja unicamente el post.
    // http://localhost:8090/catcare/drogas/agregar
    @PostMapping("/agregar")
    @Operation(summary = "Agrega una droga")
    public void agregarDroga(@RequestBody Droga droga) {
        // Llama al servicio drogaService para agregar la droga a la base de datos
        drogaService.add(droga);
    }

    // http://localhost:8090/catcare/drogas/delete/1
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina una droga")
    public void eliminarDroga(@PathVariable("id") Long id) {
        // Llama al servicio drogaService para eliminar la droga con el ID especificado
        drogaService.deleteById(id);
    }

    // El metodo para actualizar solo envia a la pagina, se deja unicamente el post.
    // Post para Update de la droga. Se accede con el ID de la droga.
    // http://localhost:8090/catcare/drogas/update/1
    @PutMapping("/update/{id}")
    @Operation(summary = "Actualiza una droga")
    public void actualizarDroga(@PathVariable("id") Long id, @RequestBody Droga droga) {
        // Llama al servicio drogaService para actualizar los datos de la droga con el ID especificado
        drogaService.update(droga);
    }


    

    // Consultas

    // http://localhost:8090/catcare/drogas/medicamentosUltimoMes
    @GetMapping("/medicamentosUltimoMes")
    @Operation(summary = "Devuelve la cantidad de tratamientos por tipo de medicamento administrado en el último mes")
    public List<Object[]> medicamentosUltimoMes() {
        
    return drogaService.getDrogaCantidadLastMonth();
    }

    // http://localhost:8090/catcare/drogas/ventasTotales
    @GetMapping("/ventasTotales")
    @Operation(summary = "Devuelve las ventas totales de la veterinaria")
    public Float ventasTotales() {
    return drogaService.calcularVentasTotales();
    }

    // http://localhost:8090/catcare/drogas/gananciasTotales
    @GetMapping("/gananciasTotales")
    @Operation(summary = "Devuelve las ganancias totales de la veterinaria")
    public Float gananciasTotales() {
    return drogaService.calcularGananciasTotales();
    }

    // http://localhost:8090/catcare/drogas/top3Tratamientos
    @GetMapping("/top3Tratamientos")
    @Operation(summary = "Devuelve el top 3 tratamientos con más unidades vendidas")
    public List<Object[]> top3Tratamientos() {
    return drogaService.getTop3MedicamentosUnidadesVendidas();
    }

}
