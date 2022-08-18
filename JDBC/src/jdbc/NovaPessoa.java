package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
    public static void main(String[] args) throws SQLException {

        Scanner digite = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        String nome = digite.nextLine();

        String sql = "INSERT INTO pessoas (nome) VALUES (?)" ;

        Connection conexao = FabricaConexao.getConexao();

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.executeUpdate();
        System.out.println("Pessoa incluida com sucesso");



        digite.close();

    }

}
