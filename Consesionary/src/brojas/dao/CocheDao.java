package brojas.dao;

import brojas.model.Coche;
import brojas.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocheDao {
    private Connection connection;

    public CocheDao(){
        connection = ConectorBD.getConnection();
    }
    //crear
    public void addCoche (Coche coche){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO coches (matricula, marca, modelo, color, precio) VALUES (?, ?, ?, ?, ?)"
            );
            preparedStatement.setString(1,coche.getMatricula());
            preparedStatement.setString(2,coche.getMarca());
            preparedStatement.setString(3,coche.getModelo());
            preparedStatement.setString(4,coche.getColor());
            preparedStatement.setDouble(5,coche.getPrecio());
            preparedStatement.executeUpdate();

            System.out.println(coche + " creado");
        }catch (SQLException e){
            System.out.println("Error al crear el coche: " + e.getMessage());}
    }
    //actualizar
    public void updteCoche(Coche coche){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE coches SET matricula=?, marca=?, modelo=?, color=?, precio=? WHERE matricula=?"
            );
            preparedStatement.setString(1,coche.getMatricula());
            preparedStatement.setString(2,coche.getMarca());
            preparedStatement.setString(3,coche.getModelo());
            preparedStatement.setString(4,coche.getColor());
            preparedStatement.setDouble(5,coche.getPrecio());

            preparedStatement.setString(6,coche.getMatricula());
            preparedStatement.executeUpdate();

            System.out.println(coche + " editado");
        }catch (SQLException e){
            System.out.println("Error al editar el coche: " + e.getMessage());}
    }
    //eliminar
    public void deleteCoche(String matricula){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM coches WHERE matricula=?"
            );
            preparedStatement.setString(1, matricula);
            preparedStatement.executeUpdate();

            System.out.println(matricula + " eliminado");
        }catch (SQLException e){
            System.out.println("Error al eliminar el coche: " + e.getMessage());}
    }
    //lista
    public List<Coche> getAllCoche(){
        List<Coche> coches = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes");
            while (resultSet.next()){
                Coche coche = new Coche();
                coche.setMatricula(resultSet.getString("matricula: "));
                coche.setMarca(resultSet.getString("marca: "));
                coche.setModelo(resultSet.getString("modelo: "));
                coche.setColor(resultSet.getString("color: "));
                coche.setPrecio(resultSet.getInt("precio: "));

                coches.add(coche);
            }
        }catch (SQLException e){
            System.out.println("Error al listar los cohes " + e.getMessage()); }

        return coches;
    }
}
