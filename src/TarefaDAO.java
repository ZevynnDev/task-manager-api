import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TarefaDAO {

    Connection conectar() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/tasks";
        String user = System.getenv("DB_USER");
        String psswd = System.getenv("DB_PASSWORD");

        return DriverManager.getConnection(url, user, psswd);
    }

    void adicionarTarefa(Tarefa tarefa) throws SQLException {
        
        String sql = "INSERT INTO tarefas (nome, concluida) VALUES (?, ?)";

            try (Connection connection = conectar(); 
            
            PreparedStatement statement = connection.prepareStatement(sql)){
            
            statement.setString(1, tarefa.nome);
            statement.setBoolean(2, tarefa.concluida);

            statement.executeUpdate();
        }

    }
    void listarTarefa() throws SQLException {
        
        String grep = "SELECT * FROM tarefas";

        try (Connection connection = conectar(); 
        PreparedStatement statement = connection.prepareStatement(grep); 
        ResultSet resultado = statement.executeQuery()) {
            
            while (resultado.next()) {
                System.out.println("id: " + resultado.getInt("id"));
                System.out.println("Nome: " + resultado.getString("nome"));
                System.out.println("Concluída: " + resultado.getBoolean("concluida"));
            }
        }
    }
    
    void apagarTarefa(int id) throws SQLException {
        String del = "DELETE FROM tarefas WHERE id = ?";

        try (Connection connection = conectar(); PreparedStatement statement = connection.prepareStatement(del)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        
        }



        
    }
        



}