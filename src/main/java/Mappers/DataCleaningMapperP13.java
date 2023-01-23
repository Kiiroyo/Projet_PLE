package Mappers;

import Tools.NormalizedDate;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DataCleaningMapperP13 extends Mapper<LongWritable, Text, Text, Text> {

    // ID - Category - Horodate - vers bibliothèque - vers carrefour à feux Av.Roul
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        if (key.get() == 0L) return;

        String[] data = value.toString().split(",");

        NormalizedDate date = new NormalizedDate(data[2]);

        boolean in = data[3].equals("x");

        String destination;
        if (in) {
            destination = "Vers bibliothèque";
        } else {
            destination = "vers carrefour à feux Av. Roul ";
        }

        context.write(new Text("P13"), new Text(date.getDate() + "," + date.getHours() + "," + date.getMinutes() + "," + data[1] + "," + in + "," + destination));

    }
}