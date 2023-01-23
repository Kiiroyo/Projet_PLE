package Mappers;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


//ID,Catégorie,horodate,vers CROUS,vers Cours de la Libération

public class DataCleaningMapperP1 extends Mapper<LongWritable, Text, NullWritable, Text>{
		
		@Override
		public void map(LongWritable key, Text value, Context context ) throws IOException, InterruptedException {
			// on retire la premiere ligne (le header)
			if(key.get() == 0L) return;

			String[] data = value.toString().split(",");
			
			String[] hordatage = data[2].split(" ");
			String[] time = hordatage[1].split(":");
			
			boolean in = data[3].equals("1");
			
			String destination;
			if (in){
				destination = "Crous";
			}else {
				destination = "Cours de la Libération";
			}
			
			context.write(NullWritable.get(), new Text(hordatage[0] + "," + time[0] + "," + time[1] + "," + data[1] + "," + in + "," + destination));
		}
}

