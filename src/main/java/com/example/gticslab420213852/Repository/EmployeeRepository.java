package com.example.gticslab420213852.Repository;

import com.example.gticslab420213852.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.beans.Transient;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into employees(first_name,last_name,email,password,job_id,salary,manager_id,department_id) values(?1,?2,?3,?4,?5,?6,?7,?8)",nativeQuery = true)
    void agregarEmpleado(String nombre,String apellido,String correo,String contrasena,String idJob,Double salario,Integer idManager,Integer idDepartment);

    @Transactional
    @Modifying
    @Query(value = "delete from employees where manager_id=?1",nativeQuery = true)
    void eliminarTrabajadores(Integer id);

    @Transactional
    @Modifying
    @Query(value = "delete from employees where employee_id=?1",nativeQuery = true)
    void eliminarEmpleado(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update employees set department_id=?1 where employee_id=?2",nativeQuery = true)
    void cambiarDepartamentoPorId(Integer idDepartamento,Integer id);

    @Transactional
    @Modifying
    @Query(value = "update employees set job_id=?1 where employee_id=?2",nativeQuery = true)
    void cambiarTrabajoPorId(String idPuesto,Integer id);

    @Query(value = "select e.* from employees e inner join jobs j on e.job_id=j.job_id inner join departments d on e.department_id=d.department_id inner join locations l on d.location_id=l.location_id where e.first_name like %?1% or e.last_name like %?1% or j.job_title like %?1% or l.city like %?1%",nativeQuery = true)
    List<Employee> filtroEmpleados(String busqueda);

    @Query(value = "select * from employees where employee_id=?1",nativeQuery = true)
    Employee empleadoPorId(Integer id);
}