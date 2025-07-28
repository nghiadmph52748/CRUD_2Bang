package com.example.demo.model.response;

import com.example.demo.entity.HoaDon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonResponse {
    Long id;
    String ma;
    LocalDate ngayTao;
    LocalDate ngayThanhToan;
    LocalDate ngayShip;
    LocalDate ngayNhan;
    Long idNV;
    String maNhanVien;
    String tenNhanVien;

    public HoaDonResponse(HoaDon data) {
        this.id = data.getId();
        this.ma = data.getMa();
        this.ngayTao = data.getNgayTao();
        this.ngayThanhToan = data.getNgayThanhToan();
        this.ngayShip = data.getNgayShip();
        this.ngayNhan = data.getNgayNhan();
        this.maNhanVien = data.getIdNV().getMa();
        this.tenNhanVien = data.getIdNV().getTen();
        this.idNV = data.getIdNV().getId();
    }
}
