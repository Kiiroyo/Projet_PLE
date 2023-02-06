package Tools;

import java.io.Serializable;

public class Summary implements Serializable{
    
    private int totalIn;
    private int totalOut;
    private double averagePL;
    private double averageVL;
    private double averageBUS;
    private double averageMotos;
    private double averageOther;
    private double averageSpeed;
   
    
    public Summary(int totalIn, int totalOut, double averagePL, double averageVL, double averageBUS,
            double averageMotos, double averageOther, double averageSpeed) {
        this.totalIn = totalIn;
        this.totalOut = totalOut;
        this.averagePL = averagePL;
        this.averageVL = averageVL;
        this.averageBUS = averageBUS;
        this.averageMotos = averageMotos;
        this.averageOther = averageOther;
        this.averageSpeed = averageSpeed;
    }

    public double getAveragePL() {
        return averagePL;
    }

    public double getAverageVL() {
        return averageVL;
    }

    public double getAverageBUS() {
        return averageBUS;
    }

    public double getAverageMotos() {
        return averageMotos;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public int getTotalIn() {
        return totalIn;
    }

    public int getTotalOut() {
        return totalOut;
    }

    public double getAverageOther() {
        return averageOther;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.totalIn); str.append(",");
        str.append(this.totalOut); str.append(",");
        str.append(this.averageBUS); str.append(",");
        str.append(this.averageMotos); str.append(",");
        str.append(this.averagePL); str.append(",");
        str.append(this.averageVL); str.append(",");
        str.append(this.averageOther); str.append(",");
        str.append(this.averageSpeed);
        return str.toString();
    }

    

}
