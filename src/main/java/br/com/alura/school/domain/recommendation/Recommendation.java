package br.com.alura.school.domain.recommendation;

import br.com.alura.school.domain.student.Student;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Recommendation {
    private Student indicator;
    private Student indicated;
    private LocalDateTime recommendationDate;

    public Recommendation(Student indicated, Student indicator){
        this.indicated = indicated;
        this.indicator = indicator;
        this.recommendationDate = LocalDateTime.now();
    }
}
