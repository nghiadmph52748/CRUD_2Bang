package com.example.demo.controller;

import com.example.demo.model.response.ResponseObject;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nhan-vien-management")
@CrossOrigin(origins = "*")
public class NhanVienController{
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/playlist")
    public ResponseObject<?> get() {
        return new ResponseObject<>(nhanVienService.getAllNhanVien());
    }
}
