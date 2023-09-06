package com.example.task2_3.HeadService.WriterService.DBWriterService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task2_3.Entity.EmployeeEntity;
import com.example.task2_3.HeadService.WriterService.WriterService;
import com.example.task2_3.Repository.DBWriterRepo;

import com.example.task2_3.Entity.DBWriterEntity;

@Service
public class DBWriter implements WriterService {

	@Autowired
	private DBWriterRepo dbWriterRepo;

	@Override
	public void writeData(List<EmployeeEntity> employeeList) {
		DBWriterEntity dbWriterEntity = new DBWriterEntity();

		for (EmployeeEntity employee : employeeList) {
			dbWriterEntity.setEmp_id(employee.getEmp_id());
			dbWriterEntity.setEmp_name(employee.getEmp_name());
			dbWriterEntity.setEmp_sal(employee.getEmp_sal());

			dbWriterRepo.save(dbWriterEntity);
		}
	}
}
