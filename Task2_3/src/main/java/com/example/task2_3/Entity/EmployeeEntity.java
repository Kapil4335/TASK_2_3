package com.example.task2_3.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "test_emp_table")
public class EmployeeEntity {

	@Id
	int emp_id;
	String emp_name;
	double emp_sal;

	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(int emp_id, String emp_name, double emp_sal) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_sal = emp_sal;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public double getEmp_sal() {
		return emp_sal;
	}

	public void setEmp_sal(double emp_sal) {
		this.emp_sal = emp_sal;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_sal=" + emp_sal + "]";
	}

}
