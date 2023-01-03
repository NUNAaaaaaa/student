package studentmanagersystem;

import java.io.File;
import  java.io.FileInputStream;
import java.io.FileOutputStream;
import  java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class SaveDataUtils {
    private static String filePath = null;
    static{
        try{
            filePath=new File("").getCanonicalPath()+"/student.txt";       //尝试执行
           } catch(IOException e) {
            e.printStackTrace();                                                    //捕获错误的代码块
           }
        }


        //序列化
        public static void saveObject(Object object) throws Exception {            //throws Exception表示的是本方法不处理异常，交给被调用处处理try...catch
            ObjectOutputStream out = null;                                         //作用：将对象转为二进制码
            FileOutputStream fout = null;                                          //声明低级输出流
            try {
                fout = new FileOutputStream(filePath);                             //filePath是目标文件路径和文件名
                out = new ObjectOutputStream(fout);                                //对接的管道
                out.writeObject(object);                                           //object是对象
            } finally {                                                            //无论怎样都会执行关闭
                fout.close();
                out.close();
            }
        }


        //反序列化
    public static Object readObject() throws Exception {
        ObjectInputStream in =null;                                                 //作用：将对象转为二进制码
        FileInputStream fin =null;
        Object object = null;

        try {
            fin = new FileInputStream(filePath);

            if(fin.getChannel().size() == 0) {                                     //getChannel().size()读取文件大小
                return null;
            }

            in = new ObjectInputStream(fin);
            object = in.readObject();                                              //对接的管道
            return object;                                                         //输出文件数据
        } finally {                                                                //关闭
            if (fin != null) {                                                     //判空，输出完毕才关闭
                fin.close();
            }
            if (in != null) {
                in.close();
            }
        }
    }
}