package Jobs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;


import org.apache.hadoop.hbase.HBaseConfiguration;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.TreeSet;

import Tools.*;

import batch_processing.*;

public class BatchProcessingHours extends Configured implements Tool {
	
	
	public int run(String[] args) throws Exception {
		Configuration conf = new Configuration();
        conf.set("mapred.textoutputformat.separator", ",");

        Job job = Job.getInstance(conf, "BatchProcessing");
        job.setNumReduceTasks(1);
        job.setJarByClass(BatchProcessingHours.class);

        job.setMapperClass(HoursBatchProcessingMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(DataStatistiques.class);

        //combiner ?

        job.setReducerClass(ReduceCapteur.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);


        FileInputFormat.setInputDirRecursive(job, true);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1] + "/hourly"));

        long startTime = System.currentTimeMillis();
        boolean result = job.waitForCompletion(true);
        long endTime = System.currentTimeMillis();

        System.out.println("Durée hourly : " + (endTime - startTime) + "ms");
		
		return result ? 0 : 1;
	}
	

	public static void main(String[] args) throws Exception {
		ToolRunner.run(new BatchProcessingHours(), args);
	}

}
