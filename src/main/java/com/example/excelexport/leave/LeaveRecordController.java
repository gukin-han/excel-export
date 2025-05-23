package com.example.excelexport.leave;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LeaveRecordController {

  private final LeaveRecordService leaveRecordService;

  @GetMapping("/leave-record/export")
  public void exportLeaveRecord(HttpServletResponse response) throws IOException {
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setHeader("Content-Disposition", "attachment; filename=leave_report.xlsx");

    leaveRecordService.writeLeaveExcel(response.getOutputStream());
  }
}
