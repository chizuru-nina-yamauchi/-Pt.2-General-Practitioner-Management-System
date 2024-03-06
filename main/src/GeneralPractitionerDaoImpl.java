package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneralPractitionerDaoImpl implements GeneralPractitionerDao{

    /*
    * Get a connection to the database
    * Using prepared statement to execute the SQL query
    * Using try-catching to handle the exception for the connection to the database and sql query
    * Set the parameter index 1 as the generalPractitionerId
    * If there is a next row, create a new GeneralPractitioner object and set the attributes for the object
    * The cursor is moved to the next row
    * rs.next() returns false if there are no more rows in the ResultSet object
    * Return the GeneralPractitioner object
    * If there is no result, return null
    * */
    @Override
    public GeneralPractitioner getGeneralPractitionerById(int generalPractitionerId){
        try(
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement ps = connection.prepareStatement(SqlQuery.GET_GENERAL_PRACTITIONER_BY_ID.query)

                ){
            ps.setInt(1, generalPractitionerId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                GeneralPractitioner generalPractitioner = new GeneralPractitioner();
                generalPractitioner.setGeneral_practitioner_id(rs.getInt("general_practitioner_id"));
                generalPractitioner.setGeneral_practitioner_name(rs.getString("name"));
                generalPractitioner.setGeneral_practitioner_city(rs.getString("city"));
                generalPractitioner.setGeneral_practitioner_age(rs.getInt("age"));
                return generalPractitioner;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
    * Get a connection to the database
    * Using prepared statement to execute the SQL query
    * Using try-catching to handle the exception for the connection to the database and sql query
    * Set the parameter index 1 as the generalPractitionerName
    * Check if there is an executed result for the sql query
    * If there is a result, create a new GeneralPractitioner object and set the attributes for the object
    * Return the GeneralPractitioner object
    * If there is no result, return null
    * */
    @Override
    public GeneralPractitioner getGeneralPractitionerByName(String generalPractitionerName){
        try(
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement ps = connection.prepareStatement(SqlQuery.GET_GENERAL_PRACTITIONER_BY_NAME.query)
                ){
            ps.setString(1, generalPractitionerName);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                GeneralPractitioner generalPractitioner = new GeneralPractitioner();
                generalPractitioner.setGeneral_practitioner_id(rs.getInt("general_practitioner_id"));
                generalPractitioner.setGeneral_practitioner_name(rs.getString("name"));
                generalPractitioner.setGeneral_practitioner_city(rs.getString("city"));
                generalPractitioner.setGeneral_practitioner_age(rs.getInt("age"));
                return generalPractitioner;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<GeneralPractitioner> getAllGeneralPractitioners(){
        Set<GeneralPractitioner> generalPractitioners = new HashSet<>();
        try(
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement ps = connection.prepareStatement(SqlQuery.GET_ALL_GENERAL_PRACTITIONERS.query)
                ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GeneralPractitioner generalPractitioner = new GeneralPractitioner();
                generalPractitioner.setGeneral_practitioner_id(rs.getInt("general_practitioner_id"));
                generalPractitioner.setGeneral_practitioner_name(rs.getString("name"));
                generalPractitioner.setGeneral_practitioner_city(rs.getString("city"));
                generalPractitioner.setGeneral_practitioner_age(rs.getInt("age"));
                generalPractitioners.add(generalPractitioner);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GeneralPractitioner addGeneralPractitioner(GeneralPractitioner generalPractitioner){
        try(
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement ps = connection.prepareStatement(SqlQuery.INSERT_GENERAL_PRACTITIONER.query)
                ){
            ps.setString(1, generalPractitioner.getGeneral_practitioner_name());
            ps.setInt(2, generalPractitioner.getGeneral_practitioner_age());
            ps.setString(3, generalPractitioner.getGeneral_practitioner_city());

            // Execute updating the database with the specified sql query
            int i = ps.executeUpdate();
            if(i == 1){
                // Single row inserted successfully
                return generalPractitioner;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        // If the generalPractitioner is not added successfully, return null
        return null;
    }

    @Override
    public boolean updateGeneralPractitioner(GeneralPractitioner generalPractitioner){
        try(
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement ps = connection.prepareStatement(SqlQuery.UPDATE_GENERAL_PRACTITIONER.query)
                ){
            ps.setString(1, generalPractitioner.getGeneral_practitioner_name());
            ps.setInt(2, generalPractitioner.getGeneral_practitioner_age());
            ps.setString(3, generalPractitioner.getGeneral_practitioner_city());
            // Update the generalPractitioner with the specified generalPractitionerId
            // with the new attributes by using the prepared statement that is connected to the sql query
            int i = ps.executeUpdate();
            if(i == 1){
                // Single row updated successfully
                return true;
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        // If the generalPractitioner is not updated successfully, return false
        return false;
    }

    @Override
    public boolean deleteGeneralPractitioner(int generalPractitionerId){
        try(
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement ps = connection.prepareStatement(SqlQuery.DELETE_GENERAL_PRACTITIONER.query)

                ){
            ps.setInt(1, generalPractitionerId);
            // Delete the generalPractitioner with the specified generalPractitionerId
            // by using the prepared statement that is connected to the sql query
            int i = ps.executeUpdate();
            if(i == 1){
                // Single row deleted successfully
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        // If the generalPractitioner is not deleted successfully, return false
        return false;
    }

    @Override
    public List<GeneralPractitioner> getGeneralPractitionerWithPatientOlderThanAge(int age){
        List<GeneralPractitioner> generalPractitioners = new ArrayList<>();
        try(
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement ps = connection.prepareStatement(SqlQuery.GET_GENERAL_PRACTITIONERS_WITH_PATIENT_OLDER_THAN_AGE.query)
                ) {
            ps.setInt(1, age);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                generalPractitioners.add((new GeneralPractitioner(rs.getInt("general_practitioner_id"), rs.getString("name"), rs.getInt("age"), rs.getString("city"))));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        // return the list of generalPractitioners and if there are no general practitioners, return to the empty list
        return generalPractitioners;
    }

    @Override
    public List<GeneralPractitioner> getGeneralPractitionerWithPatientSpecifiedCondition(String condition){
        List<GeneralPractitioner> generalPractitioners = new ArrayList<>();
        try(
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement ps = connection.prepareStatement(SqlQuery.GET_GENERAL_PRACTITIONER_WITH_PATIENTS_SPECIFIED_CONDITIONS.query)
                ){
            ps.setString(1, condition);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                generalPractitioners.add((new GeneralPractitioner(rs.getInt("general_practitioner_id"), rs.getString("name"), rs.getInt("age"), rs.getString("city")));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        // return the list of generalPractitioners and if there are no general practitioners, return to the empty list
        return generalPractitioners;
    }

    @Override
    public List<GeneralPractitioner> getGeneralPractitionerWithMorePatientsThanAverage(){



        return null;
    }

}
