package tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
* @Description:    类作用描述:  txt文件写入 例子
* @Author:         JHS
* @CreateDate:     2019/6/25 16:57
* @UpdateDate:     2019/6/25 16:57
* @UpdateRemark:   修改内容
*/
public class Txtfile {
    public static void createFile(String filePath1, String fileName, StringBuffer stringBuffer) throws IOException {
        String filePath = filePath1;
        File dir = new File(filePath);
        // 一、检查放置文件的文件夹路径是否存在，不存在则创建
        if (!dir.exists()) {
            dir.mkdirs();// mkdirs创建多级目录
        }
        File checkFile = new File(filePath + "/" + fileName + ".txt");
        FileWriter writer = null;
        try {
            // 二、检查目标文件是否存在，不存在则创建
            if (!checkFile.exists()) {
                checkFile.createNewFile();// 创建目标文件
            }
            // 三、向目标文件中写入内容
            // FileWriter(File file, boolean append)，append为true时为追加模式，false或缺省则为覆盖模式
            writer = new FileWriter(checkFile, true);
            writer.append(stringBuffer);
            writer.flush();
            System.out.println("写入成功！！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer)
                writer.close();
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("青春不负美好时光" + "\r\n");
        stringBuffer.append("我在这里与你共同分享" + "\t" + "we let is go!!");
//        ForFile.createFile("D:/Filetest/filename", "data", stringBuffer);
        Txtfile.createFile("D:/Filetest/fileOK", "data25", stringBuffer);
    }

}
