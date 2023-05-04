package com.adeel.restapi.service;

import com.adeel.restapi.persistence.Department;
import com.adeel.restapi.persistence.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> findAll(){
        return this.repository.findAll();
    }

    public Department findById(Long id){
        return this.repository.findById(id).get();
    }

    public Department add(Department model){
        return this.repository.save(model);
    }

    public Department update(Department model){
        Optional<Department> department = this.repository.findById(model.getId());
        if (department.isPresent()){
            department.get().setName(model.getName());
            return this.repository.save(department.get());
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }
}
