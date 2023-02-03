package batch_processing;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.util.StatCounter;

import org.apache.hadoop.io.Text;

import scala.Tuple2;

import java.util.Map;

import Tools.*;




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

		/*JavaPairRDD<Text,CapteurWritable> input  = context.sequenceFile(inputPath, Text.class, CapteurWritable.class);

		JavaRDD<CapteurWritable> serializableInput = input.map(
			(x) -> {
				return x._2;
			}
		);

		JavaPairRDD<String,CapteurWritable> ubTrafic = serializableInput.keyBy(
			(x)->{
				return x.capteurID;  
			}
		);


		for(int year = STARTING_YEAR;  year <= END_YEAR; ++year){
			final int thisYear = year;
			JavaPairRDD<String,CapteurWritable> yearly = ubTrafic.filter(
				(x) -> {
					CapteurWritable capteur = (CapteurWritable) x._2;
					return capteur.year == thisYear;
				});
			if( yearly.collectAsMap().size() != 0){
				//TODO save in hbase
				for(int month = 1; month <=12 ; ++month){
					final int thisMonth = month;
					JavaPairRDD<String,CapteurWritable> monthly = yearly.filter(
						(x) -> {
							CapteurWritable capteur = (CapteurWritable) x._2;
							return capteur.month == thisMonth;
						});
					if( monthly.collectAsMap().size() != 0){
						//TODO save in hbase
						for(int day = 1; day <= 31; ++ day){
							final int thisday = day;
							JavaPairRDD<String,CapteurWritable> dayly = monthly.filter(
								(x) -> {
									CapteurWritable capteur = (CapteurWritable) x._2;
									return capteur.day == thisday;
								});
							if( dayly.collectAsMap().size() != 0){
								//TODO save in hbase
								for(int hour = 0 ; hour < 24; ++ hour){
									final int thisHour = hour;
									JavaPairRDD<String,CapteurWritable> hourly = dayly.filter(
										(x) -> {
											CapteurWritable capteur = (CapteurWritable) x._2;
											return capteur.hours == thisHour;
										});
									
									JavaPairRDD<String,Iterable<CapteurWritable>> hourlyGroup = hourly.groupByKey();
									JavaPairRDD<String,Summary> hourlySummary = hourlyGroup.mapValues(
										(x) -> {
											DataStatistiques statistics = new DataStatistiques();
											for (CapteurWritable capteur : x){
												statistics.addData(capteur);
											}
											Summary summary = statistics.computeSummary();
											return summary;
										}
									);
									Map<String,Summary> hourlyStatistics = hourlySummary.collectAsMap();
									//StatCounter hourlyStats = hourly.stats();
									System.out.println("hourly count : ("+ thisYear+"/"+thisMonth+"/"+thisday+") " + hourlyStatistics.size());
									//TODO enregister dans Hbase
							
				
								}
							}
						}
					}		
				}
			}
		}*/
	}
}