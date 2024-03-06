package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PatientDaoImpl implements PatientDao{

    // the documentation for CRUD operations is more detailed in the GeneralPractitionerDaoImpl.java file

    /*
     * Get a connection to the database
     * Using prepared statement to execute the SQL query
     * Using try-catching to handle the exception for the connection to the database and sql query
     * Set the parameter index 1 as the patientId
     * If there is a next row, create a new patient object and set the attributes for the object by getting the data from sql query
     * The cursor is moved to the next row
     * rs.next() returns false if there are no more rows in the ResultSet object
     * Return the Patient object
     * If there is no result, return null
     * */


    @Override
    public Patient getPatientById(int patientId) {
        try(
            Connection connection = ConnectionFactory.createConnection();
            PreparedStatement ps = connection.prepareStatement(SqlQuery.GET_PATIENT_BY_ID.query);
                ){
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Patient patient = new Patient();
                patient.setPatient_id(rs.getInt("patient_id"));
                patient.setPatient_name(rs.getString("name"));
                patient.setPatient_age(rs.getInt("age"));
                patient.setPatient_city(rs.getString("city"));
                patient.setPatient_condition(rs.getString("condition"));
                patient.setGeneral_practitioner_id(rs.getInt("general_practitioner_id"));
                return patient;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Patient getPatientByName(String patientName) {
        try(
            Connection connection = ConnectionFactory.createConnection();
            PreparedStatement ps = connection.prepareStatement(SqlQuery.GET_PATIENT_BY_NAME.query);
                ){
            ps.setString(1, patientName);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Patient patient = new Patient();
                patient.setPatient_id(rs.getInt("patient_id"));
                patient.setPatient_name(rs.getString("name"));
                patient.setPatient_age(rs.getInt("age"));
                patient.setPatient_city(rs.getString("city"));
                patient.setPatient_condition(rs.getString("condition"));
                patient.setGeneral_practitioner_id(rs.getInt("general_practitioner_id"));
                return patient;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Patient> getAllPatients() {
        Set<Patient> patients = new HashSet<>();
        try(
            Connection connection = ConnectionFactory.createConnection();
            PreparedStatement ps = connection.prepareStatement(SqlQuery.GET_ALL_PATIENTS.query);
                ){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Patient patient = new Patient();
                patient.setPatient_id(rs.getInt("patient_id"));
                patient.setPatient_name(rs.getString("name"));
                patient.setPatient_age(rs.getInt("age"));
                patient.setPatient_city(rs.getString("city"));
                patient.setPatient_condition(rs.getString("condition"));
                patient.setGeneral_practitioner_id(rs.getInt("general_practitioner_id"));
                patients.add(patient);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public Patient addPatient(Patient patient) {
        try(
            Connection connection = ConnectionFactory.createConnection();
            PreparedStatement ps = connection.prepareStatement(SqlQuery.INSERT_PATIENT.query);
                ){
            ps.setString(1, patient.getPatient_name());
            ps.setInt(2, patient.getPatient_age());
            ps.setString(3, patient.getPatient_city());
            ps.setString(4, patient.getPatient_condition());
            ps.setInt(5, patient.getGeneral_practitioner_id());
            int i = ps.executeUpdate();
            if(i == 1){
                return patient;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePatient(Patient patient) {
        try(
            Connection connection = ConnectionFactory.createConnection();
            PreparedStatement ps = connection.prepareStatement(SqlQuery.UPDATE_PATIENT.query);
                ){
            ps.setString(1, patient.getPatient_name());
            ps.setInt(2, patient.getPatient_age());
            ps.setString(3, patient.getPatient_city());
            ps.setString(4, patient.getPatient_condition());
            ps.setInt(5, patient.getGeneral_practitioner_id());
            int i = ps.executeUpdate();
            if(i == 1){
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePatient(int patientId) {
        try(
            Connection connection = ConnectionFactory.createConnection();
            PreparedStatement ps = connection.prepareStatement(SqlQuery.DELETE_PATIENT.query);
                ){
            ps.setInt(1, patientId);
            int i = ps.executeUpdate();
            if(i == 1){
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Patient> getPatientsWithoutGeneralPractitionerInPatientCity() {
        List<Patient> patients = new ArrayList<>();
        try(
            Connection connection = ConnectionFactory.createConnection();
            PreparedStatement ps = connection.prepareStatement(SqlQuery.GET_PATIENTS_WITHOUT_GENERAL_PRACTITIONER_IN_PATIENT_CITY.query);
                ){

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Patient patient = new Patient();
                patient.setPatient_id(rs.getInt("patient_id"));
                patient.setPatient_name(rs.getString("name"));
                patient.setPatient_age(rs.getInt("age"));
                patient.setPatient_city(rs.getString("city"));
                patient.setPatient_condition(rs.getString("condition"));
                patient.setGeneral_practitioner_id(rs.getInt("general_practitioner_id"));
                patients.add(patient);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public List<Patient> getPatientWithGeneralPractitionerWithHighestNumberOfPatients() {
        List<Patient> patients = new ArrayList<>();
        try(
            Connection connection = ConnectionFactory.createConnection();
            PreparedStatement ps = connection.prepareStatement(SqlQuery.GET_PATIENT_WITH_GENERAL_PRACTITIONER_WITH_HIGHEST_NUMBER_OF_PATIENTS.query);
                ){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Patient patient = new Patient();
                patient.setPatient_id(rs.getInt("patient_id"));
                patient.setPatient_name(rs.getString("name"));
                patient.setPatient_age(rs.getInt("age"));
                patient.setPatient_city(rs.getString("city"));
                patient.setPatient_condition(rs.getString("condition"));
                patient.setGeneral_practitioner_id(rs.getInt("general_practitioner_id"));
                patients.add(patient);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return patients;
    }



}
