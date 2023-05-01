package com.persproj.Springbootlearn.repository;

import com.persproj.Springbootlearn.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("Mechanical Engineering")
                .departmentAddress("Delhi").departmentCode("ME-011").build();

        testEntityManager.persist(department);
    }

    @Test
    @DisplayName("Get Department When Valid ID is passed")
    public void whenFindByIdThenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();

        assertEquals(department.getDepartmentName(), "Mechanical Engineering");
    }
}