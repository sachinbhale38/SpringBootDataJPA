package com.jbk.app;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jbk.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> getEmployeeByNameOrderByEidDesc(String name);//Query DSL

	@Query("from Employee where name=:name")
	List<Employee> getEmployeeByNameQuery(@Param("name")String name);

}
