// author @1008005
 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
public class maiessequeele{
 
    // CREATE - Inserir
    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";
        try (Connection conn = ConnMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso!");
 
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }
 
    // READ - Listar
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
 
        try (Connection conn = ConnMySQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
 
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                usuarios.add(u);
            }
 
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
 
        return usuarios;
    }
 
    // UPDATE - Atualizar
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET login = ?, senha = ? WHERE id = ?";
 
        try (Connection conn = ConnMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, usuario.getId());
            stmt.executeUpdate();
            System.out.println("Usuário atualizado com sucesso!");
 
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }
 
    // DELETE - Deletar
    public void deletar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
 
        try (Connection conn = ConnMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuário removido com sucesso!");
 
        } catch (SQLException e) {
            System.out.println("Erro : " + e.getMessage());
        }
    }
}