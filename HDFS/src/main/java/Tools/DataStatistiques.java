package Tools;

//import Tools.Summary;

public class DataStatistiques {

    private int sum;
    private int in;
    private int out;

    //category
    private double vl;
    private double pl;
    private double motos;
    private double bus;
    private double velo;
    private double other;

    private double speed;
    
    

    public DataStatistiques() {
        this.sum = 0;
        this.in = 0;
        this.out = 0;

        this.vl = 0;
        this.pl = 0;
        this.motos = 0;
        this.bus = 0;
        this.velo = 0;
        this.other = 0;

        this.speed = 0;
    }

    public void addData(CapteurWritable capteur){
        this.sum ++;

        String category = capteur.getCategory();
        if (category.equalsIgnoreCase("VL")) this.vl += 1.0;
        else if (category.equalsIgnoreCase("PL")) this.pl += 1.0;
        else if (category.equalsIgnoreCase("2RM")) this.motos += 1.0;
        else if (category.startsWith("BUS")) this.bus += 1.0;
        else if (category.startsWith("VELO")) this.velo += 1.0 ;
        else this.other += 1.0;

        if(capteur.isIn()) this.in ++; else this.out ++;

        if (capteur.getSpeed() > 0) this.speed += capteur.getSpeed();
    }

    public Summary computeSummary(){
        return new Summary(this.in, this.out,  this.pl/this.sum, this.vl/this.sum, this.bus/this.sum, this.motos/this.sum, this.speed/this.sum);
    }
}
