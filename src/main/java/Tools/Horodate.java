package Tools;

public class Horodate {
    private String date;
    private String hour;
    private String minutes;
    
    public Horodate (String horodate){
        String[] data = horodate.split(" ");
		String[] time = data[1].split(":");

        this.date = data[0];
        this.hour = time[0];
        this.minutes = time[1];
    }

    public String getDate(){
        return this.date;
    }

    public String getHours(){
        return this.hour;
    }
    
    public String getMinutes(){
        return this.minutes;
    }
}
