package bigdata.saving;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptor;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.spark.api.java.function.ForeachFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class Saving {
    private final static byte[] TABLE_NAME = Bytes.toBytes("ahabachi:table");

    public static void createOrOverwrite(Admin admin, TableDescriptor table) throws IOException {

        if (admin.tableExists(table.getTableName())) {
            admin.disableTable(table.getTableName());
            admin.deleteTable(table.getTableName());
        }
        admin.createTable(table);
    }

    public static void createTable(Connection connect) {
        try {
            final Admin admin = connect.getAdmin()
            TableName tableName = TableName.valueOf(TABLE_NAME);

            ArrayList<ColumnFamilyDescriptor> columnFamilyDescriptors = new ArrayList<>();
            columnFamilyDescriptors.add(ColumnFamilyDescriptorBuilder.of("temps"));
            columnFamilyDescriptors.add(ColumnFamilyDescriptorBuilder.of("circulation"));
            TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(tableName).setColumnFamilies(columnFamilyDescriptors)
                    .build();

            createOrOverwrite(admin, tableDescriptor);
            admin.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public int save(Dataset<Row> data, Configuration config) throws IOException {
        data.show();
        Connection connection = ConnectionFactory.createConnection(config);
        createTable(connection);
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));

        List<Row> arrayList= new ArrayList<>();
        arrayList = data.collectAsList();

        for (Row row : arrayList)
            Put put = new Put(Bytes.toBytes("" + row.getString(0) + row.getString(1)));
            put.addColumn(Bytes.toBytes("temps"), Bytes.toBytes("date"), Bytes.toBytes(row.getString(0)));
            put.addColumn(Bytes.toBytes("temps"), Bytes.toBytes("heure"), Bytes.toBytes(row.getString(1)));
            put.addColumn(Bytes.toBytes("circulation"), Bytes.toBytes("count"), Bytes.toBytes(Long.toString(row.getLong(2))));
            table.put(put);
        }
        return 0;
    }

}
