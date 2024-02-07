import org.apache.hadoop.classification.InterfaceAudience.Public;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
import java.util.Arrays;
public class NewDF{

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

        // Reduce by key to get word count
        JavaPairRDD<String, Integer> wordCounts = wordCountPairs.reduceByKey((count1, count2) -> count1 + count2);

        // Convert JavaPairRDD to DataFrame
        SparkSession spark = SparkSession.builder().config(sparkConf).getOrCreate();
        Dataset<Row> wordCountsDF = spark.createDataFrame(wordCounts.map(tuple -> RowFactory.create(tuple._1(), tuple._2())), getSchema());

        // Show the DataFrame
        wordCountsDF.show();
        

        // Stop the Spark context
        sparkContext.stop();
    }

    private static org.apache.spark.sql.types.StructType getSchema() {
        return new org.apache.spark.sql.types.StructType()
                .add("word", org.apache.spark.sql.types.DataTypes.StringType)
                .add("count", org.apache.spark.sql.types.DataTypes.IntegerType);

		
				
        
			

	}

}
