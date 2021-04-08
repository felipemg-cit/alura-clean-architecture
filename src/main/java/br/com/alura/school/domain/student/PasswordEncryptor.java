package br.com.alura.school.domain.student;

public interface PasswordEncryptor {
    String encryptPassword(String password);
    boolean isEncryptedPassword(String encryptedPassword, String password);
}
