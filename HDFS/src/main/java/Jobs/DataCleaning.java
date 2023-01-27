package Jobs;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import Mappers.DataCleaningMapperP1;
import Mappers.DataCleaningMapperP10;
import Mappers.DataCleaningMapperP12;
import Mappers.DataCleaningMapperP13;
import Mappers.DataCleaningMapperP17;
import Mappers.DataCleaningMapperP19;
import Mappers.DataCleaningMapperP23;
import Mappers.DataCleaningMapperP24;
import Mappers.DataCleaningMapperP26;
import Mappers.DataCleaningMapperP3;
import Mappers.DataCleaningMapperP4;

public class DataCleaning extends Configured implements Tool {
	
	
	public int run(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Data Cleanning");
		job.setNumReduceTasks(0);
		job.setJarByClass(DataCleaning.class);
		
		MultipleInputs.addInputPath(job, new Path(args[0] + "P1/P1.csv" ), TextInputFormat.class, DataCleaningMapperP1.class);

		MultipleInputs.addInputPath(job, new Path(args[0] + "P10/P10.csv" ), TextInputFormat.class, DataCleaningMapperP10.class);

		MultipleInputs.addInputPath(job, new Path(args[0] + "P12/P12.csv" ), TextInputFormat.class, DataCleaningMapperP12.class);

		MultipleInputs.addInputPath(job, new Path(args[0] + "P13/P13.csv" ), TextInputFormat.class, DataCleaningMapperP13.class);

		MultipleInputs.addInputPath(job, new Path(args[0] + "P17/P17_Vers_Avenue_Schweitzer.csv" ), TextInputFormat.class, DataCleaningMapperP17.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P17/P17_Vers_P16.csv" ), TextInputFormat.class, DataCleaningMapperP17.class);

		MultipleInputs.addInputPath(job, new Path(args[0] + "P19/P19_Entree.csv" ), TextInputFormat.class, DataCleaningMapperP19.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P19/P19_Sortie.csv" ), TextInputFormat.class, DataCleaningMapperP19.class);

		// TODO
		//MultipleInputs.addInputPath(job, new Path(args[0] + "P2/P2_semaine_1.csv" ), TextInputFormat.class, DataCleaningMapperP2.class);
		//MultipleInputs.addInputPath(job, new Path(args[0] + "P2/P2_semaine_2.csv" ), TextInputFormat.class, DataCleaningMapperP2.class);

		MultipleInputs.addInputPath(job, new Path(args[0] + "P23/P23_Vers_BEC_1.csv" ), TextInputFormat.class, DataCleaningMapperP23.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P23/P23_Vers_BEC_2.csv" ), TextInputFormat.class, DataCleaningMapperP23.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P23/P23_Vers_COSEC.csv" ), TextInputFormat.class, DataCleaningMapperP23.class);

		MultipleInputs.addInputPath(job, new Path(args[0] + "P24/P24_Vers_Fac.csv" ), TextInputFormat.class, DataCleaningMapperP24.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P24/P24_Vers_Rocade.csv" ), TextInputFormat.class, DataCleaningMapperP24.class);

		MultipleInputs.addInputPath(job, new Path(args[0] + "P26/P26_Vers_Fac_1.csv" ), TextInputFormat.class, DataCleaningMapperP26.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P26/P26_Vers_Fac_2.csv" ), TextInputFormat.class, DataCleaningMapperP26.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P26/P26_Vers_Fac_3.csv" ), TextInputFormat.class, DataCleaningMapperP26.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P26/P26_Vers_Rocade_1.csv" ), TextInputFormat.class, DataCleaningMapperP26.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P26/P26_Vers_Rocade_2.csv" ), TextInputFormat.class, DataCleaningMapperP26.class);  

		MultipleInputs.addInputPath(job, new Path(args[0] + "P3/Mixtra_Sortie_Fac_1.csv" ), TextInputFormat.class, DataCleaningMapperP3.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P3/Mixtra_Sortie_Fac_2.csv" ), TextInputFormat.class, DataCleaningMapperP3.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P3/Mixtra_Sortie_Fac_3.csv" ), TextInputFormat.class, DataCleaningMapperP3.class);

		MultipleInputs.addInputPath(job, new Path(args[0] + "P4/P4_Sortie_Fac.csv" ), TextInputFormat.class, DataCleaningMapperP4.class);

		//TODO
		//MultipleInputs.addInputPath(job, new Path(args[0] + "P5/P5.csv" ), TextInputFormat.class, DataCleaningMapperP5.class);

		MultipleInputs.addInputPath(job, new Path(args[0] + "P9/P9_Vers_Fac_1.csv" ), TextInputFormat.class, DataCleaningMapperP1.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P9/P9_Vers_Fac_2.csv" ), TextInputFormat.class, DataCleaningMapperP1.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P9/P9_Vers_Talence_1.csv" ), TextInputFormat.class, DataCleaningMapperP1.class);
		MultipleInputs.addInputPath(job, new Path(args[0] + "P9/P9_Vers_Talence_2.csv" ), TextInputFormat.class, DataCleaningMapperP1.class);


		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		
		TextOutputFormat.setOutputPath(job, new Path(args[1]));
		
		return job.waitForCompletion(true) ? 0 : 1;
	}
	

	public static void main(String[] args) throws Exception {
		System.exit(ToolRunner.run(new DataCleaning(), args));
	}

}
