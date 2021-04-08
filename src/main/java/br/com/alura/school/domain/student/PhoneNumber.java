package br.com.alura.school.domain.student;

import lombok.Getter;

@Getter
public class PhoneNumber {
    private String ddd;
    private String number;
    public PhoneNumber(String ddd, String number){
        if(ddd == null || number == null ||
                !(ddd.matches("^[0-9]{2}$")) || !(number.matches("^[0-9]{8,9}$"))){
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.ddd = ddd;
        this.number = number;
    }
}
