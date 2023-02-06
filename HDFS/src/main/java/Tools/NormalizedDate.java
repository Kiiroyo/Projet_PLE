package Tools;

import org.apache.hadoop.io.Writable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOError;
import java.io.IOException;
import static org.apache.hadoop.io.WritableUtils.*;

public class NormalizedDate implements org.apache.hadoop.io.Writable , Comparable<NormalizedDate>, Cloneable {

    private int year = 2022;
    private int month = 10;
    private int day;
    private int hour;
    private double minutes;

    public NormalizedDate(){
    }

    public NormalizedDate(int year, int month, int day, int hour, double minutes){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minutes = minutes;
    }
    
    public NormalizedDate (String horodate){
        String[] date = horodate.split(" ");
        String[] time;
        if (date.length == 2) {
            time = date[1].split(":");
            computeDate(date[0]);
            
        }
		else {
            computeDate(horodate.substring(0, 9));
            time = horodate.substring(10).split(":");
        }
        this.hour = Integer.parseInt(time[0]);
        this.minutes = Double.parseDouble(time[1]);
        
    }

    public NormalizedDate (String jour, String heuresMinutes){
        if ( jour.split("/").length != 3){
            this.day = Integer.parseInt(jour);
        }
        else {
            computeDate(jour);
        }
        
        String[] time = heuresMinutes.split(":");
        if (time.length != 2){
            this.hour = Integer.parseInt(heuresMinutes.substring(0, 2));
            this.minutes = Double.parseDouble(heuresMinutes.substring(2));
        }
        else {
            this.hour =  Integer.parseInt(time[0]);
            this.minutes = Double.parseDouble(time[1]);
        }
        
    }

    private void computeDate(String data){
        String[] date = data.split("/");
        
        this.year = Integer.parseInt(date[0]);
        this.month = Integer.parseInt(date[1]);
        this.day = Integer.parseInt(date[2]);
    }

   // @Override
    public void write(DataOutput out) throws IOException{
        out.writeInt(year);
        out.writeInt(month);
        out.writeInt(day);
        out.writeInt(hour);
        out.writeDouble(minutes);
    }

    //@Override
    public void readFields(DataInput in) throws IOException {
        this.year = in.readInt();
        this.month = in.readInt();
        this.day = in.readInt();
        this.hour = in.readInt();
        this.minutes = in.readDouble();
    }

    //@Override
    public int compareTo(NormalizedDate date){
        if (this.year == date.year && this.month == date.month) return Integer.compare(this.day, date.day);
        if (this.year == date.year) return Integer.compare(this.month, date.month);
        return Integer.compare(this.year, date.year);
    }

    @Override
    public NormalizedDate clone(){
        try{
            NormalizedDate clone = (NormalizedDate) super.clone();
            clone.year = this.year;
            clone.month = this.month;
            clone.day = this.day;
            clone.hour = this.hour;
            clone.minutes = this.minutes;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
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

    public int getHour() {
        return hour;
    }

    public double getMinutes() {
        return minutes;
    }

}
