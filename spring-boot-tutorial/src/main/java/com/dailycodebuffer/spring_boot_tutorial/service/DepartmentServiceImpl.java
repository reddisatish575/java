package com.dailycodebuffer.spring_boot_tutorial.service;

import com.dailycodebuffer.spring_boot_tutorial.entity.Department;
import com.dailycodebuffer.spring_boot_tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department oldDepartment = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equals(department.getDepartmentName())) {
            oldDepartment.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equals(department.getDepartmentCode())) {
            oldDepartment.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equals(department.getDepartmentAddress())) {
            oldDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }


        return departmentRepository.save(oldDepartment);
    }

    @Override
    public List<Department> saveAllDepartment(List<Department> departments) {
        return departmentRepository.saveAll(departments);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
//        return departmentRepository.findByDepartmentName(departmentName);
          return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
