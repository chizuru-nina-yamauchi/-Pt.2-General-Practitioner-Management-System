package src;

import java.util.List;
import java.util.Set;

public interface PatientDao {
    Patient getPatientById(int patientId);
    Patient getPatientByName(String patientName);
    Set<Patient> getAllPatients();
    Patient addPatient(Patient patient);
    boolean updatePatient(Patient patient);
    boolean deletePatient(int patientId);
    List<Patient> getPatientsWithoutGeneralPractitionerInPatientCity();
    List<Patient> getPatientWithGeneralPractitionerWithHighestNumberOfPatients();

}
