package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarPessoa2 {
    public static void main(String[] args) throws SQLException {
        Scanner digite = new Scanner(System.in);
        Connection conexao = FabricaConexao.getConexao();

        System.out.print("Informe o código da pessoa: ");
        int codigo = digite.nextInt();

        String sql = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1,codigo);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            Pessoa pessoa = new Pessoa(resultado.getInt(1), resultado.getString(2));

            System.out.println("Nome atual: " + pessoa.getNome());

            System.out.print("Digite o novo nome: ");
            digite.nextLine();
            String novoNome = digite.nextLine();
            String sql2 = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
            stmt.close();
            stmt = conexao.prepareStatement(sql2);
            stmt.setString(1,novoNome);
            stmt.setInt(2,codigo);
            stmt.execute();
            System.out.println("Alteração feita com sucesso!");

        } else {
            System.out.println("Código Não encontrado");
        }



        conexao.close();
        digite.close();
        stmt.close();
    }
}
