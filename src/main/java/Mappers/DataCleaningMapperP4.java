package Mappers;

import Tools.NormalizedDate;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//SENS,JOUR,HEURE/MINUTE,SECONDE/CENTIEME,VITESSE,SER,TYPE
public class DataCleaningMapperP4 extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context ) throws IOException, InterruptedException {

        if(key.get() == 0L) return;
        String[] data = value.toString().split(",");

        NormalizedDate date = new NormalizedDate( data[1], data[2]);


        boolean in = data[0].equals("2");


        context.write(new Text("P4"), new Text(date.getDate() + "," + date.getHours() + "," + date.getMinutes() + "," + data[6] + "," + in + "," + ""));
    }
}
