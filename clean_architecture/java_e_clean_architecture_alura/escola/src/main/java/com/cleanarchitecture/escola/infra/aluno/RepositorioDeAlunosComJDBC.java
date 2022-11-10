package com.cleanarchitecture.escola.infra.aluno;

import com.cleanarchitecture.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "insert into aluno values (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());

            ps.execute();

            sql = "insert into telefone values (?,?)";
            ps = connection.prepareStatement(sql);

            for (Telefone t : aluno.getTelefones()) {
                ps.setString(1, t.getDdd());
                ps.setString(2, t.getNumero());

                ps.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        try {
            String sql = "select id, nome, email from aluno where cpf = ?";
            PreparedStatement ps = null;
            ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());

            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();
            if (!encontrou) {
                throw new Exception("Aluno não encontrado");
            }

            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Long id = rs.getLong("id");

            Aluno encontrado = new Aluno(cpf, nome, email);

            sql = "select ddd, numero from telefone where aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");

                encontrado.adicionarTelefone(ddd, numero);
            }

            return encontrado;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return null;
    }
}
