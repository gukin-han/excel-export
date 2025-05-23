package com.example.excelexport.leave;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;

@Entity
@Getter
public class LeaveRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String empName;
  private String leaveType;
  private LocalDate leaveDate;
  private Double duration;
  private String note;

  public LeaveRecord(Long id, String empName, String leaveType, LocalDate leaveDate, Double duration, String note) {
    this.id = id;
    this.empName = empName;
    this.leaveType = leaveType;
    this.leaveDate = leaveDate;
    this.duration = duration;
    this.note = note;
  }

  public LeaveRecord() {

  }
}
