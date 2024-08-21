package com.minju.aug211.tk;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// IN
//		Key : 모름...
//		Value : 유비는 술을 마신다
//				장비는 술을 좋아한다
//				...
// OUT
//		유비 1
//////////////////////////////

public class TKMapper extends Mapper<Object, Text, Text, IntWritable> {
	
	private static final Text WORD = new Text();
	private static final IntWritable ONE = new IntWritable(1);
	
	@Override
	protected void map(Object key, 
			Text value, 
			Mapper<Object, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		String[] words = value.toString().split(" ");
		
		for (String word : words) {
			if (word.contains("유비") || word.contains("현덕")) {
				WORD.set("유비(현덕)");
			} else if (word.contains("조조") || word.contains("맹덕")) {
				WORD.set("조조(맹덕)");
			} else if (word.contains("손권") || word.contains("중모")) {
				WORD.set("손권(중모)");
			} else continue;
			context.write(WORD, ONE);
		}
	}
}
