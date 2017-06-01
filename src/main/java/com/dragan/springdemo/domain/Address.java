package com.dragan.springdemo.domain;

public class Address {
    private String address;
    private String city;
    private String zipCode;

    public Address() {
    }

    public Address(String city, String zipCode) {
	this.city = city;
	this.zipCode = zipCode;
    }

    public Address(String address, String city, String zipCode) {
	this.address = address;
	this.city = city;
	this.zipCode = zipCode;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getZipCode() {
	return zipCode;
    }

    public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
    }

    @Override
    public String toString() {
	return "Address [address=" + address + ", city=" + city + ", zipCode=" + zipCode + "]";
    }

}
