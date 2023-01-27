package Mappers;

import org.apache.hadoop.conf.Configuration;
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
import org.apache.log4j.Logger;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


//<capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
public class BatchProcessingMapper extends Mapper<Text, NullWritable, Text, Text> {

    @Override
    protected void map(Text key, NullWritable value, Mapper<Text, NullWritable, Text, Text>.Context context) throws IOException, InterruptedException {
        String[] data = key.toString().split(",");
        context.write(new Text(data[0]), new Text(key.toString()));
    }

    
}
