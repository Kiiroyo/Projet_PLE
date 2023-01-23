package Mappers;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DataCleaningMapperP1 extends Mapper<LongWritable, Text, Text, Text>{
		
		@Override
		public void map(LongWritable key, Text value, Context context
				) throws IOException, InterruptedException {
			// on retire la premiere ligne (le header)
			if(key.get() == 0L) return;
			
			String[] tokens = value.toString().split(",");
			String country = tokens[0].toLowerCase();
			String regCode = tokens[3];
			String cityName = tokens[1];
			
			String k = country+","+regCode;
			
			context.write(new Text(k), new Text(cityName + true));
		}
}

