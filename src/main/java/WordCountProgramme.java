import org.apache.hadoop.classification.InterfaceAudience.Public;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
import java.util.Arrays;
public class WordCountProgramme {

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("Word Counter");
		 
		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
		//String inputText = "Hello world, this is a sample text for word count using Spark.";
		
		
		// Create an RDD from the input file
		JavaRDD<String> inputRDD = sparkContext.textFile("C:\\input.txt");
		
		// Split the text into words
		JavaRDD<String> wordsRDD = inputRDD.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
		
		// Map each word to a key-value pair with count 1
		JavaPairRDD<String, Integer> wordCountPairs = wordsRDD.mapToPair(word -> new Tuple2<>(word, 1));
		
		//// Reduce by key to get word count
        JavaPairRDD<String, Integer> wordCounts = wordCountPairs.reduceByKey((count1, count2) -> count1 + count2);
		
        // Print the word counts
		 wordCounts.foreach(wordCount -> System.out.println(wordCount._1() + ": " + wordCount._2()));
		// wordCounts.saveAsTextFile("C:\\Users\\HP\\OneDrive\\Desktop\\Java\\1\\word-count-output\result.txt");
		
		
		
		
		
         sparkContext.stop();
			
		}

	}


