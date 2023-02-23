package dao;

import entity.Pet;
import util.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetDAO extends DataAccessObject<Pet, Integer>{
    public static final String SQL_SELECT_ALL_PETS = "SELECT * FROM pets";
    public static final String SQL_SELECT_PETS_ID = "SELECT * FROM pets WHERE id = ?";
    public static final String SQL_INSERT_INTO_PETS = "INSERT INTO petsdb.pets (animal, name, age, color, owner_id) VALUES (?, ?, ?, ?, ?)";
    public static final String SQL_UPDATE_INTO_PETS = "UPDATE petsdb.pets SET animal = ?, name = ?, age = ?, color = ?, owner_id = ? WHERE id = ?";
    public static final String SQL_DELETE_PETS_ID = "DELETE FROM pets WHERE id = ?";
    @Override
    public List<Pet> selectAll() {
        List<Pet> pets = new ArrayList<>();

        try (Statement stmt = ConnectionDB.getConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL_SELECT_ALL_PETS);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String animal = resultSet.getString(2);
                String name = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String color = resultSet.getString(5);
                int ownerId = resultSet.getInt(6);

                Pet pet = Pet.builder()
                        .id(id)
                        .animal(animal)
                        .name(name)
                        .age(age)
                        .color(color)
                        .ownerId(ownerId)
                        .build();

                pets.add(pet);
                System.out.printf("%s %s %s %s %s %s \n", id, animal, name, age, color, ownerId);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pets;
    }

    @Override
    public Pet selectOne(Integer id) {
        Pet pet = null;
            try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(SQL_SELECT_PETS_ID)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int animalId = resultSet.getInt(1);
                    String animal = resultSet.getString(2);
                    String name = resultSet.getString(3);
                    int age = resultSet.getInt(4);
                    String color = resultSet.getString(5);
                    int ownerId = resultSet.getInt(6);
                    pet = Pet.builder()
                            .id(animalId)
                            .animal(animal)
                            .name(name)
                            .age(age)
                            .color(color)
                            .ownerId(ownerId)
                            .build();
                    System.out.printf("%s %s %s %s %s %s \n", id, animal, name, age, color, ownerId);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return pet;
    }

    @Override
    public boolean create(Pet pet) {

        try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(SQL_INSERT_INTO_PETS)) {
            preparedStatement.setString(1, pet.getAnimal());
            preparedStatement.setString(2, pet.getName());
            preparedStatement.setInt(3, pet.getAge());
            preparedStatement.setString(4, pet.getColor());
            preparedStatement.setInt(5, pet.getOwnerId());
            int row = preparedStatement.executeUpdate();
            System.out.printf("%d row added", row);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Pet update(Pet pet, Integer id) {

            try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(SQL_UPDATE_INTO_PETS)) {

                preparedStatement.setString(1, pet.getAnimal());
                preparedStatement.setString(2, pet.getName());
                preparedStatement.setInt(3, pet.getAge());
                preparedStatement.setString(4, pet.getColor());
                preparedStatement.setInt(5, pet.getOwnerId());
                preparedStatement.setInt(6, id);


                int row = preparedStatement.executeUpdate();
                System.out.printf("%d row updated", row);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        return pet;
    }

    @Override
    public boolean delete(Integer id) {
            try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(SQL_DELETE_PETS_ID)) {
                preparedStatement.setInt(1, id);
                int row = preparedStatement.executeUpdate();
                System.out.printf("%d row deleted", row);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        return true;
    }


}
