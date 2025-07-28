package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Size(max = 20)
    @Column(name = "Ma", length = 20)
    private String ma;

    @Size(max = 30)
    @Nationalized
    @ColumnDefault("NULL")
    @Column(name = "Ten", length = 30)
    private String ten;

    @Size(max = 30)
    @Nationalized
    @ColumnDefault("NULL")
    @Column(name = "TenDem", length = 30)
    private String tenDem;

    @Size(max = 30)
    @Nationalized
    @ColumnDefault("NULL")
    @Column(name = "Ho", length = 30)
    private String ho;

    @Size(max = 10)
    @Nationalized
    @ColumnDefault("NULL")
    @Column(name = "GioiTinh", length = 10)
    private String gioiTinh;

    @ColumnDefault("NULL")
    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Size(max = 100)
    @Nationalized
    @ColumnDefault("NULL")
    @Column(name = "DiaChi", length = 100)
    private String diaChi;

    @Size(max = 30)
    @ColumnDefault("NULL")
    @Column(name = "Sdt", length = 30)
    private String sdt;

    @ColumnDefault("NULL")
    @Lob
    @Column(name = "MatKhau")
    private String matKhau;

    @ColumnDefault("0")
    @Column(name = "TrangThai")
    private Integer trangThai;

    @JsonBackReference
    @OneToMany(mappedBy = "idNV")
    private Set<HoaDon> hoaDons = new LinkedHashSet<>();

}