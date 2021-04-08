package br.com.alura.school.domain.student;

import lombok.Getter;

//Value object
@Getter
public class Email {
    private String address;

    public Email(String address){
        if(address == null || !(address.matches("^[a-zA-z0-9._-]+@[a-zA-Z]+\\.[a-zA-Z.]{2,12}$"))){
            throw new IllegalArgumentException("Invalid E-mail");
        }
        this.address = address;
    }
}
