package Tools;



public class NormalizedDate {

    private int year = 2022;
    private int month = 10;
    private int day;
    private int hour;
    private double minutes;

    
    public NormalizedDate (String horodate){
        String[] date = horodate.split(" ");
		String[] time = date[1].split(":");
        
        computeDate(date[0]);
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
            this.hour = Integer.parseInt(heuresMinutes.substring(0, 3));
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
