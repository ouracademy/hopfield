/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ImageProcessTest {

    public ImageProcessTest() {
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
     * Test of getImageFromChooser method, of class ImageProcess.
     */
    @Test
    public void testAbrirImagen() {
        /*
        System.out.println("getImageFromChooser");
        ImageProcess instance = new ImageProcess();
        BufferedImage expResult = null;
        BufferedImage result = instance.getImageFromChooser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of scale method, of class ImageProcess.
     */
    @Test
    public void testScale() {
        System.out.println("Reduce size img");
        ImageProcess instance = new ImageProcess();
        BufferedImage img = instance.getImageFromPath("src/images/Braille_A1.png");
        int targetWidth = 40;
        int targetHeight = 100;
        BufferedImage result = instance.scale(img, targetWidth, targetHeight);
        assertEquals(result.getWidth(),40);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getImageFromPath method, of class ImageProcess.
     */
    @Test
    public void testGetImage() {
        /*
        System.out.println("getImageFromPath");
        String path = "";
        ImageProcess instance = new ImageProcess();
        BufferedImage expResult = null;
        BufferedImage result = instance.getImageFromPath(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of getImageAsPixels method, of class ImageProcess.
     */
    @Test
    public void testGetImageAsPixels() {
        /*
        System.out.println("getImageAsPixels");
        String path = "";
        ImageProcess instance = new ImageProcess();
        double[][] expResult = null;
        double[][] result = instance.getImageAsPixels(path);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of imageAsDataInput method, of class ImageProcess.
     */
    @Test
    public void testImageAsDataInput() {
        /*
        System.out.println("imageAsDataInput");
        double[][] dataInput = null;
        ImageProcess instance = new ImageProcess();
        instance.imageAsDataInput(dataInput);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of escalaGrises method, of class ImageProcess.
     */
    @Test
    public void testEscalaGrises() {
        /*
        System.out.println("escalaGrises");
        ImageProcess instance = new ImageProcess();
        double[][] expResult = null;
        double[][] result = instance.escalaGrises();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
                */
    }

}
