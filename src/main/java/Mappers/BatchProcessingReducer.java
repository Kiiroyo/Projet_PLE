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

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.TreeSet;

//<capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
public class BatchProcessingReducer extends Reducer<Text, Text, IntWritable, Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, IntWritable, Text>.Context context) throws IOException, InterruptedException {
        
        for (Text value : values){
            String[] data = value.toString().split(","); 
        }
    }

}
