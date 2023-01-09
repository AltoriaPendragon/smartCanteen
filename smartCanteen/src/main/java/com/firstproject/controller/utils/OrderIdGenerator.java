package com.firstproject.controller.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderIdGenerator {
    public static String getOrderNumber(){
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String localDate = LocalDateTime.now().format(ofPattern);
        String randomNumeric = RandomStringUtils.randomNumeric(8);
        return localDate + randomNumeric;
    }
}
