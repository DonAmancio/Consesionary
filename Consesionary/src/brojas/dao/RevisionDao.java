package brojas.dao;

import brojas.model.Revision;
import brojas.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RevisionDao {
    private Connection connection;

    public RevisionDao(){
        connection = ConectorBD.getConnection();
    }
    //crear
    public void addRevision (Revision revision){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO revisiones (codigo, filtro, aceite, frenos) VALUES (?, ?, ?, ?, ?)"
            );
            preparedStatement.setString(1,revision.getCodigo());
            preparedStatement.setString(2,revision.getFiltro());
            preparedStatement.setString(3,revision.getAceite());
            preparedStatement.setString(4,revision.getFrenos());
            preparedStatement.executeUpdate();

            System.out.println(revision + " creado");
        }catch (SQLException e){
            System.out.println("Error al crear revision: " + e.getMessage());}
    }
    //actualizar
    public void updateRevision(Revision revision){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE revisiones SET codigo=?, filtro=?, aceite=?, frenos=?  WHERE codigo=?"
            );
            preparedStatement.setString(1,revision.getCodigo());
            preparedStatement.setString(2,revision.getFiltro());
            preparedStatement.setString(3,revision.getAceite());
            preparedStatement.setString(4,revision.getFrenos());

            preparedStatement.setString(6,revision.getCodigo());
            preparedStatement.executeUpdate();

            System.out.println(revision + " editado");
        }catch (SQLException e){
            System.out.println("Error al editar revision: " + e.getMessage());}
    }
    //eliminar
    public void deleteRevision(String codigo){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM revisiones WHERE codigo=?"
            );
            preparedStatement.setString(1, codigo);
            preparedStatement.executeUpdate();

            System.out.println(codigo + " eliminado");
        }catch (SQLException e){
            System.out.println("Error al eliminar revision: " + e.getMessage());}
    }
    //lista
    public List<Revision> getAllRevision(){
        List<Revision> revisions = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM revisions");
            while (resultSet.next()){
                Revision revision = new Revision();
                revision.setCodigo(resultSet.getString("codigo: "));
                revision.setFiltro(resultSet.getString("filtro: "));
                revision.setAceite(resultSet.getString("aceite: "));
                revision.setFrenos(resultSet.getString("frenos: "));

                revisions.add(revision);
            }
        }catch (SQLException e){
            System.out.println("Error al listar los clientes " + e.getMessage()); }

        return revisions;
    }
}
