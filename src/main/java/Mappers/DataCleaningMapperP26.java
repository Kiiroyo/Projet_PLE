package Mappers;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import Tools.NormalizedDate;


//Jour,Heure,Seconde,Centième,Vitesse,Type Véhicule,Catégorie,Inter-essieux,E2/E3,E3/E4,E4/E5,E5/E6

// TODO : destination des véhicules dans le titre du fichier..
//TODO identique à P23 !

public class DataCleaningMapperP26 extends Mapper<LongWritable, Text, Text, Text>{
		
		@Override
		public void map(LongWritable key, Text value, Context context ) throws IOException, InterruptedException {
			// on retire la premiere ligne (le header)
            if(key.get() == 0L) return;
			String[] data = value.toString().split(",");

            NormalizedDate date = new NormalizedDate( data[0], data[1]);
			

			boolean in = true;
			
            // <capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
			context.write(new Text("P26"), new Text(date.getDate() + "," + date.getHours() + "," + date.getMinutes() + "," + data[5] + "," + in + "," + ""));
		}
}

