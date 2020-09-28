package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    //set job objects for future testing

    @Before

    public void testJobObjects() {
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }


    @Test
//theoretically each Job object id should not be the same, each job id different by 1
    public void testSettingJobId() {
        assertTrue(!test_job1.equals(test_job2));
        assertTrue(test_job1.getId() + 1 == test_job2.getId());
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
        assertFalse(test_job3.equals(test_job4));
    }

    @Test
    //toString test, when passed Job object, returns string w/ blank before and after job info

    public void testToStringBlanks() {
        assertTrue(test_job1.toString().startsWith(" "));
        assertTrue(test_job1.toString().endsWith(" "));

    }

    @Test
    //string should contain label for each field, then the data in the field, each on separate line
    public void testLabelsAndFields() {
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;



    }


    //if field empty, returns 'Data not available'
    //(optional) if only has id field, return 'OOPS! This job does not seem to exist'
}
