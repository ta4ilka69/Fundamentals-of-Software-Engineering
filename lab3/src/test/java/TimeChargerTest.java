import itmo.web.lab3.TimeCharger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimeChargerTest {

    private TimeCharger timeCharger;

    @BeforeEach
    void setUp() {
        timeCharger = new TimeCharger();
    }

    @Test
    void testTimeInitialization() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String currentTime = dateFormat.format(new Date());

        assertEquals(currentTime, timeCharger.getTime());
    }

    @Test
    void testUpdateTime() throws ParseException, InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String initialTime = timeCharger.getTime();

        Thread.sleep(1000); // Wait for 1 second
        timeCharger.updateTime();
        String updatedTime = timeCharger.getTime();

        assertNotEquals(initialTime, updatedTime);

        Date initialDate = dateFormat.parse(initialTime);
        Date updatedDate = dateFormat.parse(updatedTime);

        assertTrue(updatedDate.after(initialDate));
    }

}