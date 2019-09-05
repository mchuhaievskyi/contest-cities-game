package com.itkpi.java.contest.cities.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import com.itkpi.java.contest.cities.Main;

public class IOUtils
{
    private final static String INPUT_CITIES_LIST_FILE_NAME = "input-cities-list.txt";
    private final static String INPUT_CITIES_LIST_FILE_HASH = "lwBDHlgmWG5ngTuN3Mi6t4P7JD0ML1+85ncZKFe1pd0=";

    public static List<String> readCitiesList() throws IOException, NoSuchAlgorithmException, URISyntaxException
    {
        final URI inputFileUri = Main.class.getClassLoader().getResource(INPUT_CITIES_LIST_FILE_NAME).toURI();
        final Path inputFilePath = Paths.get(inputFileUri);

        final List<String> allCitiesList = Files.readAllLines(inputFilePath);

        byte[] citiesBytes = String.join("", allCitiesList).getBytes(StandardCharsets.UTF_8);
        final byte[] digest = MessageDigest.getInstance("SHA-256").digest(citiesBytes);
        final String actualDigestBase64 = Base64.getEncoder().encodeToString(digest);

        if (!INPUT_CITIES_LIST_FILE_HASH.equals(actualDigestBase64))
        {
            throw new IllegalArgumentException("The sha256 digest of the input file is not valid");
        }

        return Collections.unmodifiableList(allCitiesList);
    }
}
