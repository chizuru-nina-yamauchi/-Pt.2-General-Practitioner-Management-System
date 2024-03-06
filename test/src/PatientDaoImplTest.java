package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientDaoImplTest {
    private PatientDao patientDao;

    @Test
    @BeforeEach
    void setUp() {
        patientDao = new PatientDaoImpl();
    }

    @Test
    void testGetPatientsWithoutGeneralPractitionerInPatientCity() {
        // Assuming the patients without general practitioner Exists
        assertNotNull(patientDao.getPatientsWithoutGeneralPractitionerInPatientCity());
        // Assuming the patients without general practitioner in patient city is 2
        assertEquals(2, patientDao.getPatientsWithoutGeneralPractitionerInPatientCity().size());
    }

    @Test
    void testGetPatientWithGeneralPractitionerWithHighestNumberOfPatients() {
        // Assuming the patient with general practitioner with highest number of patients Exists
        assertNotNull(patientDao.getPatientWithGeneralPractitionerWithHighestNumberOfPatients());
        // Assuming the patient with general practitioner with highest number of patients is 3
        assertEquals(3, patientDao.getPatientWithGeneralPractitionerWithHighestNumberOfPatients().size());
    }

}