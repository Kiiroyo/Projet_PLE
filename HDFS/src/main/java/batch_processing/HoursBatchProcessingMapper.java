package batch_processing;

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

import Tools.*;




//<capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
public class HoursBatchProcessingMapper extends Mapper<Text, CapteurWritable, Text, DataStatistiques> {

    @Override
    protected void map(Text key, CapteurWritable capteur, Mapper<Text, CapteurWritable, Text, DataStatistiques>.Context context) throws IOException, InterruptedException {
        DataStatistiques stats = new DataStatistiques();
        stats.addData(capteur);
        
        context.write(new Text(capteur.getCapteurID() + "," + capteur.getDate() + "," + capteur.getHours()), stats);
    }

    
}