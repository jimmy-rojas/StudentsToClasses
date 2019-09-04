package com.organization.students_to_classes.controller.model;

public class CustomErrorResponse {

    private String message;
    private String messageDetails;

    public CustomErrorResponse(String message, String messageDetails) {
        this.message = message;
        this.messageDetails = messageDetails;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageDetails() {
        return messageDetails;
    }
}
