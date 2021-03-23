package Code.IO流;

import java.io.*;

/**
 * @author wangyu
 * @created 2020/12/28 3:19 下午
 */
public class IO {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("/Users/didi/Desktop/test.txt"));

        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/didi/Desktop/test1.txt"));

        String line = null;
        while((line = br.readLine()) != null) {
            line = line.replaceAll("trip", "四轮车");
            line = line.replaceAll("hy", "货运");
            line = line.replaceAll("htm", "两轮车");
            bw.newLine();
            bw.write(line);
        }
        bw.flush();
        bw.close();
    }

}
