package com.youku.tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
//        String filePath = "/Users/zhangke/work/caixin/project/xpleaf/storm-statistic/src/main/resources/redis.properties";
//        FileInputStream file = new FileInputStream(new File(filePath));
//        BufferedReader br = new BufferedReader(new InputStreamReader(file,"UTF-8"));
//        String line = null;
//        List<String> list = new ArrayList<String>();
//        while((line = br.readLine()) != null) {
////            list.add(line);
//            System.out.println(line);
//        }

        String curDir =System.getProperty("user.dir");
        String fileListPath = curDir.concat("/src/main/resources/fileList.txt");
        //String resPath = this.getClass().getResource("/fileList.txt").getPath();
        List<String> pathList = getPerlineFileName(fileListPath);
        for(String path : pathList) {
            readContentAndSaveWithEncoding(path,"UTF-8","UTF-8");
        }
        System.out.println("成功");
    }

    private static void readContentAndSaveWithEncoding(String filePath, String readEncoding, String saveEncoding) throws
        Exception {
        saveContent(filePath,readContent(filePath,readEncoding),saveEncoding);
    }

    private static void saveContent(String filePath, String content, String encoding) throws Exception {
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter w = new OutputStreamWriter(fos,encoding);
        w.write(content);
        w.flush();
    }

    private static String readContent(String filePath, String encoding) throws Exception {
        FileInputStream file = new FileInputStream(new File(filePath));
        BufferedReader br = new BufferedReader(new UnicodeReader(file, encoding));
        String line = null;
        String fileContent = "";
        while((line = br.readLine()) != null) {
            fileContent = fileContent + line;
            fileContent += "\r\n";
        }
        return fileContent;
    }

    private static List<String> getPerlineFileName(String filePath) throws Exception {
        FileInputStream file = new FileInputStream(new File(filePath));
        BufferedReader br = new BufferedReader(new InputStreamReader(file,"UTF-8"));
        String line = null;
        List<String> list = new ArrayList<String>();
        while((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }
}


