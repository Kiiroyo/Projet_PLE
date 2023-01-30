package batch_processing;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.util.StatCounter;
import scala.Tuple2;

import Tools.CapteurWritable;




public class Spark {

	static int STARTING_YEAR = 2022;
	static int END_YEAR = 2022;


	public static void main(String inputPath) {
		
		SparkConf conf = new SparkConf().setAppName("Batch Processing");
		JavaSparkContext context = new JavaSparkContext(conf);
		context.setLogLevel("ERROR");

		/*JavaRDD<String> ubTrafic = context.textFile(inputPath, 30);

		int partitions = ubTrafic.getNumPartitions();
		System.out.println("Nb partitions : " + partitions);*/

		JavaPairRDD<String,CapteurWritable> ubTrafic  = context.sequenceFile(inputPath, String.class, CapteurWritable.class);
		

		for(int year = STARTING_YEAR;  year < END_YEAR; ++year){
			//TODO

			for(int month = 1; month <=12 ; ++month){
				//TODO

				for(int day = 1; day <= 31; ++ day){
					//TODO

					for(int hour = 0 ; hour < 24; ++ hour){
						//TODO
						final int thisYear = year;
						final int thisMonth = month;
						final int thisDay = day;
						final int thisHour = hour;
						JavaPairRDD<String,CapteurWritable> hourly = ubTrafic.filter(
							(x) -> {
								CapteurWritable capteur = (CapteurWritable) x._2;
								return (capteur.getYear() == thisYear) && (capteur.getMonth() == thisMonth) && (capteur.getDay() == thisDay) && (capteur.getHours() == thisHour);
							});
						//StatCounter hourlyStats = hourly.stats();
						System.out.println("hourly count : " + hourly.count());
						//TODO enregister dans Hbase
					}
				}
			}
		}
	}
}