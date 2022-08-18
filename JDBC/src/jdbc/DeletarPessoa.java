package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarPessoa {

    public static void main(String[] args) throws SQLException {
        Scanner digite = new Scanner(System.in);

        Connection conexao = FabricaConexao.getConexao();
        System.out.print("Informe o código da pessoa que vai ser deletado: ");
        int deleteId = digite.nextInt();

        String sql = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1,deleteId);
        ResultSet resultado = stmt.executeQuery();


        if (resultado.next()){
            Pessoa pessoa = new Pessoa(resultado.getInt(1), resultado.getNString(2));
            System.out.println("Certeza que quer deletar?: " + pessoa.getNome());
            System.out.print("sim / não: ");
            digite.nextLine();
            String decisao = digite.nextLine();
            if (decisao.equals("sim")){
                stmt.close();
                sql = "DELETE FROM pessoas WHERE codigo = ?";
                stmt = conexao.prepareStatement(sql);
                stmt.setInt(1,deleteId);
                stmt.execute();
                System.out.println("DELETE CONCLUIDO!");

            } else {
                System.out.println("Operação cancelada");
            }


        } else {
            System.out.println("Código não encontrado.");
        }

        conexao.close();
        stmt.close();
        digite.close();
    }
}
