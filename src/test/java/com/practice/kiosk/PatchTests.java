package com.practice.kiosk;


import com.practice.kiosk.domain.Train;
import org.junit.jupiter.api.Test;
import static com.practice.kiosk.TestDataUtil.createTestTrain320;
import java.time.LocalTime;

public class PatchTests {

    @Test
    public void testThatFetchByTrainIdReturnsCorrectSchedules(){
        TestDataUtil.createTestTrain320();

    }
}
