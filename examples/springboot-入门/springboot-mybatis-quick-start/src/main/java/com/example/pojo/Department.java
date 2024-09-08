package com.example.pojo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
  private short id;
  private String name;
  private LocalDateTime createdTime;
  private LocalDateTime alteredTime;
}
