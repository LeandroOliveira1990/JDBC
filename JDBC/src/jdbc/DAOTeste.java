package jdbc;

public class DAOTeste {
    public static void main(String[] args) {
    DAO dao = new DAO();

    String sql = "INSERT INTO pessoas (nome) VALUES (?)";
    dao.incluir(sql, "Jubileu Creuza");
    dao.incluir(sql, "João Silva");
    dao.incluir(sql, "Ana Julia");
    dao.incluir(sql, "Djalma Pereira");
        System.out.println(dao.incluir(sql,"Lohaine Mclaren"));

        dao.close();


    }
}
