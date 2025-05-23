package com.example.excelexport.leave;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaveRecordService {

  private final LeaveRecordRepository leaveRecordRepository;

  public void writeLeaveExcel(OutputStream out) throws IOException {
    List<LeaveRecord> leaveRecords = getLeaveRecords();

    SXSSFWorkbook workBook = new SXSSFWorkbook();
    SXSSFSheet sheet = workBook.createSheet();

    int rowIndex = 0;

    // create header
    Row header = sheet.createRow(rowIndex++);
    header.createCell(0).setCellValue("이름");
    header.createCell(1).setCellValue("휴가 유형");
    header.createCell(2).setCellValue("날짜");
    header.createCell(3).setCellValue("시간");
    header.createCell(4).setCellValue("비고");

    // create body
    for (LeaveRecord record : leaveRecords) {
      Row row = sheet.createRow(rowIndex++);
      row.createCell(0).setCellValue(record.getEmpName());
      row.createCell(1).setCellValue(record.getLeaveType());
      row.createCell(2).setCellValue(record.getLeaveDate());
      row.createCell(3).setCellValue(record.getDuration());
      row.createCell(4).setCellValue(record.getNote());
    }

    workBook.write(out);
    workBook.close();
  }

  private List<LeaveRecord> getLeaveRecords() {
    return leaveRecordRepository.findAll();
  }
}
