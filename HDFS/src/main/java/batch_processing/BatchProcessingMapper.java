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

import Tools.CapteurWritable;




//<capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
public class BatchProcessingMapper extends Mapper<Text, NullWritable, IntWritable, CapteurWritable> {

    @Override
    protected void map(Text key, NullWritable value, Mapper<Text, NullWritable, IntWritable, CapteurWritable>.Context context) throws IOException, InterruptedException {
        String[] data = key.toString().split(",");
        double speed;
        if (data[6].length() < 1) speed = 0.0; else speed = Double.parseDouble(data[6]);
        String[] date = data[1].split("/");
        CapteurWritable capteur = new CapteurWritable(data[0], Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]), Integer.parseInt(data[2]), Double.parseDouble(data[3]), data[4],speed, Boolean.parseBoolean(data[5]));

        // <Année , capteurData>
        context.write(new IntWritable(capteur.getYear()), capteur);
    }

    
}
