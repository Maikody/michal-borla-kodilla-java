package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    public void testExceptionHandling(){
        SecondChallenge challenge = new SecondChallenge();
        assertAll(
                () -> assertDoesNotThrow(() -> challenge.probablyIWillThrowException(1, 3)),
                () -> assertEquals("Done!", challenge.probablyIWillThrowException(1, 3)),
                () -> assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(2, 1.5))
        );
    }
}
