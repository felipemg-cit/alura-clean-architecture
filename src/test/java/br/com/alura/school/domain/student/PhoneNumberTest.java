package br.com.alura.school.domain.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    @Test
    public void shouldNotCreateAPhoneNumberWithAnInvalidDDD(){
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber(null, "12345678"));
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber(null, ""));
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("", ""));
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("1", "123456789"));
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("100", "1234567890"));
    }

    @Test
    public void shouldNotCreateAPhoneNumberWithAnInvalidNumber(){
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("01", null));
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("01", ""));
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("01", "1"));
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("01", "1234567890"));
    }

    @Test
    public void shouldCreateAPhoneNumberWithAValidDDDAndNumber(){
        String d= "01";
        String n= "123456789";
        assertDoesNotThrow(()-> new PhoneNumber("01", "123456789"));
        assertDoesNotThrow(()-> new PhoneNumber("01", "12345678"));
        PhoneNumber test = new PhoneNumber(d, n);
        assertEquals(d, test.getDdd());
        assertEquals(n, test.getNumber());
    }

}