package br.com.alura.school.application.recommendation;

import br.com.alura.school.domain.student.Student;

public interface SendRecommendationEmail {
    void sendTo(Student indicated);
}
