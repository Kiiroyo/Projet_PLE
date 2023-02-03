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

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Tools.CapteurWritable;
import Tools.DataStatistiques;
import Tools.Summary;

//<capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
public class ReduceByCapteurAndDay extends Reducer<Text, CapteurWritable, Text, CapteurWritable> {

    @Override
    protected void reduce(Text key, Iterable<CapteurWritable> values, Reducer<Text, CapteurWritable, Text, CapteurWritable>.Context context) throws IOException, InterruptedException {
        DataStatistiques dayStatistics = new DataStatistiques();
        
        //intialisation
        List<DataStatistiques> hours = new ArrayList<DataStatistiques>();
        for (int i = 0 ; i < 24 ; ++i){
            hours.add(i, new DataStatistiques());
        }

        for (CapteurWritable capteur : values){
            dayStatistics.addData(capteur);
            hours.get(capteur.getHours()).addData(capteur);
            
            context.write(key, capteur); 
        }

        Summary summary = dayStatistics.computeSummary();
        List<Summary> hoursSummary = new ArrayList<Summary>();
        for (int i = 0 ; i < 24 ; ++i){
            hoursSummary.add(i, hours.get(i).computeSummary());
        }

        //TODO : enregistrer dans Hbase 

        
    }

}