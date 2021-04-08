package br.com.alura.school.infrastructure.recommendation;

import br.com.alura.school.application.recommendation.SendRecommendationEmail;
import br.com.alura.school.domain.student.Student;

public class SendRecommendationEmailWithJavaMail implements SendRecommendationEmail {

    @Override
    public void sendTo(Student indicated) {
        //Sending mail with Java Mail Lib
    }
}
