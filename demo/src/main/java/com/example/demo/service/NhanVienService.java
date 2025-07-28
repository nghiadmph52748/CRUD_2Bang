package com.example.demo.service;

import com.example.demo.entity.NhanVien;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public NhanVien getNhanVienById(Long id) {
        return nhanVienRepository.findById(id).orElseThrow(() -> new ApiException("NhanVien not found with id: " + id, "NHAN_VIEN_NOT_FOUND"));
    }
}
