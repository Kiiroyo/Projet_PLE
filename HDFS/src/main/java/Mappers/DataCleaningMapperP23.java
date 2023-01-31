package Mappers;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import Tools.*;


//Jour,Heure,Seconde,Centième,Vitesse,Type Véhicule,Catégorie,Inter-essieux,E2/E3,E3/E4,E4/E5,E5/E6

// TODO : destination des véhicules dans le titre du fichier..
// TODO identique à P26

public class DataCleaningMapperP23 extends Mapper<LongWritable, Text, Text, CapteurWritable>{
		
		@Override
		public void map(LongWritable key, Text value, Context context ) throws IOException, InterruptedException {
			// on retire la premiere ligne (le header)
            if(key.get() == 0L) return;
			String[] data = value.toString().split(",");

            NormalizedDate date = new NormalizedDate( data[0], data[1]);
			
			//TODO : seulement des entrées dans la fac ??
			boolean in = true;
			
            // <capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
			context.write(new Text("P23"), new CapteurWritable("P23",date,data[5],Double.parseDouble(data[4]),in));
		}
}

