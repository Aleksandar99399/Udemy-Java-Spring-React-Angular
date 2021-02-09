package com.aleksandar.flightreservation.flightreservation.util;

import com.aleksandar.flightreservation.flightreservation.service.impl.ReservationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {

    @Value("${com.aleksandar.flightreservation.itinerary.email.body}")
    public String EMAIL_BODY;
    @Value("${com.aleksandar.flightreservation.itinerary.email.subject}")
    public String EMAIL_SUBJECT;
    @Autowired
    private JavaMailSender sender;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    public void sendItinerary(String toAddress,String filepath){

        LOGGER.info("Inside sendItinerary()");
        MimeMessage message = sender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject(EMAIL_SUBJECT);
            messageHelper.setText(EMAIL_BODY);
            messageHelper.addAttachment("Itinerary",new File(filepath));

            sender.send(message);

        } catch (MessagingException e) {
            LOGGER.error("Exception inside sendItinerary()"+e);
        }
    }
}
