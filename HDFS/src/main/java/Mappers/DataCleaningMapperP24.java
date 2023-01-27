package Mappers;

import Tools.NormalizedDate;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

// Jour,Heure,Seconde,Centième,Vitesse,Type Véhicule,Catégorie,Inter-essieux,E2/E3,E3/E4,E4/E5,E5/E6
public class DataCleaningMapperP24 extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context ) throws IOException, InterruptedException {

        if(key.get() == 0L) return;
        String[] data = value.toString().split(",");

        NormalizedDate date = new NormalizedDate( data[0], data[1]);


        // TODO : Savoir le sens : in ..
        boolean in = true;

        // <capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
        context.write(new Text("P24"), new Text(date.getDate() + "," + date.getHours() + "," + date.getMinutes() + "," + data[6] + "," + in + "," + data[4]));

    }
}