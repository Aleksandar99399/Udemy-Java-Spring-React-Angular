package com.aleksandar.location.util;

import org.springframework.stereotype.Component;

public interface EmailUtil {

    void sendEmail(String toAddress,String subject, String body);
}
