package itmo.web.lab3.database;

import itmo.web.lab3.Point;

import java.util.List;

/**
 * Interface for working with the point database
 * @author Romariok on 05.11.2023
 */
public interface DataBase {
    /**
     * Saves a point in the database
     * @param point The point to be saved
     */
    void save(Point point);

    /**
     * Clears the database of all points
     * @return true if the operation is successful, false otherwise
     */
    boolean clear();

    /**
     * Gets a list of all points from the database
     * @return List of points
     */
    List<Point> getAll();
}