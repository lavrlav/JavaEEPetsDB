package pets;

import connection.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;

public class PetDB {
    private static String url = "jdbc:mysql://localhost:3306/petsdb";
    private static String username = "root";
    private static String password = "root";

    public static ArrayList<Pet> select() {

        ArrayList<Pet> pets = new ArrayList<>();
        try {
            ConnectionDB.getConnection();
            Statement statement = ConnectionDB.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pets");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String animal = resultSet.getString(2);
                String name = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String color = resultSet.getString(5);
                int ownerId = resultSet.getInt(6);
                Pet pet = new Pet(id, animal, name, age, color, ownerId);
                pets.add(pet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pets;
    }

    public static Pet selectOne(int id) {

        Pet pet = null;
        try {
            String sql = "SELECT * FROM pets WHERE id=?";
            try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int animalId = resultSet.getInt(1);
                    String animal = resultSet.getString(2);
                    String name = resultSet.getString(3);
                    int age = resultSet.getInt(4);
                    String color = resultSet.getString(5);
                    int ownerId = resultSet.getInt(6);
                    pet = new Pet(animalId, animal, name, age, color, ownerId);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return pet;
    }

    public static int insert(Pet pet) {

        try {
            String sql = "INSERT INTO pets (animal, name, age, color, owner_id) Values (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, pet.getAnimal());
                preparedStatement.setString(2, pet.getName());
                preparedStatement.setInt(3, pet.getAge());
                preparedStatement.setString(4, pet.getColor());
                preparedStatement.setInt(5, pet.getOwnerId());

                return preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static int update(Pet pet) throws SQLException {

        try {
            String sql = "UPDATE pets SET animal = ?, name = ?, age = ?, color = ?, owner_id = ?  WHERE id = ?";
            try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, pet.getAnimal());
                preparedStatement.setString(2, pet.getName());
                preparedStatement.setInt(3, pet.getAge());
                preparedStatement.setString(4, pet.getColor());
                preparedStatement.setInt(5, pet.getOwnerId());

                return preparedStatement.executeUpdate();
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static int delete(int id) {

        try {
            String sql = "DELETE FROM pets WHERE id = ?";
            try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                return preparedStatement.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }
}
