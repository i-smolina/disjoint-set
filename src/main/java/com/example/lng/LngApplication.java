package com.example.lng;

import com.example.lng.algo.LinkList;
import com.example.lng.algo.Parser;
import com.example.lng.file.FileReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class LngApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(LngApplication.class, args);

		FileReader reader = new FileReader();
		List<String> lines = reader.readFile("/home/irina/prog/newjob/lng.txt");

		int maxSize = 0;
		String[] arr;
		LinkList list = new LinkList();
		for (String line : lines) {
			arr = Parser.parse(line);
			if (arr.length > maxSize)
				maxSize = arr.length;
			list.add(arr);
		}

		list.createMatrix(maxSize);
		list.build(list.matrix);

		//list.print();

//		String s ="\"\";\"79076513686\";\"79499289445\";\"79895211259\";\"79970144607\";\"79460148141\";\"79124811542\";\"79660572200\";\"79245307223\";\"79220239511\"";
		String s = "\"\";\"79076513686\";\"79499289445\";\"79895211259\";\"79970144607\";\"79460148141\";\"79124811542\";\"79660572200\";\"79245307223\";\"79220239511\"";
		//Parser.parse(s);

		String line = "\"8383\"200000741652251\"";
//		System.out.println(Parser.isFalse(line));
//		System.out.println(Parser.isFalse(s));
	}

}
