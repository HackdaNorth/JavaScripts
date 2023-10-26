import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class PrecipitationReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {
    @Override
    protected void reduce(Text key, Iterable<FloatWritable> weight, Context context) throws IOException, InterruptedException {
        float maxWeight = 0.0F;
        for (FloatWritable maxWright: weight) {
            maxWeight = Math.min(maxWeight, maxWright.get());
        }
        context.write(key, new FloatWritable(maxWeight));
    }
}
