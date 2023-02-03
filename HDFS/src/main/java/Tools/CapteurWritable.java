package Tools;


import org.apache.hadoop.io.Writable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

import static org.apache.hadoop.io.WritableUtils.*;


import Tools.*;

public class CapteurWritable  implements org.apache.hadoop.io.Writable , Comparable<CapteurWritable>, Cloneable, Serializable{

    //<capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
    private String capteurID;
    private int year;
    private int month;
    private int day;
    private int hours;
    private double minutes;
    private String category;
    private double speed;
    private boolean in;

    public CapteurWritable(){

    }

    public CapteurWritable(String capteurID, NormalizedDate date, String category, double speed, boolean in) {
        this.capteurID = capteurID;
        this.year = date.getYear();
        this.month = date.getMonth();
        this.day = date.getDay();
        this.hours = date.getHour();
        this.minutes = date.getMinutes();
        this.category = category;
        this.speed = speed;
        this.in = in;
    }

    public String getDate(){
        StringBuilder date = new StringBuilder();
        date.append(year);
        date.append("/");
        date.append(month);
        date.append("/");
        date.append(day);
        return date.toString();
    }


    //@Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(capteurID);
        //writeString(out, capteurID);
        out.writeInt(year);
        out.writeInt(month);
        out.writeInt(day);
        out.writeInt(hours);
        out.writeDouble(minutes);
        out.writeUTF(category);
        //writeString(out, category);
        out.writeDouble(speed);
        out.writeBoolean(in);
    }

    //@Override
    public void readFields(DataInput in) throws IOException {
        this.capteurID = in.readUTF();
        this.year = in.readInt();
        this.month = in.readInt();
        this.day = in.readInt();
        this.hours = in.readInt();
        this.minutes = in.readDouble();
        this.category = in.readUTF();
        this.speed = in.readDouble();
        this.in = in.readBoolean();
    }


    //@Override
    public int compareTo(CapteurWritable capteur) {
        int yearCompared = Integer.compare(this.year, capteur.year) * -1;
        int monthCompared = Integer.compare(this.month, capteur.month) * -1;
        int dayCompared = Integer.compare(this.day, capteur.day) * -1;
        int hoursCompared = Integer.compare(this.hours, capteur.hours) * -1;
        int minutesCompared = Double.compare(this.minutes, capteur.minutes) * -1;
        
        int capteurCompared = this.capteurID.compareToIgnoreCase(capteur.capteurID) * -1;
        int speedCompared = Double.compare(this.speed, capteur.speed) * -1;

        int sumCompared = yearCompared + monthCompared + dayCompared + hoursCompared+ minutesCompared  + capteurCompared + speedCompared; 

        return (sumCompared == 0 && this.in == capteur.in) ? this.category.compareToIgnoreCase(capteur.category) * -1 : sumCompared;
    }

    @Override
    public CapteurWritable clone() {
        try {
            CapteurWritable clone = (CapteurWritable) super.clone();
            clone.capteurID = this.capteurID;
            clone.year = this.year;
            clone.month = this.month;
            clone.day = this.day;
            clone.hours = this.hours;
            clone.minutes = this.minutes;
            clone.category = this.category;
            clone.speed = this.speed;
            clone.in = this.in;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String getCapteurID() {
        return capteurID;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHours() {
        return hours;
    }

    public double getMinutes() {
        return minutes;
    }

    public String getCategory() {
        return category;
    }

    public double getSpeed() {
        return speed;
    }

    public boolean isIn() {
        return in;
    }  


}
