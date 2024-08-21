package com.minju.aug201.wc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

// Hadoop 작업의 두번째 단계 : Combine
//		는 알아서 처리 됨

// Hadoop 작업 세번째 단계 : Reduce
//		in : sleepy <1, 1, 1>  >> 앞에 두자리
//		out : sleepy 3		   >> 뒤에 두자리
									// 앞의 두자리는 Mapper쪽 뒤의 두자리와 같아야 함
public class WCReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	private static final IntWritable SUM = new IntWritable();
	
	// sleepy <1, 1, 1> 한 세트 만날때마다 호출할 method
	@Override
	protected void reduce(Text arg0, // map단계에서 보내준 key값 : sleepy
			Iterable<IntWritable> arg1, // list비스무리한~ : <1, 1, 1>
			Reducer<Text, IntWritable, Text, IntWritable>.Context arg2) // 결과처리 
					throws IOException, InterruptedException {
		int sum = 0;
		// <1, 1, 1> 합쳐주는 작업
		for (IntWritable i : arg1) {
			// sum은 int, i는 IntWritable => 형 변환을 해줘야...!
			//		=> .get()
			sum += i.get(); // 1 + 1 + 1 = 3
		}
		SUM.set(sum);
		arg2.write(arg0, SUM);
	}
}
