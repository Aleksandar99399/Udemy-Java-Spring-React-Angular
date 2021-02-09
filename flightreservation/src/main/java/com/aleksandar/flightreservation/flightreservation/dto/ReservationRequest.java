package com.aleksandar.flightreservation.flightreservation.dto;

public class ReservationRequest {

    private Long flightId;
    private String passengerFirstName;
    private String passengerLastName;
    private String passengerEmail;
    private String passengerPhone;
    private String nameOnTheCard;
    private String cardNumber;
    private String expirationDate;
    private String securityCode;

    public Long getFlightId() {
        return flightId;
    }

    public ReservationRequest setFlightId(Long flightId) {
        this.flightId = flightId;
        return this;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public ReservationRequest setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
        return this;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public ReservationRequest setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
        return this;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public ReservationRequest setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
        return this;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public ReservationRequest setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
        return this;
    }

    public String getNameOnTheCard() {
        return nameOnTheCard;
    }

    public ReservationRequest setNameOnTheCard(String nameOnTheCard) {
        this.nameOnTheCard = nameOnTheCard;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public ReservationRequest setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public ReservationRequest setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public ReservationRequest setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
        return this;
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "flightId=" + flightId +
                ", passengerFirstName='" + passengerFirstName + '\'' +
                ", passengerLastName='" + passengerLastName + '\'' +
                ", passengerEmail='" + passengerEmail + '\'' +
                ", passengerPhone='" + passengerPhone + '\'' +
                ", nameOnTheCard='" + nameOnTheCard + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }
}
