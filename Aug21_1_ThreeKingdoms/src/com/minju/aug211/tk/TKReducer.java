package com.minju.aug211.tk;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

// Combine : 자동으로 처리되는 단계
// Combine으로 들어올 때 ( = Mapper에서 나갈 때)
// 유비 1
// 조조 1
// 손권 1
//	...
/////////////////////////
// Reduce쪽으로 들어올 때 ( = Combine에서 나갈 때)
// 유비 <1, 1, 1>
// 조조 <1, 1>
// 손권 <1>
//////////////////////////
// Reduce에서 나갈 때
// 유비 3
// 조조 2
// 손권 1

public class TKReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	private static final IntWritable SUM = new IntWritable();
	
	@Override
	protected void reduce(Text arg0, 
			Iterable<IntWritable> arg1,
			Reducer<Text, IntWritable, Text, IntWritable>.Context arg2)
					throws IOException, InterruptedException {
		int sum = 0;
		
		for (IntWritable i : arg1) {
			sum += i.get();
		}
		
		SUM.set(sum);
		arg2.write(arg0, SUM);
	}
}
