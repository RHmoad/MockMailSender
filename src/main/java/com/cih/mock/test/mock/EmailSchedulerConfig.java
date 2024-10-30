package com.cih.mock.test.mock;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSchedulerConfig {

    private final EmailServiceImpl emailService;

    @Scheduled(cron = "0 0 9 ? * MON")
    public void sendScheduledMail() {
        // Assuming you have predefined email details
        EmailDetails details = new EmailDetails();
        details.setRecipient("recipient@example.com"); // Set recipient
        details.setSubject("Scheduled Email");
        details.setMsgBody("This is a scheduled email sent every Monday at 8 AM.");

        emailService.sendMailWithAttachment(details);  // Delegate to the email service
    }
}
