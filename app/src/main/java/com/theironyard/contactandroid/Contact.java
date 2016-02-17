package com.theironyard.contactandroid;

/**
 * Created by MacLap on 2/17/16.
 */
public class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + ", " + phoneNumber;
    }
}
