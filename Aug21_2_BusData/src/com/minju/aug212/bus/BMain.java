package com.minju.aug212.bus;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class BMain {
	public static void main(String[] args) {
		try {
			Configuration c = new Configuration();
			
			Job j = Job.getInstance(c);
			
			j.setMapperClass(BMapper.class);
			j.setCombinerClass(BReducer.class);
			j.setReducerClass(BReducer.class);
			
			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(LongWritable.class);
			
			for (int i = 1; i < 4; i++) {
				FileInputFormat.addInputPath(j, new Path(String.format("/bus202%d.csv", i)));
			}
			
			FileOutputFormat.setOutputPath(j, new Path(args[0]));
			
			j.waitForCompletion(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
