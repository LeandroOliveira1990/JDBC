package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CosultarPessoas1 {

    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConexao();
        String sql = "SELECT * FROM pessoas";

        Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        List<Pessoa> pessoa = new ArrayList<>();
        while (resultado.next()){
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoa.add(new Pessoa(codigo, nome));

        }

        for (Pessoa p:pessoa) {
            System.out.println(p.getCodigo() + " --- " + p.getNome());

        }


        stmt.close();
        conexao.close();
    }
}
