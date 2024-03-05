package src;

import java.util.PriorityQueue;

public class Patient {
    //Attributes
    private int patient_id;
    private String patient_name;
    private int patient_age;
    private String patient_city;
    private String patient_condition;
    private int general_practitioner_id;

    // Constructor
    public Patient(int patient_id, String patient_name, int patient_age, String patient_city, String patient_condition, int general_practitioner_id) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_age = patient_age;
        this.patient_city = patient_city;
        this.patient_condition = patient_condition;
        this.general_practitioner_id = general_practitioner_id;
    }

    // Constructor without id
    public Patient(String patient_name, int patient_age, String patient_city, String patient_condition, int general_practitioner_id) {
        this.patient_name = patient_name;
        this.patient_age = patient_age;
        this.patient_city = patient_city;
        this.patient_condition = patient_condition;
        this.general_practitioner_id = general_practitioner_id;
    }

    // Default constructor
    public Patient() {
    }

    // Getters and Setters


    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public int getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }

    public String getPatient_city() {
        return patient_city;
    }

    public void setPatient_city(String patient_city) {
        this.patient_city = patient_city;
    }

    public String getPatient_condition() {
        return patient_condition;
    }

    public void setPatient_condition(String patient_condition) {
        this.patient_condition = patient_condition;
    }

    public int getGeneral_practitioner_id() {
        return general_practitioner_id;
    }

    public void setGeneral_practitioner_id(int general_practitioner_id) {
        this.general_practitioner_id = general_practitioner_id;
    }

    // toString method

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", patient_name='" + patient_name + '\'' +
                ", patient_age=" + patient_age +
                ", patient_city='" + patient_city + '\'' +
                ", patient_condition='" + patient_condition + '\'' +
                ", general_practitioner_id=" + general_practitioner_id +
                '}';
    }

}
