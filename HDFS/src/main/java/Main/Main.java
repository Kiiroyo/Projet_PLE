package Main;
import org.apache.hadoop.fs.BatchListingOperations;

import Jobs.BatchProcessing;
import Jobs.DataCleaning;
import batch_processing.Spark;

public class Main {
    
    public static void main(String[] args) throws Exception {
        DataCleaning.main(args);
        Spark.main(args[1]);
    }
}
