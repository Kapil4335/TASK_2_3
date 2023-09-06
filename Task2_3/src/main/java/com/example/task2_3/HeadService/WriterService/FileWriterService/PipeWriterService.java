package com.example.task2_3.HeadService.WriterService.FileWriterService;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task2_3.HeadService.WriterService.WriterService;
import com.example.task2_3.Entity.EmployeeEntity;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class PipeWriterService implements WriterService {

	@Autowired
	HttpServletResponse servletResponse;

	@Override
	public void writeData(List<EmployeeEntity> employeeList) {
		try {

			FileWriter filew = new FileWriter("files/filePipe.txt");

			BufferedWriter bw = new BufferedWriter(filew);

			bw.write("emp_id " + "| " + "emp_name" + "| " + "emp_sal");
			bw.newLine();

			for (EmployeeEntity employee : employeeList) {

				bw.write(employee.getEmp_id() + "| " + employee.getEmp_name() + "| " + employee.getEmp_sal());
				bw.newLine();

			}
			bw.close();

			File file = new File("files/filePipe.txt");
			servletResponse.setContentType("csv/txt");
			String headerKey = ("Content-Disposition");
			String headerValue = ("attachment;filename=" + file.getName());

			servletResponse.setHeader(headerKey, headerValue);

			ServletOutputStream outputStream = servletResponse.getOutputStream();

			BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			byte[] buffer = new byte[8192];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			inputStream.close();
			outputStream.close();

		} catch (Exception e) {
		}
	}
}
