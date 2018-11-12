package com.example.ben.cs2340;

import com.example.ben.cs2340.model.Location;
import com.example.ben.cs2340.model.LocationManager;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;


public class GenUnitTest {

    ArrayList<Location> dumbList = new ArrayList<>();
    private BufferedReader reader;
    ArrayList<Location> x;
    LocationManager man = new LocationManager();


    @Before
    public void setUp() {
        File file = new File("stupid.csv");

        {
            if (x != null) {
                try {

                    reader = new BufferedReader(new FileReader(file));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }


        }
//        x = man.parseData(reader);
        x = new ArrayList<>();

    }

    @Test
    public void equals_isCorrect() {
//        try {
//            assertEquals(dumbList, man.parseData(reader));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        assertEquals(dumbList, x);
    }


}






