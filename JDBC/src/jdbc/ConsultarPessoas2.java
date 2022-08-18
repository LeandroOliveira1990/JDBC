package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {
    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConexao();
        Scanner digite = new Scanner(System.in);
        System.out.print("Digite texto de Busca: ");
        String parametro = digite.nextLine();

        String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, "%" + parametro + "%");

        ResultSet resultado = stmt.executeQuery();

        List<Pessoa> pessoa = new ArrayList<>();


            while (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");
                pessoa.add(new Pessoa(codigo, nome));
            }

            for (Pessoa p : pessoa) {

                System.out.println(p.getCodigo() + " --- " + p.getNome());


            }




        digite.close();
        conexao.close();
        stmt.close();
    }
}
