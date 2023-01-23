package Mappers;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import Tools.NormalizedDate;


//ID,Cat�gorie,Horodate,d�tection de d�part,d�tection de sortie,REMARQUE

/** Si départ E, sortie S1 ou S3 : entre dans la fac
* Si départ E, sortie S2 : passe à côté de la fac

* Si départ S1, sortie S2 ou E : sort de la fac
* Si départ S1, sortie S3 : déplace dans la fac 

* Si départ S2, sorite S1 ou S3 : entre dans la fac
* Si départ S2, sortie E : passe à côté de la fac

* Si départ S3, sortie S2 ou E : sort de la fac
* Si départ S3, sortie S1 : déplace dans la fac
*/

public class DataCleaningMapperP20 extends Mapper<LongWritable, Text, Text, Text>{
		
		@Override
		public void map(LongWritable key, Text value, Context context ) throws IOException, InterruptedException {
			// on retire la premiere ligne (le header)
            if(key.get() == 0L) return;
			String[] data = value.toString().split(",");
			
			NormalizedDate date = new NormalizedDate(data[2]);
			
            //TODO Important : in or out du coup ????
			boolean in = data[3].equals("1");
			
            // <capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, destination)>
			context.write(new Text("P120"), new Text(date.getDate() + "," + date.getHours() + "," + date.getMinutes() + "," + data[1] + "," + in + "," + ""));
		}
}
