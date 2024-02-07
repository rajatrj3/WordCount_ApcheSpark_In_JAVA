In Apache Spark, transformations and actions are two main types of operations that can be applied to RDDs (Resilient Distributed Datasets) or DataFrames. Transformations are operations that create a new RDD or DataFrame from an existing one, while actions are operations that return a value to the driver program or write data to an external storage system. Here's a list of some common transformations and actions along with their purposes:

### Transformations:

1. **map(func):**
   - **Purpose:** Applies a function to each element of the RDD/DataFrame.
   - **Example:** `rdd.map(x => x * 2)`

2. **filter(func):**
   - **Purpose:** Returns a new RDD/DataFrame with elements that satisfy the specified condition.
   - **Example:** `rdd.filter(x => x > 0)`

3. **flatMap(func):**
   - **Purpose:** Similar to `map`, but each input item can be mapped to zero or more output items.
   - **Example:** `rdd.flatMap(x => List(x, x * 2))`

4. **union(otherRDD):**
   - **Purpose:** Returns a new RDD/DataFrame containing the elements of both the original and the specified RDD/DataFrame.
   - **Example:** `rdd1.union(rdd2)`

5. **distinct():**
   - **Purpose:** Returns a new RDD/DataFrame with distinct elements.
   - **Example:** `rdd.distinct()`

6. **groupByKey():**
   - **Purpose:** Groups the elements of the RDD/DataFrame by key.
   - **Example:** `pairRDD.groupByKey()`

7. **reduceByKey(func):**
   - **Purpose:** Similar to `groupByKey`, but reduces the values for each key using the specified function.
   - **Example:** `pairRDD.reduceByKey((x, y) => x + y)`

8. **sortByKey():**
   - **Purpose:** Sorts the elements of an RDD/DataFrame based on the key.
   - **Example:** `pairRDD.sortByKey()`

9. **join(otherRDD):**
   - **Purpose:** Performs an inner join between two RDDs/DataFrames based on their keys.
   - **Example:** `pairRDD1.join(pairRDD2)`

10. **coalesce(numPartitions):**
    - **Purpose:** Decreases the number of partitions in the RDD/DataFrame.
    - **Example:** `rdd.coalesce(2)`

### Actions:

1. **collect():**
   - **Purpose:** Returns all the elements of the RDD/DataFrame as an array to the driver program.
   - **Example:** `rdd.collect()`

2. **count():**
   - **Purpose:** Returns the number of elements in the RDD/DataFrame.
   - **Example:** `rdd.count()`

3. **first():**
   - **Purpose:** Returns the first element of the RDD/DataFrame.
   - **Example:** `rdd.first()`

4. **take(n):**
   - **Purpose:** Returns the first n elements of the RDD/DataFrame.
   - **Example:** `rdd.take(5)`

5. **reduce(func):**
   - **Purpose:** Aggregates the elements of the RDD/DataFrame using the specified function.
   - **Example:** `rdd.reduce((x, y) => x + y)`

6. **foreach(func):**
   - **Purpose:** Applies a function to each element of the RDD/DataFrame (useful for side effects).
   - **Example:** `rdd.foreach(x => println(x))`

7. **saveAsTextFile(path):**
   - **Purpose:** Saves the RDD/DataFrame as a text file in the specified path.
   - **Example:** `rdd.saveAsTextFile("/path/to/output")`

8. **countByKey():**
   - **Purpose:** Counts the occurrences of each key in an RDD of key-value pairs.
   - **Example:** `pairRDD.countByKey()`

9. **foreachPartition(func):**
   - **Purpose:** Applies a function to each partition of the RDD/DataFrame.
   - **Example:** `rdd.foreachPartition(iter => iter.foreach(x => println(x)))`

These are just a few examples, and Apache Spark provides many more transformations and actions for various use cases. It's essential to choose the right operation based on your specific requirements and the nature of your data.
