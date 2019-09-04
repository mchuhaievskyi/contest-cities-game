package com.itkpi.java.contest.cities.utils;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import com.itkpi.java.contest.cities.Main;

public class IOUtils
{
    private final static String INPUT_CITIES_LIST_FILE_NAME = "input-cities-list.txt";
    private final static String INPUT_CITIES_LIST_FILE_HASH = "3K1Z+/xUuF1dzjNR/B8tV9CC7uhaAmbIVjCFE/1S2L8=";

    public static List<String> readCitiesList() throws Exception
    {
        final URI inputFileUri = Main.class.getClassLoader().getResource(INPUT_CITIES_LIST_FILE_NAME).toURI();
        final Path inputFilePath = Paths.get(inputFileUri);

        final byte[] digest = MessageDigest.getInstance("SHA-256").digest(Files.readAllBytes(inputFilePath));
        final String actualDigestBase64 = Base64.getEncoder().encodeToString(digest);

        if (!INPUT_CITIES_LIST_FILE_HASH.equals(actualDigestBase64))
        {
            throw new IllegalArgumentException("The sha256 digest of the input file is not valid");
        }

        return Collections.unmodifiableList(Files.readAllLines(inputFilePath));
    }
}
