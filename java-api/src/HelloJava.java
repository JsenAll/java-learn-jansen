import org.junit.Test;

import java.text.Format;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class HelloJava {
    private static Logger logger = Logger.getLogger(String.valueOf(HelloJava.class));

    public static void main(String[] args) {

        String name = "盖伦";
        int kill = 8;
        String title = "超神";

        //直接使用+进行字符串连接，编码感觉会比较繁琐，并且维护性差,易读性差
        String sentence = name + " 在进行了连续 " + kill + " 次击杀后，获得了 " + title + " 的称号";

        System.out.println(sentence);

        //使用格式化输出
        //%s表示字符串，%d表示数字,%n表示换行
        String sentenceFormat = "%s 在进行了连续 %d 次击杀后，获得了 %s 的称号%n";

        System.out.printf(sentenceFormat, name, kill, title);


    }

    /**
     *
     */
    @Test
    public void TestString(){
        String str1 = "the light";

        String start = "the";
        String end = "Ight";

        System.out.println(str1.startsWith(start));//以...开始
        System.out.println(str1.endsWith(end));//以...结束
    }
    /**
     *
     * 追加 删除 插入 反转
     * append追加
     *   delete 删除
     *   insert 插入
     *  reverse 反转
     */
    @Test
    public void TestString1(){
        String str1 = "let there ";

        StringBuffer sb = new StringBuffer(str1); //根据str1创建一个StringBuffer对象
        sb.append("be light"); //在最后追加

        System.out.println(sb);

        sb.delete(4, 10);//删除4-10之间的字符

        System.out.println(sb);

        sb.insert(4, "there ");//在4这个位置插入 there

        System.out.println(sb);

        sb.reverse(); //反转

        System.out.println(sb);
    }
}
