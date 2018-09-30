/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hotel.HotelHelper;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import hotel.entities.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class CheckoutCTLTest {

    // creating a byteArrayOutputStream object
    // declaring and instanciating
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public CheckoutCTLTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // prints out the output of the method
        System.setOut(new PrintStream(outContent));
        // System.setErr(new PrintStream(errContent));

    }

    @After
    public void tearDown() {
    }

    //
    // /**
    // * Test of roomIdEntered method, of class CheckoutCTL.
    // */
@Test
public void testRoomIdEntered() {
    System.out.println("roomIdEntered");
    
    //declaring the hotel object
    Hotel hotel = null;
    
    //trying the try catch so that any exception that is occured will be captured.
    try {
        //instanciating the hotel object
        hotel = HotelHelper.loadHotel();
    } catch (Exception ex) {
        Logger.getLogger(CheckoutCTLTest.class.getName()).log(Level.SEVERE, null, ex);
    }

        //the room ID used in hotelhelper class is 301. So, that is the room ID that is being used.
        int roomId =301;

        //creating a checkoutCTL object and then passing the hotel object as an argument.
        CheckoutCTL instance = new CheckoutCTL(hotel);
        
        //calling the method to check the roomID that is being entered.
        instance.roomIdEntered(roomId);
        
        //the output is then converted to string and then stored to the variable output.
        String output = outContent.toString();

        //using the assertEquals to check the value of the string
        assertEquals("$7.00",output);

}

    
}
