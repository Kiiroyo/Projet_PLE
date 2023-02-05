package batch_processing;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Tools.CapteurWritable;
import Tools.DataStatistiques;
import Tools.Summary;

//<capteur, (jour, heures, minutes, catégorie, entre sur la fac ?, vitesse)>
public class ReduceByCapteurAndDay extends Reducer<Text, CapteurWritable, Text, CapteurWritable> {



    private  String TABLE_Hour_Sumary = "ahabachi:HourSummary";
    private  String TABLE_Day_Sumary  = "ahabachi:DaySummary";

    @Override
    protected void reduce(Text key, Iterable<CapteurWritable> values, Reducer<Text, CapteurWritable, Text, CapteurWritable>.Context context) throws IOException, InterruptedException {
        DataStatistiques dayStatistics = new DataStatistiques();
        
        //intialisation
        List<DataStatistiques> hours = new ArrayList<DataStatistiques>();
        for (int i = 0 ; i < 24 ; ++i){
            hours.add(i, new DataStatistiques());
        }

        for (CapteurWritable capteur : values){

            dayStatistics.addData(capteur);
            hours.get(capteur.getHours()).addData(capteur);
            context.write(key, capteur); 
        }

        Summary summary = dayStatistics.computeSummary();
        Put put = new Put(key.toString().getBytes());
        put.addColumn(Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes(summary.getTotalIn()));
        put.addColumn(Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes(summary.getTotalOut()));
        put.addColumn(Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes(summary.getAverageMotos()));
        put.addColumn(Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes(summary.getAverageSpeed()));
        put.addColumn(Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes(summary.getAverageBus()));
        put.addColumn(Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes(summary.getAveragePL()));
        put.addColumn(Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes(summary.getAverageVL()));
        put.addColumn(Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes("TABLE_Day_Sumary"), Bytes.toBytes(capteur.get(i).getCapteurID()));

        List<Summary> hoursSummary = new ArrayList<Summary>();
        for (int i = 0 ; i < 24 ; ++i){
            hoursSummary.add(i, hours.get(i).computeSummary());
            Put put = new Put(key.toString().getBytes());

            put.addColumn(Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes(hoursSummary.get(i).getTotalIn()));
            put.addColumn(Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes(hoursSummary.get(i).getTotalOut()));
            put.addColumn(Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes(hoursSummary.get(i).getAverageMotos()));
            put.addColumn(Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes(hoursSummary.get(i).getAverageSpeed()));
            put.addColumn(Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes(hoursSummary.get(i).getAverageBus()));
            put.addColumn(Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes(hoursSummary.get(i).getAveragePL()));
            put.addColumn(Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes(hoursSummary.get(i).getAverageVL()));
            put.addColumn(Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes("TABLE_Hour_Sumary"), Bytes.toBytes(capteur.get(i).getCapteurID()));
        }
    }
    public  void createTable(Connection connect,String TABLE,String columnDesc) {
        try {
            final Admin admin = connect.getAdmin();
            TableDescriptorBuilder tableDescriptorBuilder = TableDescriptorBuilder.newBuilder(TableName.valueOf(TABLE));
            ColumnFamilyDescriptor columnFamilyDescriptor = ColumnFamilyDescriptorBuilder.newBuilder(columnDesc.getBytes()).build();
            tableDescriptorBuilder.setColumnFamily(columnFamilyDescriptor);
            TableDescriptor tableDescriptor = tableDescriptorBuilder.build();
            if (!admin.tableExists(TableName.valueOf(TABLE))) {
                admin.createTable(tableDescriptor);
            }
            admin.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }










}




