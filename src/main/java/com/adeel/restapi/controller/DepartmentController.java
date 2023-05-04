package com.adeel.restapi.controller;

import com.adeel.restapi.persistence.Department;
import com.adeel.restapi.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/department")
public class DepartmentController {
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/find-all")
    public List<Department> getAll(){
        return this.departmentService.findAll();
    }

    @GetMapping(value = "/find-by-id/{id}")
    public Department getById(@PathVariable Long id){
        return this.departmentService.findById(id);
    }

    @PostMapping(value = "/add")
    public Department add(Department model){
        return this.departmentService.add(model);
    }

    @PostMapping(value = "/update")
    public Department update(Department model){
        return this.departmentService.update(model);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        this.departmentService.delete(id);
    }
}
