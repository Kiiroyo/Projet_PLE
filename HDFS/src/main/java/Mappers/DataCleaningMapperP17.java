package Mappers;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import Tools.*;


//SENS,JOUR,HEURE/MINUTE,SECONDE/CENTIEME,VITESSE,SER,TYPE
//sens 1 = sortie fac
//sens 2 = entrée fac

// TODO : destination des véhicules dans le titre du fichier..

public class DataCleaningMapperP17 extends Mapper<LongWritable, Text, Text, CapteurWritable>{
		
		@Override
		public void map(LongWritable key, Text value, Context context ) throws IOException, InterruptedException {
			// on retire la premiere ligne (le header)
            if(key.get() == 0L) return;
			String[] data = value.toString().split(",");

            NormalizedDate date = new NormalizedDate( data[1], data[2]);
			
			
			boolean in = data[0].equals("2");
			
            // <capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
			context.write(new Text("P17"), new CapteurWritable("P17",date,data[6],Double.parseDouble(data[4]),in));
		}
}

