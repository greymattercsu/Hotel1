
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
public class SimplifiedAutomatedTest {

    // creating a byteArrayOutputStream object
    // declaring and instanciating
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public SimplifiedAutomatedTest() {
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
    // * This demonstrates that the total charge is reported as 0.00 when checking
    // out
    // */
    @Test
    public void testRoomIdEntered() {
        System.out.println("roomIdEntered");

        // declaring the hotel object
        Hotel hotel = null;

        // trying the try catch so that any exception that is occured will be captured.
        try {
            // instanciating the hotel object
            hotel = HotelHelper.loadHotel();
        } catch (Exception ex) {
            Logger.getLogger(CheckoutCTLTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // the room ID used in hotelhelper class is 301. So, that is the room ID that is
        // being used.
        int roomId = 301;

        // creating a checkoutCTL object and then passing the hotel object as an
        // argument.
        CheckoutCTL instance = new CheckoutCTL(hotel);

        // calling the method to check the roomID that is being entered.
        instance.roomIdEntered(roomId);

        // the output is then converted to string and then stored to the variable
        // output.
        String output = outContent.toString();

        // using the assertEquals to check the value of the string
        // Now comparing the exact value that is expected to the result shown
        // here substring is used to get the total dollar value from all of the result
        // of the output
        assertEquals("$7.00", output.substring(output.lastIndexOf(":") + 1, output.length() - 1));

    }


    /**
     * Test of creditDetailsEntered method, of class CheckoutCTL.
     * /*Checking the possiblility of charging a room for service after the guest has checked out
     */
   @Test
   public void testCheckOutAndChargeRoom() {
       System.out.println("Checkout from the room and then add service charge");
       Hotel hotel = null;

       //using the roomID that is used in the hotelhelper class
       int roomId= 301;
       try {
           hotel = HotelHelper.loadHotel();
       } catch (Exception ex) {
           Logger.getLogger(CheckoutCTLTest.class.getName()).log(Level.SEVERE, null, ex);
       }
       //checking out of the hotel
       hotel.checkout(roomId);
       
       
      
       System.out.println("Checking serviceDetailsEntered");
       //adding the room service charge of 20
       ServiceType serviceType = ServiceType.ROOM_SERVICE;
       double cost = 20.0;

       //creating the instance of the record service 
       RecordServiceCTL instance = new RecordServiceCTL(hotel);
       instance.roomNumberEntered(roomId);
       //adding the service name and charge to the record service
       instance.serviceDetailsEntered(serviceType, cost);
       String output = outContent.toString();

       //here the output should be no active booking found 
       //But this will add service charge to the room ID even if this room has checked out
       assertEquals("No active booking for room id: 201",output.substring(output.lastIndexOf("Entered")+7, output.length()-1));
    

   }


//    possible to charge a room for service after the guest has checked out. Two services are added.
    @Test
    public void testCheckOutAnd2ChargeRoom() {
        System.out.println("Checkout from the room and then add service charge");
        Hotel hotel = null;
 
        //using the roomID that is used in the hotelhelper class
        int roomId= 301;
        try {
            hotel = HotelHelper.loadHotel();
        } catch (Exception ex) {
            Logger.getLogger(CheckoutCTLTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //checking out of the hotel
        hotel.checkout(roomId);
        
        
       
        System.out.println("Checking serviceDetailsEntered");
        //adding the room service charge of 20
        ServiceType serviceType = ServiceType.ROOM_SERVICE;
        double cost = 20.0;
 
        //creating the instance of the record service 
        RecordServiceCTL instance = new RecordServiceCTL(hotel);
        instance.roomNumberEntered(roomId);
        //adding the service name and charge to the record service
        instance.serviceDetailsEntered(serviceType, cost);
        
 
        ServiceType serviceType1 = ServiceType.RESTAURANT;
        //creating the instance of the record service 
        double restrauntCost = 20.0;
        instance = new RecordServiceCTL(hotel);
        instance.roomNumberEntered(roomId);
        //adding the service name and charge to the record service
        instance.serviceDetailsEntered(serviceType1, restrauntCost);
        String output = outContent.toString();


        //here the output should be no active booking found. Here two services are added to check if they are added to the system.
        //But this will add service charge to the room ID even if this room has checked out
        assertEquals("No active booking for room id: 201",output.substring(output.lastIndexOf("Entered")+7, output.length()-1));
     
 
    }

    //    possible to charge a room for service after the guest has checked out. Four services are added.
    @Test
    public void testCheckOutAnd4ChargeRoom() {
        System.out.println("Checkout from the room and then add service charge");
        Hotel hotel = null;
 
        //using the roomID that is used in the hotelhelper class
        int roomId= 301;
        try {
            hotel = HotelHelper.loadHotel();
        } catch (Exception ex) {
            Logger.getLogger(CheckoutCTLTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //checking out of the hotel
        hotel.checkout(roomId);
        
        
       
        System.out.println("Checking serviceDetailsEntered");
        //adding the room service charge of 20
        ServiceType serviceType = ServiceType.ROOM_SERVICE;
        double cost = 20.0;
 
        //creating the instance of the record service 
        RecordServiceCTL instance = new RecordServiceCTL(hotel);
        instance.roomNumberEntered(roomId);
        //adding the service name and charge to the record service
        instance.serviceDetailsEntered(serviceType, cost);
        
 
        ServiceType serviceType1 = ServiceType.BAR_FRIDGE;
        double barCost = 20.0;
        //creating the instance of the record service 
        instance = new RecordServiceCTL(hotel);
        instance.roomNumberEntered(roomId);
        //adding the service name and charge to the record service
        instance.serviceDetailsEntered(serviceType1, barCost);

        ServiceType serviceType2 = ServiceType.RESTAURANT;
        double restrauntCost = 20.0;
        //creating the instance of the record service 
        instance = new RecordServiceCTL(hotel);
        instance.roomNumberEntered(roomId);
        //adding the service name and charge to the record service
        instance.serviceDetailsEntered(serviceType2, restrauntCost);

        ServiceType serviceType3 = ServiceType.BAR_FRIDGE;
        double barCost1 = 20.0;
        //creating the instance of the record service 
        instance = new RecordServiceCTL(hotel);
        instance.roomNumberEntered(roomId);
        //adding the service name and charge to the record service
        instance.serviceDetailsEntered(serviceType3, barCost1);

        String output = outContent.toString();


        //here the output should be no active booking found. Here two services are added to check if they are added to the system.
        //But this will add service charge to the room ID even if this room has checked out
        assertEquals("No active booking for room id: 201",output.substring(output.lastIndexOf("Entered")+7, output.length()-1));
     
 
    }


}
