import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySQL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Bancodedados"; // nome do banco de dados
        String usuario = "root"; // seu usuário do MySQL
        String senha = "senac@2025"; // sua senha do MySQL

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão efetuada!");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    static Connection conectar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

