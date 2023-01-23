import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import Mappers.DataCleaningMapperP1;

public class DataCleaning extends Configured implements Tool {
	
	public static class JoinMapperCities
	extends Mapper<LongWritable, Text, Text, Text>{
		
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
	
	public static class JoinMapperRegions
	extends Mapper<LongWritable, Text, Text, Text>{
		
		@Override
		public void map(LongWritable key, Text value, Context context
				) throws IOException, InterruptedException {
			// pas de header dans le fichier des regions
			
			String[] tokens = value.toString().split(",");
			String country = tokens[0].toLowerCase();
			String regCode = tokens[1];
			String regName = tokens[2];
			
			String k = country+","+regCode;
			
			context.write(new Text(k), new Text(regName + false));
		}
	}
	
	public int run(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "MRJoin");
		job.setNumReduceTasks(1);
		job.setJarByClass(DataCleaning.class);
		
		MultipleInputs.addInputPath(job, new Path(args[0] + "P1/P1.csv" ), TextInputFormat.class, DataCleaningMapperP1.class);
		MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, JoinMapperRegions.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);

		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		
		TextOutputFormat.setOutputPath(job, new Path(args[2]));
		
		return job.waitForCompletion(true) ? 0 : 1;
	}
	

	public static void main(String[] args) throws Exception {
		System.exit(ToolRunner.run(new DataCleaning(), args));
	}

}
