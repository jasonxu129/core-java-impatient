package ch2;

/*
1. Download opencsv-5.0.jar and its dependencies commons-lang3-3.9.jar into lib directory

2. Compile:
javac -cp lib/\* ReadCSV.java

(If you have many JAR files, put them all in a directory and use wildcard to include them all)
(In Unix, the * must be escaped to prevent shell expansion)

3. Run:
java -cp .:\* ReadCSV

(The javac compiler always looks for the files in current directory, but the java program only
looks into the current directory if the "." directory is on the class path. If you have no class
path set, this is not a problem - the default class path consists of the "." directory. but if
you have set the class path and forgot to include the "." directory, your programs will compile
without error but won't run.)

*/

import java.util.Map;
// import com.opencsv.CSVReaderHeaderAware;
import java.io.FileReader;

public class Ch2_12 {
    public static void main(String[] args) throws Exception {
        /*
        Map<String, String> values = new CSVReaderHeaderAware(new FileReader("test.csv")).readMap();
        for (Map.Entry entry : values.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", Values: " + entry.getValue());
        }
        */
    }
}
