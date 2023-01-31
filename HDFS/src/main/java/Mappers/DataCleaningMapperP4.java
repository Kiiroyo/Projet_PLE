package Mappers;

import Tools.*;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//SENS,JOUR,HEURE/MINUTE,SECONDE/CENTIEME,VITESSE,SER,TYPE
public class DataCleaningMapperP4 extends Mapper<LongWritable, Text, Text, CapteurWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context ) throws IOException, InterruptedException {

        if(key.get() == 0L) return;
        String[] data = value.toString().split(",");

        NormalizedDate date = new NormalizedDate( data[1], data[2]);


        boolean in = data[0].equals("2");

        // <capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
        context.write(new Text("P4"), new CapteurWritable("P4",date,data[6],Double.parseDouble(data[4]),in));
    }
}
