package Code.Utils;

import java.io.*;

/**
 * @author wangyu
 * @created 2020/12/28 3:19 下午
 */
public class OutPut {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("/Users/didi/Desktop/test.txt"));

        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/didi/Desktop/test1.txt"));

        String line = null;
        while((line = br.readLine()) != null) {
//            line = line.replaceAll("trip", "四轮车");
//            line = line.replaceAll("hy", "货运");
//            line = line.replaceAll("htm", "两轮车");
//            line = line.replaceAll("bus", "公交");
//            line = line.replaceAll("fin_dw", "滴滴金融");
//            line = line.replaceAll("iot", "车载");
//            line = line.replaceAll("navigation", "导航");
//            line = line.replaceAll("energy", "小桔车服-能源");
//            line = line.replaceAll("mta", "小桔车服-维保");
//            line = line.replaceAll("drvsec", "小桔车服-驾驶安全");
//            line = line.replaceAll("insu", "小桔车服-车险");
//            line = line.replaceAll("rent", "小桔车服-租车");
//            line = line.replaceAll("pub", "公共板块");
//            line = line.replaceAll("dj", "代驾");
//            line = line.replaceAll("erd", "跑腿");
            line = line.replaceAll("公交iness_line", "business_line");
            line = line.replaceAll("pa小桔车服-租车", "parent");
//            line = line.replaceAll("`datacenter`.", "");
//            line = line.replaceAll("`id`, ", "");
//            line = line.replaceAll("VALUES \\(, ", "VALUES (");
            bw.newLine();
            bw.write(line);
        }
        bw.flush();
        bw.close();
    }

}
