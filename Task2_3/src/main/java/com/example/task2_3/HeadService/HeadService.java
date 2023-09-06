package com.example.task2_3.HeadService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task2_3.Entity.EmployeeEntity;
import com.example.task2_3.HeadService.ReaderService.ReaderService;
import com.example.task2_3.HeadService.ReaderService.ReaderServiceFactory;
import com.example.task2_3.HeadService.WriterService.WriterService;
import com.example.task2_3.HeadService.WriterService.WriterServiceFactory;

@Service
public class HeadService {
	@Autowired
	private ReaderServiceFactory readerServiceFactory;
	@Autowired
	private WriterServiceFactory writerServiceFactory;

	public void process(String readerCriteria, String writerCriteria) {

		ReaderService readerService = readerServiceFactory.dataReader(readerCriteria);
		List<EmployeeEntity> employeeList = readerService.getData();

		WriterService writerService = writerServiceFactory.getWriter(employeeList, writerCriteria);
		writerService.writeData(employeeList);

	}
}
