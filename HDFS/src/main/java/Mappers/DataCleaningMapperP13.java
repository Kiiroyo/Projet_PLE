package Mappers;

import Tools.*;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DataCleaningMapperP13 extends Mapper<LongWritable, Text, Text, CapteurWritable> {

    // ID - Category - Horodate - vers bibliothèque - vers carrefour à feux Av.Roul
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        if (key.get() == 0L) return;

        String[] data = value.toString().split(",");

        NormalizedDate date = new NormalizedDate(data[2]);

        boolean in = data[3].equals("x");

        // <capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
        context.write(new Text("P13"), new CapteurWritable("P13",date,data[1], 0.0,in));

    }
}