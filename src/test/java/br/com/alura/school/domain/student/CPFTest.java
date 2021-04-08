package br.com.alura.school.domain.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {
    @Test
    public void shouldNotCreateACPFWithAnInvalidNumber(){
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(null));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(""));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF("12345678910"));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF("123.456.789.10"));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF("123.456-789-10"));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF("123-456.789.10"));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF("123-456-789-10"));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF("123.456-789-100"));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF("123-456.789.1"));
    }

    @Test
    public void shouldCreateACPFWithAValidNumber(){
        assertDoesNotThrow(() -> new CPF("123.456.789-10"));
    }
}