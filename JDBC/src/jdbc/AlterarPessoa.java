package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarPessoa {

    public static void main(String[] args) throws SQLException {

        Connection conexao = FabricaConexao.getConexao();
        Scanner digite = new Scanner(System.in);

        System.out.print("Digite o Id que deseja alterar: ");
        int id = digite.nextInt();
        digite.nextLine();
        System.out.print("Digite o novo nome: ");
        String novoNome = digite.nextLine();

        String sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1,novoNome);
        stmt.setInt(2,id);
        stmt.execute();
        System.out.println("Alteração feita com sucesso");



        conexao.close();
        digite.close();
        stmt.close();
    }
}
