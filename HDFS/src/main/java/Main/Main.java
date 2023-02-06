package Main;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.util.StatCounter;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import batch_processing.Spark;
import Jobs.*;
public class Main {
    
    public static void main(String[] args) throws Exception {
        //DataCleaning.main(args);
        BatchProcessing.main(args);
       
    }
}
