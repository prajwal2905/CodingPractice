package com.company;

public class EDefangIpAddress {
    public void defaAddress() {

        String address = "1.1.1.1";
        String[] substring = address.split("\\.");
        System.out.println(substring.length);
        StringBuilder defangAddress = new StringBuilder();
        for (
                int i = 0; i < substring.length; i++) {
            defangAddress.append(substring[i]);
            if (i != substring.length - 1) {
                defangAddress.append("[.]");
            }
        }
        System.out.println(defangAddress.toString());
    }
}
