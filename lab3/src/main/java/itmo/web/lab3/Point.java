package itmo.web.lab3;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;

/**
 * A class representing a point on a coordinate plane
 * @author Romariok on 21.10.2023
 */
@ApplicationScoped
@Entity
@Table(name="point")
public class Point implements Serializable {

    /**
     * Point identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    /**
     * X coordinate of the point
     */
    @Column(name = "x", nullable = false)
    private double x;

    /**
     * Y coordinate of the point
     */
    @Column(name = "y", nullable = false)
    private double y;

    /**
     * Radius of the area
     */
    @Column(name = "r", nullable = false)
    private double r;

    /**
     * Creation date of the point
     */
    @Column(name = "borndate", nullable = false)
    private Date bornDate;

    /**
     * Status indicating whether the point is within the area
     */
    @Column(name = "coordsstatus", nullable = false)
    private boolean status;

    /**
     * Constructor creating a new point based on an existing one
     * @param point The original point
     */
    public Point(Point point){
        this.id = point.id;
        this.x = point.getX();
        this.y = point.getY();
        this.r = point.getR();
        this.status = checkCoordinates(x, y, r);
        this.bornDate = point.getBornDate();
    }

    /**
     * Default constructor
     */
    public Point(){
    }

    /**
     * Checks if a point with given coordinates (x, y) is within the area
     * bounded by the radius r
     * @param x X coordinate
     * @param y Y coordinate
     * @param r Radius of the area
     * @return true if the point is within the area, false otherwise
     */
    public boolean checkCoordinates(double x, double y, double r){
        return ((y>=0 && y <=r && x >=0 && x <=(r/2)) ||
                (x >=-(r+y) && x <=0 && y <=0 && y>=-r) ||
                (x >=0 && y<=0 &&  Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= r ));
    }

    /**
     * Returns a string representation of the result of the point being within the area
     * @return "Hit" or "Miss"
     */
    public String getStringSuccess() {
        return status ? "Hit" : "Miss";
    }

    /**
     * Returns the color corresponding to the result of the point being within the area
     * @return "green" for a hit, "red" for a miss
     */
    public String getColor(){
        return status ? "green" : "red";
    }

    /**
     * Sets the creation date of the point
     * @param date Creation date
     */
    public void setBornDate(Date date){
        this.bornDate = date;
    }

    /**
     * Sets the X coordinate of the point
     * @param x X coordinate
     */
    public void setX(double x){
        this.x = x;
    }

    /**
     * Returns the X coordinate of the point
     * @return x X coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the Y coordinate of the point
     * @return y Y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the R coordinate of the point
     * @return r R coordinate
     */
    public double getR() {
        return r;
    }

    /**
     * Returns the creation date of the point
     * @return bornDate Creation time
     */
    public Date getBornDate() {
        return bornDate;
    }

    /**
     * Returns the ID of the point
     * @return id Point ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns whether the point is within the area
     * @return true if the point is within the area
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the ID of the point
     * @param id Point ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the Y coordinate of the point
     * @param y Y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Sets the R coordinate of the point
     * @param r R coordinate
     */
    public void setR(double r) {
        this.r = r;
    }

    /**
     * Sets the status indicating whether the point is within the area
     * @param status True or False
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}