package com.minju.aug212.bus;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BMapper extends Mapper<Object, Text, Text, LongWritable> {
	
	private static final Text YOIL = new Text();
	private static final LongWritable PC = new LongWritable();
	
	@Override
	protected void map(Object key, 
			Text value, 
			Mapper<Object, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		try {
			String[] linedata = value.toString().split(",");
			
			String y = linedata[0];
			int m = Integer.parseInt(linedata[1]);
			int d = Integer.parseInt(linedata[2]);
			
			String ymd = String.format("%s%02d%02d", y, m, d);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date = sdf.parse(ymd);
			sdf = new SimpleDateFormat("E");
			String yoil = sdf.format(date);
			
			long personCount = Long.parseLong(linedata[5]) + Long.parseLong(linedata[6]);
			
			YOIL.set(yoil);
			PC.set(personCount);
			
			context.write(YOIL, PC);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
