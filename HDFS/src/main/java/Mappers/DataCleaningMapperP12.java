package Mappers;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import Tools.NormalizedDate;


//ID,Catégorie,horodate,Entrant,Sortant

public class DataCleaningMapperP12 extends Mapper<LongWritable, Text, Text, Text>{
		
		@Override
		public void map(LongWritable key, Text value, Context context ) throws IOException, InterruptedException {
			// on retire la premiere ligne (le header)
            if(key.get() == 0L) return;
			String[] data = value.toString().split(",");
			
			NormalizedDate date = new NormalizedDate(data[2]);
			
			boolean in = data[3].equals("1");
			
            // <capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
			context.write(new Text("P12"), new Text(date.getDate() + "," + date.getHours() + "," + date.getMinutes() + "," + data[1] + "," + in + "," + ""));
		}
}
