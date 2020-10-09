package com.BfDmichal.tradingplatform.domain;

public class Mail {
    private String mailTo;
    private String subject;
    private String massage;

    public Mail(String mailTo, String subject, String massage) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.massage = massage;
    }

    public String getMailTo() {
        return mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getMassage() {
        return massage;
    }
}
