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

import Mappers.BatchProcessingMapper;
import Mappers.BatchProcessingReducer;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.TreeSet;

public class BatchProcessing extends Configured implements Tool {
	
	
	public int run(String[] args) throws Exception {
		Configuration conf = new Configuration();

        Job job = Job.getInstance(conf, "TD2-nhubner-topk");
        job.setNumReduceTasks(1);
        job.setJarByClass(BatchProcessing.class);

        job.setMapperClass(BatchProcessingMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setReducerClass(BatchProcessingReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
        return 0;
	}
	

	public static void main(String[] args) throws Exception {
		System.exit(ToolRunner.run(new DataCleaning(), args));
	}

}
