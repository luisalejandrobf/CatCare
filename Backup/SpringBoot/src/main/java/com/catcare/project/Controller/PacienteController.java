package com.catcare.project.Controller;

import com.catcare.project.Controller.Error.PacienteNotFoundException;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Service.ClienteService;
import com.catcare.project.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/catcare/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    // http://localhost:8090/catcare/pacientes/all
    @GetMapping("/all")
    public String mostrarPacientes(Model model) {
        // Envía la lista de mascotas desde el servicio pacienteService a Thymeleaf para que la página HTML pueda recuperarla
        model.addAttribute("pacientes", pacienteService.SearchAll());

        // Devuelve la vista llamada "/General/showPacientes" para mostrar la lista de pacientes
        return "/General/showPacientes";
    }


    // http://localhost:8090/catcare/pacientes/find?id=1
    @GetMapping("/find")
    public String mostrarInfoPacientes(Model model, @RequestParam("id") Long id) {
        // Busca un paciente por su ID utilizando el servicio pacienteService
        Paciente paciente = pacienteService.SearchById(id);

        // Verifica si se encontró el paciente
        if (paciente != null) {
            // Si el paciente existe, agrega el paciente al modelo para mostrar su información
            model.addAttribute("paciente", paciente);
        } else {
            // Si no se encontró el paciente, lanza una excepción de tipo PacienteNotFoundException
            throw new PacienteNotFoundException(id);
        }

        // Devuelve la vista llamada "/General/showPaciente" para mostrar la información del paciente
        return "/General/showPaciente";
    }


    // http://localhost:8090/catcare/pacientes/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        // Crea un objeto Paciente con valores predeterminados para mostrar en el formulario de creación
        Paciente paciente = new Paciente("", "", 0, 0, "", "", "");

        // Se puede asignar un ID calculado aquí si se desea
        // paciente.setId(pacienteService.size()+1);

        // Se recomienda añadir un campo oculto en el formulario para evitar un ID nulo
        // Recordar añadir <input th:field="${paciente.id}" type="hidden"> para evitar tener un ID nulo.

        // Agrega el objeto Paciente al modelo para que los datos puedan ser utilizados en la vista
        model.addAttribute("paciente", paciente);

        // Devuelve la vista llamada "/General/crearPaciente" que contiene el formulario de creación de pacientes
        return "/General/crearPaciente";
    }


    // Post para agregar Paciente
    @PostMapping("/agregar")
    public String agregarPaciente(@ModelAttribute("paciente") Paciente paciente) {
        // Agrega el paciente recibido en el formulario al servicio pacienteService para su creación
        pacienteService.add(paciente);

        // Redirige al usuario a la página que muestra la lista de todos los pacientes después de agregar el nuevo paciente
        return "redirect:/catcare/pacientes/all";
    }


    //  Delete GENERAL http://localhost:8090/catcare/pacientes/delete/1
    @GetMapping("/delete/{id}")
    public String eliminarPaciente(@PathVariable("id") Long id) {

        // Opción 1: Borrado total
        // pacienteService.deleteById(id);

        // Opción 2: Cambia el estado por "Inactivo"
        // Busca al paciente por su ID utilizando el servicio pacienteService
        Paciente paciente = pacienteService.SearchById(id);

        // Cambia el estado del paciente a "Inactivo"
        paciente.setEstado("Inactivo");

        // Actualiza el paciente en la base de datos utilizando el servicio pacienteService
        pacienteService.update(paciente);

        // Redirige al usuario a la página que muestra la lista de todos los pacientes después de la acción de eliminación
        return "redirect:/catcare/pacientes/all";
    }


    // UPDATE GENERAL http://localhost:8090/catcare/pacientes/update/1
    @GetMapping("/update/{id}")
    public String actualizarPaciente(@PathVariable("id") Long id, Model model) {
        // Busca al paciente por su ID utilizando el servicio pacienteService
        Paciente paciente = pacienteService.SearchById(id);

        // Agrega el paciente al modelo para que los datos puedan ser utilizados en la vista de actualización
        model.addAttribute("paciente", paciente);

        // Devuelve la vista llamada "/General/actualizarPaciente" que contiene el formulario de actualización de pacientes
        return "/General/actualizarPaciente";
    }


    // Post para Update del cliente. Se accede con el ID del Paciente.
    @PostMapping("/update/{id}")
    public String actualizarPaciente(@PathVariable("id") Long id, @ModelAttribute("paciente") Paciente paciente) {
        // Actualiza el paciente con los datos recibidos del formulario utilizando el servicio pacienteService
        pacienteService.update(paciente);

        // Redirige al usuario a la página que muestra la lista de todos los pacientes después de la actualización
        return "redirect:/catcare/pacientes/all";
    }


    // ESTANDO EN UN PACIENTE (Regresa a la URL de visualizacion de las mascotas del cliente)

    // UPDATE http://localhost:8090/catcare/pacientes/update/1
    @GetMapping("/update/{clienteid}/{id}")
    public String actualizarPacienteDeUnCliente(@PathVariable("id") Long id, @PathVariable("clienteid") Long clienteid, Model model) {
        // Busca al paciente por su ID utilizando el servicio pacienteService
        Paciente paciente = pacienteService.SearchById(id);

        // Agrega el paciente y el ID del cliente al modelo para que los datos puedan ser utilizados en la vista de actualización
        model.addAttribute("paciente", paciente);
        model.addAttribute("clienteid", clienteid);

        // Devuelve la vista llamada "/Cliente/actualizarPacienteDeUnCliente" que contiene el formulario de actualización de pacientes para un cliente específico
        return "/Cliente/actualizarPacienteDeUnCliente";
    }


    // Post para Update del cliente. Se accede con el ID del Paciente.
    @PostMapping("/update/{clienteid}/{id}")
    public String actualizarPacienteDeUnCliente(@PathVariable("id") Long id, @PathVariable("clienteid") Long clienteid, @ModelAttribute("paciente") Paciente paciente) {
        // Actualiza el paciente con los datos recibidos del formulario utilizando el servicio pacienteService
        pacienteService.update(paciente);

        // Redirige al usuario de vuelta a la página de visualización de las mascotas del cliente después de la actualización
        return "redirect:/catcare/clientes/mascotas/{clienteid}";
    }


    // metodo para encontrar mascota de cliente
    @GetMapping("/mostrar/{clienteid}/{id}")
    public String mostrarInfoPacienteDeUnCliente(@PathVariable("id") Long id, @PathVariable("clienteid") Long clienteid, Model model) {
        // Busca al paciente por su ID utilizando el servicio pacienteService
        Paciente paciente = pacienteService.SearchById(id);

        // Agrega el paciente y el ID del cliente al modelo para que los datos puedan ser utilizados en la vista
        model.addAttribute("paciente", paciente);
        model.addAttribute("clienteid", clienteid);

        // Devuelve la vista llamada "/Cliente/showPacienteDeUnCliente" que muestra la información del paciente de un cliente específico
        return "/Cliente/showPacienteDeUnCliente";
    }


    // DELETE http://localhost:8090/catcare/pacientes/delete/1
    @GetMapping("/delete/{clienteid}/{id}")
    public String eliminarPaciente(@PathVariable("id") Long id, @PathVariable("clienteid") Long clienteid) {
        // Elimina el paciente con el ID proporcionado utilizando el servicio pacienteService
        pacienteService.deleteById(id);

        // Después de eliminar el paciente, redirige al usuario de vuelta a la página de visualización de mascotas del cliente
        return "redirect:/catcare/clientes/mascotas/{clienteid}";
    }
}
