package src;

public enum SqlQuery {
    GET_ALL_GENERAL_PRACTITIONERS("SELECT * FROM general_practitioners"),
    GET_GENERAL_PRACTITIONER_BY_ID("SELECT * FROM general_practitioners WHERE general_practitioner_id = ?"),
    GET_GENERAL_PRACTITIONER_BY_NAME("SELECT * FROM general_practitioners WHERE name = ?"),
    INSERT_GENERAL_PRACTITIONER("INSERT INTO general_practitioners (name, age, city) VALUES (?, ?, ?)"),
    UPDATE_GENERAL_PRACTITIONER("UPDATE general_practitioners SET name = ?, age =?, city = ? WHERE general_practitioner_id = ?"),
    DELETE_GENERAL_PRACTITIONER("DELETE FROM general_practitioners WHERE general_practitioner_id = ?"),
    GET_ALL_PATIENTS("SELECT * FROM patients"),
    GET_PATIENT_BY_ID("SELECT * FROM patients WHERE patient_id = ?"),
    GET_PATIENT_BY_NAME("SELECT * FROM patients WHERE name = ?"),
    INSERT_PATIENT("INSERT INTO patients (name, age, city, condition, general_practitioner_id) VALUES (?, ?, ?, ?, ?)"),
    UPDATE_PATIENT("UPDATE patients SET name = ?, age = ?, city = ?, condition = ?, general_practitioner_id = ? WHERE patient_id = ?"),
    DELETE_PATIENT("DELETE FROM patients WHERE patient_id = ?"),

    GET_GENERAL_PRACTITIONERS_WITH_PATIENT_OLDER_THAN_AGE(
            "SELECT * FROM general_practitioners gp "
            + "WHERE EXISTS(SELECT 1 FROM patients p WHERE gp.general_practitioner_id = p.general_practitioner_id AND p.age > ?)"
    ),
    GET_PATIENTS_WITHOUT_GENERAL_PRACTITIONER_IN_PATIENT_CITY(
            "SELECT * FROM patients p "
            + "WHERE NOT EXISTS(SELECT 1 FROM general_practitioners gp WHERE gp.general_practitioner_id = p.general_practitioner_id) "
            + "AND p.city = ?"
    ),
    GET_GENERAL_PRACTITIONER_WITH_PATIENTS_SPECIFIED_CONDITIONS(
            "SELECT * FROM general_practitioners gp "
            + "WHERE gp.general_practitioner_id = ANY(SELECT general_practitioner_id FROM patients WHERE condition = ?)"
    ),
    GET_PATIENT_WITH_GENERAL_PRACTITIONER_WITH_HIGHEST_NUMBER_OF_PATIENTS(
            "SELECT * FROM patients p "
            + "WHERE p.general_practitioner_id = ANY(SELECT general_practitioner_id FROM patients "
            + "GROUP BY general_practitioner_id ORDER BY COUNT(*) DESC LIMIT 1)"
    ),
    GET_GENERAL_PRACTITIONER_WITH_MORE_PATIENTS_THAN_AVERAGE(
            "SELECT * FROM general_practitioners gp "
            + "WHERE gp.general_practitioner_id = ANY(SELECT general_practitioner_id FROM patients "
            + "GROUP BY general_practitioner_id HAVING COUNT(*) > ALL(SELECT AVG(COUNT(*)) FROM patients GROUP BY general_practitioner_id))"
    );

    public final String query;

    SqlQuery(String query) {
        this.query = query;
    }


}
