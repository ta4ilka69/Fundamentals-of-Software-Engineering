import itmo.web.lab3.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    private Point point;

    @BeforeEach
    void setUp() {
        point = new Point();
    }

    @Test
    void testCheckCoordinatesHit() {
        point.setX(1);
        point.setY(1);
        point.setR(2);
        assertTrue(point.checkCoordinates(point.getX(), point.getY(), point.getR()));
    }

    @Test
    void testCheckCoordinatesMiss() {
        point.setX(3);
        point.setY(3);
        point.setR(2);
        assertFalse(point.checkCoordinates(point.getX(), point.getY(), point.getR()));
    }

    @Test
    void testGetStringSuccess() {
        point.setX(1);
        point.setY(1);
        point.setR(2);
        point.setStatus(point.checkCoordinates(point.getX(), point.getY(), point.getR()));
        assertEquals("Hit", point.getStringSuccess());
    }

    @Test
    void testGetColor() {
        point.setX(1);
        point.setY(1);
        point.setR(2);
        point.setStatus(point.checkCoordinates(point.getX(), point.getY(), point.getR()));
        assertEquals("green", point.getColor());
    }

    @Test
    void testSetBornDate() {
        Date date = new Date();
        point.setBornDate(date);
        assertEquals(date, point.getBornDate());
    }

    @Test
    void testCopyConstructor() {
        point.setX(1);
        point.setY(2);
        point.setR(3);
        point.setBornDate(new Date());
        point.setStatus(true);

        Point copiedPoint = new Point(point);

        assertEquals(point.getX(), copiedPoint.getX());
        assertEquals(point.getY(), copiedPoint.getY());
        assertEquals(point.getR(), copiedPoint.getR());
        assertEquals(point.getBornDate(), copiedPoint.getBornDate());
        assertEquals(point.isStatus(), copiedPoint.isStatus());
    }
}