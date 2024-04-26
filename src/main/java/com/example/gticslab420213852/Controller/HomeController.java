package com.example.gticslab420213852.Controller;

import com.example.gticslab420213852.Entity.Employee;
import com.example.gticslab420213852.Repository.DepartmentRepository;
import com.example.gticslab420213852.Repository.EmployeeRepository;
import com.example.gticslab420213852.Repository.JobRepository;
import com.example.gticslab420213852.Repository.LocationRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    final EmployeeRepository employeeRepository;
    final JobRepository jobRepository;
    final DepartmentRepository departmentRepository;
    final LocationRepository locationRepository;

    public HomeController(EmployeeRepository employeeRepository, JobRepository jobRepository, DepartmentRepository departmentRepository, LocationRepository locationRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.departmentRepository = departmentRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping("")
    private String vistaInicial(){
        return "vistaPrincipal";
    }

    @GetMapping("/empleados")
    private String empleados(Model model){
        model.addAttribute("listaEmpleados",employeeRepository.findAll());
        return "empleados";
    }

    @GetMapping("/buscarEmpleados")
    private String empleados(Model model,@RequestParam("busqueda") String busqueda){
        model.addAttribute("listaEmpleados",employeeRepository.filtroEmpleados(busqueda));
        model.addAttribute("busqueda",busqueda);
        return "empleados";
    }

    @GetMapping("/agregarEmpleado")
    private String agregarEmpleado(Model model){
        model.addAttribute("listaTrabajos",jobRepository.findAll());
        model.addAttribute("listaManagers",employeeRepository.findAll());
        model.addAttribute("listaDepartamentos",departmentRepository.findAll());
        return "nuevoEmpleado";
    }

    @GetMapping("/editarEmpleado")
    private String editarEmpleado(Model model,
                                  @RequestParam("id")Integer id){
        model.addAttribute("empleado",employeeRepository.empleadoPorId(id));
        model.addAttribute("listaDepartamentos",departmentRepository.findAll());
        model.addAttribute("listaTrabajos",jobRepository.findAll());
        model.addAttribute("listaCiudades",locationRepository.findAll());
        return "editarEmpleado";
    }

    @PostMapping("/guardarEmpleadoAgregar")
    private String guardarEmpleadoAgregar(Model model,
                                          @RequestParam("nombre")String nombre,
                                          @RequestParam("apellido")String apellido,
                                          @RequestParam("email")String email,
                                          @RequestParam("contrasena")String contrasena,
                                          @RequestParam("idPuesto")String idPuesto,
                                          @RequestParam("sueldo")Double sueldo,
                                          @RequestParam("idJefe")Integer idJefe,
                                          @RequestParam("idDepartamento")Integer idDepartamento){
        employeeRepository.agregarEmpleado(nombre,apellido,email,contrasena,idPuesto,sueldo,idJefe,idDepartamento);
        return "redirect:/empleados";
    }

    @PostMapping("/guardarEmpleadoEditar")
    private String guardarEmpleadoEditar(Model model,
                                          @RequestParam("id")Integer idEmpleado,
                                          @RequestParam("idCiudad")Integer idCiudad,
                                          @RequestParam("idPuesto")String idPuesto,
                                          @RequestParam("idDepartamento")Integer idDepartamento){
        employeeRepository.cambiarDepartamentoPorId(idDepartamento,idEmpleado);
        departmentRepository.cambiarCiudadPorId(idCiudad,idDepartamento);
        employeeRepository.cambiarTrabajoPorId(idPuesto,idEmpleado);
        return "redirect:/empleados";
    }

    @GetMapping("/borrarEmpleado")
    private String borrarEmpleado(Model model,
                                          @RequestParam("id")Integer id){
        employeeRepository.eliminarTrabajadores(id);
        employeeRepository.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
}
