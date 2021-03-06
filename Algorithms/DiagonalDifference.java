package algorithmsJava;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class DiagonalDifference {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = Integer.parseInt(bufferedReader.readLine().trim());

	        List<List<Integer>> arr = new ArrayList<>();

	        IntStream.range(0, n).forEach(i -> {
	            try {
	                arr.add(
	                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	                        .map(Integer::parseInt)
	                        .collect(toList())
	                );
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        int result = Result.diagonalDifference(arr);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	}
	static class Result {

	    
	    public static int diagonalDifference(List<List<Integer>> arr) 
	    {
	        
	    int leftdiagonal = 0, rightdiagonal = 0;
	    for(int i = 0, j = arr.get(0).size()-1; i < arr.get(0).size(); i++, j--){
	            leftdiagonal = leftdiagonal + arr.get(i).get(i);
	            rightdiagonal = rightdiagonal + arr.get(i).get(j);
	        }
	        return Math.abs(leftdiagonal - rightdiagonal);
	    }
	    }
}
