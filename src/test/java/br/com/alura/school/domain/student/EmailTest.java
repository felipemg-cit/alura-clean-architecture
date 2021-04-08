package br.com.alura.school.domain.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    @Test
    public void shouldNotCreateAnEmailWithAnInvalidAddress(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));
        assertThrows(IllegalArgumentException.class,
                () -> new Email("felipematheus@123"));
        assertThrows(IllegalArgumentException.class,
                () -> new Email("felipematheusgmail.com"));
        assertThrows(IllegalArgumentException.class,
                () -> new Email("felipematheus@outlookcom"));
        assertThrows(IllegalArgumentException.class,
                () -> new Email("elipe5_-.mg@gmail.yahoo.com.braaaaaa"));
    }

    @Test
    public void shouldCreateAnEmailWithAValidAddress(){
        assertDoesNotThrow(() -> new Email("felipemg@gmail.com"));
        assertDoesNotThrow(() -> new Email("felipe.mg@gmail.com"));
        assertDoesNotThrow(() -> new Email("felipe-mg@gmail.com"));
        assertDoesNotThrow(() -> new Email("felipe-mg5@gmail.com"));
        assertDoesNotThrow(() -> new Email("felipe5_-.mg@gmail.com.br"));
        assertDoesNotThrow(() -> new Email("felipe5_-.mg@gmail.yahoo.com.br"));
    }
}