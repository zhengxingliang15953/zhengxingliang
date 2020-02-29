package com.example.demo.service;

import com.example.demo.entity.TbAppointment;

public interface TbAppointmentService {
    TbAppointment insertAppointment(String appId, String bookName, String isbn, String studentName, String sno,String appTime);
}
