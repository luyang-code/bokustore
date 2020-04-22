package com.tsc.graduateproj.bokubookstore.bokubookstore;

import com.tsc.graduateproj.bokubookstore.BokubookstoreApplication;
import com.tsc.graduateproj.bokubookstore.config.result.ErrorInfo;
import com.tsc.graduateproj.bokubookstore.domain.model.BookDO;
import com.tsc.graduateproj.bokubookstore.infrastructure.IAdminRepository;
import com.tsc.graduateproj.bokubookstore.infrastructure.IBookRepository;
import com.tsc.graduateproj.bokubookstore.infrastructure.IUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BokubookstoreApplication.class)
public class TestBoKuStore {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IAdminRepository adminRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Test
    public void testUser(){
        Integer count = adminRepository.queryNum();
    }

    @Test
    public void test1(){
        for (int i = 0; i < 10; i++) {
//            System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*9000+1000));
            System.out.println(System.currentTimeMillis() + ((int) (Math.random() * 9000 + 1000)) + "");
        }
    }

}
