package itmo.web.lab3;

import itmo.web.lab3.database.DataBase;
import lombok.Data;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Bean class with main logic
 * @author Romariok on 21.10.2023
 */
@Model
@Data
public class Bean implements Serializable {
    /**
     * Database injection
     */
    @Inject
    private DataBase dataBase;

    /**
     * List of points
     */
    private List<Point> points;

    /**
     * Current point
     */
    private Point currPoint;

    /**
     * List of available X values
     */
    private List<Double> availableItems;

    /**
     * List of selected X values
     */
    private List<Double> selectedItems;

    /**
     * Initialization method called after bean creation
     */
    @PostConstruct
    private void initialize() {
        availableItems = new ArrayList<>();
        for (double i = -4; i <= 4; i++) {
            availableItems.add(i);
        }
        currPoint = new Point();
        currPoint.setBornDate(new Date());
        updateLocal();
    }

    /**
     * Updates the local list of points from the database
     */
    private void updateLocal() {
        points = dataBase.getAll();
    }

    /**
     * Adds the current point to the database
     */
    public void addResult() {
        Point copyPoint = new Point(currPoint);
        dataBase.save(copyPoint);
        currPoint.setBornDate(new Date());
        updateLocal();
    }

    /**
     * Clears the database of all points
     */
    public void clearResults() {
        dataBase.clear();
        points = dataBase.getAll();
        updateLocal();
    }

    /**
     * Handles the change of the selected X value
     */
    public void handleSelectionChange() {
        if (selectedItems != null && !selectedItems.isEmpty()) {
            System.out.println("Selected items: " + selectedItems);
            currPoint.setX(selectedItems.get(0));
        } else {
            System.out.println("No items selected");
        }
    }
}