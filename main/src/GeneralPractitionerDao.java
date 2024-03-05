package src;

import java.util.List;
import java.util.Set;

public interface GeneralPractitionerDao {
    GeneralPractitioner getGeneralPractitionerById(int generalPractitionerId);
    GeneralPractitioner getGeneralPractitionerByName(String generalPractitionerName);
    Set<GeneralPractitioner> getAllGeneralPractitioners();
    GeneralPractitioner addGeneralPractitioner(GeneralPractitioner generalPractitioner);
    boolean updateGeneralPractitioner(GeneralPractitioner generalPractitioner);
    boolean deleteGeneralPractitioner(int generalPractitionerId);

    List<GeneralPractitioner> getGeneralPractitionerWithPatientOlderThanAge(int age);
    List<GeneralPractitioner> getGeneralPractitionerWithPatientSpecifiedCondition(String condition);
    List<GeneralPractitioner> getGeneralPractitionerWithMorePatientsThanAverage();

}
