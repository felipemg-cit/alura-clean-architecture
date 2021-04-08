package br.com.alura.school.infrastructure.student;

import br.com.alura.school.domain.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsRepositoryWithJDBC implements StudentsRepository {

    private final Connection connection;

    public StudentsRepositoryWithJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void enroll(Student student){
        try{
            String sql = "INSERT INTO STUDENT VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getCpf());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.execute();

            sql = "INSERT INTO PHONENUMBERS VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            for (PhoneNumber phoneNumber: student.getPhoneNumbers()) {
                preparedStatement.setString(1, phoneNumber.getDdd());
                preparedStatement.setString(2, phoneNumber.getNumber());
                preparedStatement.execute();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findByCPF(CPF cpf){
        try {
            String sql = "SELECT id, nome, email FROM Student WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumber());

            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();
            if (!encontrou) {
                throw new StudentNotFound(cpf);
            }

            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Student encontrado = new Student(cpf, nome, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE Student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                encontrado.setPhoneNumber(ddd, numero);
            }

            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getAllEnrolledStudents(){
        try {
            String sql = "SELECT id, cpf, nome, email FROM Student";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Student> Students = new ArrayList<>();
            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String nome = rs.getString("nome");
                Email email = new Email(rs.getString("email"));
                Student Student = new Student(cpf, nome, email);

                Long id = rs.getLong("id");
                sql = "SELECT ddd, numero FROM TELEFONE WHERE Student_id = ?";
                PreparedStatement psTelefone = connection.prepareStatement(sql);
                psTelefone.setLong(1, id);
                ResultSet rsTelefone = psTelefone.executeQuery();
                while (rsTelefone.next()) {
                    String numero = rsTelefone.getString("numero");
                    String ddd = rsTelefone.getString("ddd");
                    Student.setPhoneNumber(ddd, numero);
                }

                Students.add(Student);
            }

            return Students;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
