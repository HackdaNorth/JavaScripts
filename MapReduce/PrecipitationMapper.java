import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class PrecipitationMapper
        extends Mapper<LongWritable, Text, Text, FloatWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String[] values = value.toString().split(",");
        float prodWeight;
        String prodCategory;
        try {
            prodWeight = Float.parseFloat(values[1].substring(0,5));
            prodCategory =  values[3].substring(0,6);
        }
        catch (Exception e){
            prodWeight = 0.0F;
            prodCategory = "NULL";
        }
        context.write(new Text(prodCategory), new FloatWritable(prodWeight));
    }
}
