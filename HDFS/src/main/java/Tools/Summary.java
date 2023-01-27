package Tools;

public class Summary {
    
    private int totalIn;
    private int totalOut;
    private double averagePL;
    private double averageVL;
    private double averageBUS;
    private double averageMotos;
    private double averageSpeed;
    
    public Summary(int totalIn, int totalOut, double averagePL, double averageVL, double averageBUS,
            double averageMotos, double averageSpeed) {
        this.totalIn = totalIn;
        this.totalOut = totalOut;
        this.averagePL = averagePL;
        this.averageVL = averageVL;
        this.averageBUS = averageBUS;
        this.averageMotos = averageMotos;
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

}
