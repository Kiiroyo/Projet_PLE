package Main;
import org.apache.hadoop.fs.BatchListingOperations;

import Jobs.BatchProcessing;
import Jobs.DataCleaning;

public class Main {
    
    public static void main(String[] args) throws Exception {
        DataCleaning.main(args);
        BatchProcessing.main(args);
    }
}
