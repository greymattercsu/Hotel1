/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.service;

import hotel.entities.ServiceType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class RecordServiceCTLTest {
    
    public RecordServiceCTLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Test of serviceDetailsEntered method, of class RecordServiceCTL.
     */
    @Test
    public void testServiceDetailsEntered() {
        System.out.println("serviceDetailsEntered");
        ServiceType serviceType = null;
        double cost = 0.0;
        RecordServiceCTL instance = null;
        instance.serviceDetailsEntered(serviceType, cost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
