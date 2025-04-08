package com.dailycodebuffer.spring_boot_tutorial.service;

import com.dailycodebuffer.spring_boot_tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);

    public void deleteDepartment(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public List<Department> saveAllDepartment(List<Department> departments);

    public Department fetchDepartmentByName(String departmentName);
}
