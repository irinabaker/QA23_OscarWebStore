package com.telran.oscar.utils;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public static Iterator<Object[]> registrationWithInvalidEmail() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/negEmail.csv")));

        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
}
