package com.example.excelexport.init;

import com.example.excelexport.leave.LeaveRecord;
import com.example.excelexport.leave.LeaveRecordRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

  private final LeaveRecordRepository leaveRecordRepository;

  @Override
  public void run(String... args) throws Exception {
    if (leaveRecordRepository.count() == 0) {
      List<LeaveRecord> records = new ArrayList<>();
      for (int i = 1; i <= 1000; i++) {
        LeaveRecord record = new LeaveRecord(
            null,
            "사원" + i,
            i % 2 == 0 ? "연차" : "병가",
            LocalDate.now().minusDays(i % 30),
            (i % 8 + 1) * 0.5, // 0.5 ~ 4.5시간
            "자동생성 데이터"
        );
        records.add(record);
      }
      leaveRecordRepository.saveAll(records);
      System.out.println("✅ 1000건 더미 데이터 삽입 완료");
    } else {
      System.out.println("✅ 이미 데이터가 존재합니다 (삽입 생략)");
    }

  }
}
