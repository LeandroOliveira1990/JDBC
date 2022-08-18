package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexacao {
    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&usaSSL=true";
        final String usuario = "root";
        final String senha = "091990";

        Connection conexao = DriverManager.getConnection(url,usuario,senha);

        System.out.println("Conexão efetuada com sucesso!");

        conexao.close();
    }
}
