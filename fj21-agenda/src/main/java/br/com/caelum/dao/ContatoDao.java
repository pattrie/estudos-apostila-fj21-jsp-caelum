package br.com.caelum.dao;

import br.com.caelum.factory.ConnectionFactory;
import br.com.caelum.modelo.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {
    private Connection connection;

    public ContatoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Contato contato) {
        String sql = "insert into contatos" +
                " (nome, email, endereco, dataNascimento)" +
                " values (?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(
                    contato.getDataNascimento().getTimeInMillis()));

            stmt.execute();
            stmt.close();

            System.out.println("Gravado!");
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public List<Contato> getLista() {
        try {
            List<Contato> contatoes = new ArrayList();
            PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
            return getContatoes(contatoes, stmt);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contato> getListaEnquantoNomeComecarCom(char letra) {
        try {
            List<Contato> contatoes = new ArrayList();
            PreparedStatement stmt = this.connection.prepareStatement(
                    "select * from contatos where nome like " + "'" + letra + "%'");
            return getContatoes(contatoes, stmt);

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    private List<Contato> getContatoes(List<Contato> contatoes, PreparedStatement stmt) throws SQLException {
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            Contato contato = new Contato();
            contato.setId(resultSet.getLong("id"));
            contato.setNome(resultSet.getString("nome"));
            contato.setEmail(resultSet.getString("email"));
            contato.setEndereco(resultSet.getString("endereco"));
            Calendar data = Calendar.getInstance();
            data.setTime(resultSet.getDate("dataNascimento"));
            contato.setDataNascimento(data);
            contatoes.add(contato);
        }

        resultSet.close();
        stmt.close();
        return contatoes;
    }

    public List<Contato> getContatoComID(int id) {
        try {
            List<Contato> contatoes = new ArrayList();
            PreparedStatement stmt = this.connection.prepareStatement(
                    "select * from contatos where id = " + "'" + id + "'");
            return getContatoes(contatoes, stmt);

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public void altera(Contato contato) {
        String sql = "update contatos set nome=?, email=?, " +
                "endereco=?, dataNascimento=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public void remove(Contato contato) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "delete from contatos where id=?");
            stmt.setLong(1, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
