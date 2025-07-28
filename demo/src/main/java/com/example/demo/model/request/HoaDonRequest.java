package com.example.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonRequest {
    String ma;
    LocalDate ngayTao;
    LocalDate ngayThanhToan;
    LocalDate ngayShip;
    LocalDate ngayNhan;
    Long idNV;
}
