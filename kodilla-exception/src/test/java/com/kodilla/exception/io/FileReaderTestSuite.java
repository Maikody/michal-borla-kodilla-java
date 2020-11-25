package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    public void testReadFile(){
        FileReader fileReader = new FileReader();
        assertDoesNotThrow(() -> fileReader.readFile());
    }

    @Test
    public void whenFileDosentExistsReadFileShouldThrowException() {
        FileReader fileReader = new FileReader();
        String fileName = "nie_ma_takiego_pliku.txt";
        assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName));
    }

    @Test
    public void testReadFileWithName() {
        FileReader fileReader = new FileReader();
        assertAll(
                () -> assertDoesNotThrow(() -> fileReader.readFile()),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("nie_ma_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null))
        );
    }
}
