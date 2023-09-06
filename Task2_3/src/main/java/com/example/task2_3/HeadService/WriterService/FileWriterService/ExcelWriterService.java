package com.example.task2_3.HeadService.WriterService.FileWriterService;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.task2_3.Entity.EmployeeEntity;
import com.example.task2_3.HeadService.WriterService.WriterService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ExcelWriterService implements WriterService {

	@Autowired
	HttpServletResponse servletResponse;

	@Override
	public void writeData(List<EmployeeEntity> employeeList) {
		try {

			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Employee Info");
			HSSFRow row = sheet.createRow(0);

			row.createCell(0).setCellValue("emp_id");
			row.createCell(1).setCellValue("emp_name");
			row.createCell(2).setCellValue("emp_sal");

			int dataRowIndex = 1;

			for (EmployeeEntity employee : employeeList) {
				HSSFRow dataRow = sheet.createRow(dataRowIndex);

				dataRow.createCell(0).setCellValue(employee.getEmp_id());
				dataRow.createCell(1).setCellValue(employee.getEmp_name());
				dataRow.createCell(2).setCellValue(employee.getEmp_sal());

				dataRowIndex++;
			}

			servletResponse.setContentType("application/octet-stream");
			String headerKey = "Content-Disposition";
			String headerValue = "attachment;filename=employeesdata.xls";
			servletResponse.setHeader(headerKey, headerValue);

			ServletOutputStream ops = servletResponse.getOutputStream();
			workbook.write(ops);
			workbook.close();
			ops.close();

		} catch (Exception e) {

		}
	}
}
