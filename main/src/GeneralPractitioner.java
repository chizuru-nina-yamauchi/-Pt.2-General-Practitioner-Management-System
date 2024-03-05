package src;

public class GeneralPractitioner {
    //Attributes
    private int general_practitioner_id;
    private String general_practitioner_name;
    private int general_practitioner_age;
    private String general_practitioner_city;

    // Constructor
    public GeneralPractitioner(int general_practitioner_id, String general_practitioner_name, int general_practitioner_age, String general_practitioner_city) {
        this.general_practitioner_id = general_practitioner_id;
        this.general_practitioner_name = general_practitioner_name;
        this.general_practitioner_age = general_practitioner_age;
        this.general_practitioner_city = general_practitioner_city;
    }
    // Constructor without id
    public GeneralPractitioner(String general_practitioner_name, int general_practitioner_age, String general_practitioner_city) {
        this.general_practitioner_name = general_practitioner_name;
        this.general_practitioner_age = general_practitioner_age;
        this.general_practitioner_city = general_practitioner_city;
    }

    // Default constructor
    public GeneralPractitioner() {
    }

    // Getters and Setters


    public int getGeneral_practitioner_id() {
        return general_practitioner_id;
    }

    public void setGeneral_practitioner_id(int general_practitioner_id) {
        this.general_practitioner_id = general_practitioner_id;
    }

    public String getGeneral_practitioner_name() {
        return general_practitioner_name;
    }

    public void setGeneral_practitioner_name(String general_practitioner_name) {
        this.general_practitioner_name = general_practitioner_name;
    }

    public int getGeneral_practitioner_age() {
        return general_practitioner_age;
    }

    public void setGeneral_practitioner_age(int general_practitioner_age) {
        this.general_practitioner_age = general_practitioner_age;
    }

    public String getGeneral_practitioner_city() {
        return general_practitioner_city;
    }

    public void setGeneral_practitioner_city(String general_practitioner_city) {
        this.general_practitioner_city = general_practitioner_city;
    }

    // toString method

    @Override
    public String toString() {
        return "GeneralPractitioner{" +
                "general_practitioner_id=" + general_practitioner_id +
                ", general_practitioner_name='" + general_practitioner_name + '\'' +
                ", general_practitioner_age=" + general_practitioner_age +
                ", general_practitioner_city='" + general_practitioner_city + '\'' +
                '}';
    }

}
