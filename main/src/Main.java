package src;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        // Print the message for the connection info
        ConnectionFactory.printConnectionInfo();

        System.out.println();

        // Create the objects for the DAO classes
        GeneralPractitionerDaoImpl generalPractitionerDao = new GeneralPractitionerDaoImpl();
        PatientDaoImpl patientDao = new PatientDaoImpl();

        System.out.println("Get the general practitioner with patient older than age 17: ");
        System.out.println(generalPractitionerDao.getGeneralPractitionerWithPatientOlderThanAge(17));
        System.out.println();

        System.out.println("Get the patient without general practitioner in the patient city: ");
        System.out.println(patientDao.getPatientsWithoutGeneralPractitionerInPatientCity());
        System.out.println();

        System.out.println("Get the practitioner with the patients specified condition 'Asthma': ");
        System.out.println(generalPractitionerDao.getGeneralPractitionerWithPatientSpecifiedCondition("Asthma"));
        System.out.println();

        System.out.println("Get the patients with practitioner who has the highest number of the patients: ");
        System.out.println(patientDao.getPatientWithGeneralPractitionerWithHighestNumberOfPatients());
        System.out.println();

        System.out.println("Get the practitioner with more patients than average: ");
        System.out.println(generalPractitionerDao.getGeneralPractitionerWithMorePatientsThanAverage());





    }




}
