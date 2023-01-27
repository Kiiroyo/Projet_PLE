package Tools;



public class NormalizedDate {
    private String date;
    private String hour;
    private String minutes;

    private static String THE_MONTH = "10";
    private static String THE_YEAR = "2022";
    
    public NormalizedDate (String horodate){
        String[] data = horodate.split(" ");
		String[] time = data[1].split(":");

        this.date = data[0];
        this.hour = time[0];
        this.minutes = time[1];
    }

    public NormalizedDate (String jour, String heuresMinutes){
        if ( jour.split("/").length != 3){
            this.date = THE_YEAR + "/" + THE_MONTH + "/" + jour;
        }
        else {
            this.date = jour;
        }
        this.hour = heuresMinutes.substring(0, 3);
        this.minutes = heuresMinutes.substring(2, 5);
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
