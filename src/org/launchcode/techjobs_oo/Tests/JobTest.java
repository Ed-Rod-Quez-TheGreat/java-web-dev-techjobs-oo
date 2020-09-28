package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    @Test
//theoretically each Job object id should not be the same, each job id different by 1
    public void testSettingJobId() {
        Job test_Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        Job test_Job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;

        assertEquals(false, test_Job1.equals(test_Job2));
    }

    @Test
    // each Job object should contain 6 fields & proper data types
    //int id, String name, Employer employer, Location location, PostiionType postiontype, CoreCompetency corecompetency

    public void testJobConstructorSetsAllFields() {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(true, test_job3.getName() instanceof String );
        assertEquals(true, test_job3.getEmployer() instanceof Employer );
        assertEquals(true, test_job3.getLocation() instanceof Location );
        assertEquals(true, test_job3.getPositionType() instanceof PositionType );
        assertEquals(true, test_job3.getCoreCompetency() instanceof CoreCompetency );

        assertEquals("Product tester", test_job3.getName() );
        assertEquals("ACME", test_job3.getEmployer().getValue() );
        assertEquals("Desert", test_job3.getLocation().getValue());
        assertEquals("Quality control", test_job3.getPositionType().getValue());
        assertEquals("Persistence", test_job3.getCoreCompetency().getValue());
        //PREVIOUS ATTEMPTED CODE:
/*        assertTrue(test_job3 instanceof Job);
        assertEquals(3.0, test_job3.getId(), .001);
        assertTrue(test_job3.getName() == "Product tester");
        assertTrue(test_job3.getEmployer().getValue() == "ACME");
        assertTrue(test_job3.getLocation().getValue() == "Desert");
        assertTrue(test_job3.getPositionType().getValue() == "Quality control");
        assertTrue(test_job3.getCoreCompetency().getValue() == "Persistence");*/

    }

    @Test
    //two Jobs are equal if ID's match, objects not equal even if all other fields match
    public void testJobsForEquality() {
        Job test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(test_job4.equals(test_job5));
    }

   // @Test
    //toString test, when passed Job object, returns string w/ blank before and after job info
    //TEST NOT NEEDED WHEN toString method completed, only proof of concept
//    public void testToStringBlanks() {
//        assertTrue(test_job1.toString().startsWith(" "));
//        assertTrue(test_job1.toString().endsWith(" "));
//
//    }

    @Test
    //string should contain label for each field, then the data in the field, each on separate line
    public void testToString() {
        Job test_job6 = new Job("Product tester", new Employer("ACME"), new Location(), new PositionType("Quality control"), new CoreCompetency("Persistence"));;

        assertEquals("\nID: 3\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Data not available\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n" , test_job6.toString());
    }

    @Test
    //if field empty, returns 'Data not available'
    public void testIsDataAvail() {
        Job test_job7 = new Job("Product tester", new Employer("ACME"), new Location(), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("\nID: 4\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Data not available\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n" , test_job7.toString());

    }

    @Test
    //(optional) if only has id field, return 'OOPS! This job does not seem to exist'
    public void testDoesJobExist() {
        Job test_job8 = new Job();

        assertEquals("OOPS! This job does not seem to exist.", test_job8.toString());
    }

}
