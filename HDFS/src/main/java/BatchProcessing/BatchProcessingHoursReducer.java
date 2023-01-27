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

import Tools.CapteurWritable;
import Tools.DataStatistiques;
import Tools.Summary;

//<capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
public class BatchProcessingHoursReducer extends Reducer<IntWritable, CapteurWritable, IntWritable, CapteurWritable> {

    @Override
    protected void reduce(IntWritable key, Iterable<CapteurWritable> values, Reducer<IntWritable, CapteurWritable, IntWritable, CapteurWritable>.Context context) throws IOException, InterruptedException {
        DataStatistiques statistics = new DataStatistiques();
        for (CapteurWritable capteur : values){
            statistics.addData(capteur);
            
            // TODO pas certaitn qu'il faille faire un write vu qu'on enregistre dans HBase
            //context.write(new IntWritable(capteur.getMonth()), capteur); 
        }
        Summary summary = statistics.computeSummary();

        //TODO : enregistrer dans Hbase 

        
    }

}
