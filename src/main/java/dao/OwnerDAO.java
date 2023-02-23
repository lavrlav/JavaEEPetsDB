package dao;

import entity.Owner;
import util.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO extends DataAccessObject<Owner, Integer> {
    public static final String SQL_SELECT_ALL_OWNERS = "SELECT * FROM owners";
    public static final String SQL_SELECT_OWNERS_ID = "SELECT * FROM owners WHERE id = ?";
    public static final String SQL_INSERT_INTO_OWNERS = "INSERT INTO petsdb.owners (name) VALUES (?)";
    public static final String SQL_UPDATE_INTO_OWNERS = "UPDATE petsdb.owners SET name = ? WHERE id = ?";
    public static final String SQL_DELETE_OWNERS_ID = "DELETE FROM owners  WHERE id = ?";

    @Override
    public List<Owner> selectAll() {
        List<Owner> owners = new ArrayList<>();
        try (Statement stmt = ConnectionDB.getConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL_SELECT_ALL_OWNERS);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                owners.add(Owner.builder().id(id).name(name).build());
                System.out.printf("%s %s \n", id, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return owners;
    }

    @Override
    public Owner selectOne(Integer id) {
        Owner owner = null;
        try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(SQL_SELECT_OWNERS_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ownerId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                owner = Owner.builder().id(ownerId).name(name).build();
                System.out.printf("%s %s \n", ownerId, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return owner;
    }

    @Override
    public boolean create(Owner owner) {
        try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(SQL_INSERT_INTO_OWNERS)) {
            preparedStatement.setString(1, owner.getName());

            int row = preparedStatement.executeUpdate();
            System.out.printf("%d row added", row);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public Owner update(Owner owner, Integer id) {
        try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(SQL_UPDATE_INTO_OWNERS)) {
            preparedStatement.setString(1, owner.getName());
            preparedStatement.setInt(2, owner.getId());

            int row = preparedStatement.executeUpdate();
            System.out.printf("%d row updated", row);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return owner;
    }


    @Override
    public boolean delete(Integer id) {
        try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(SQL_DELETE_OWNERS_ID)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            System.out.printf("%d row deleted", row);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
