package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralPractitionerDaoImplTest {
    private GeneralPractitionerDao generalPractitionerDao;

    @Test
    @BeforeEach
    void setUp() {
        generalPractitionerDao = new GeneralPractitionerDaoImpl();
    }

    @Test
    void testGetGeneralPractitionerWithPatientOlderThanAge() {
    // Assuming the general practitioner with patient older than age 19 Exists
        assertNotNull(generalPractitionerDao.getGeneralPractitionerWithPatientOlderThanAge(19));

    }
    @Test
    void testGetGeneralPractitionerWithPatientSpecifiedCondition() {
        // Assuming the general practitioner with patient with specified condition 'Injury' Exists
        assertNotNull(generalPractitionerDao.getGeneralPractitionerWithPatientSpecifiedCondition("Injury"));
        // Assuming the general practitioner with patient with specified condition 'Injury' is Obanai Iguro
        assertEquals("Obanai Iguro", generalPractitionerDao.getGeneralPractitionerWithPatientSpecifiedCondition("Injury").get(0).getGeneral_practitioner_name());
    }

    @Test
    void testGetGeneralPractitionerWithMorePatientsThanAverage() {
        // Assuming the general practitioner with more patients than average Exists
        assertNotNull(generalPractitionerDao.getGeneralPractitionerWithMorePatientsThanAverage());
        // Assuming the general practitioner with more patients than average is Sanemi Shinazugawa
        assertEquals("Sanemi Shinazugawa", generalPractitionerDao.getGeneralPractitionerWithMorePatientsThanAverage().get(0).getGeneral_practitioner_name());

    }



}