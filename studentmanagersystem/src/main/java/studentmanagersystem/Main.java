package studentmanagersystem;

import com.sun.jmx.snmp.SnmpUnknownAccContrModelException;

import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);//当通过new Scanner(System.in)创建一个Scanner，控制台会一直等待输入，
                                                       // 直到敲回车键结束，把所输入的内容传给Scanner，作为扫描对象。
                                                       // 如果要获取输入的内容，则只需要调用Scanner的nextLine()方法即可

    //private static List<Student> list = new ArrayList<Student>();//LinkList();
    private static List<Student> list = null;                            //创建链表
    public static void main(String[] args) throws Exception{             //主函数
        init();
        createFace();
    }

    //反序列化，读取文本内容
    public static void init() throws Exception{
        if(SaveDataUtils.readObject()!=null){
            list = (ArrayList<Student>)SaveDataUtils.readObject();
        }else{
            list = new ArrayList<Student>();                              //建立新链表
        }
    }

    public static void createFace() throws Exception{
        int select;

        System.out.println("1.添加一条学生数据");
        System.out.println("2.删除一条学生数据");
        System.out.println("3.查找一条学生数据");
        System.out.println("4.修改一条学生数据");
        System.out.println("5.显示学生数据");
        System.out.println("6.按学生成绩排序");
        System.out.println("7.学生数据存档");

        while (true){
            System.out.println("请选择：");
            select = sc.nextInt();
            switch(select){
                case 1:saveStudent(); break;
                case 2:deleteStudent(); break;
                case 3:findStudent(); break;
                case 4:modifyStudent(); break;
                case 5:listStudent(); break;
                case 6:listsort(); break;
                case 7:SaveDataUtils.saveObject(list); break;
                default: System.out.println("请在1-7选择：");
            }
        }
    }

    //添加一条学生数据
    public static void saveStudent(){

        float temp = 0;

        Student student = new Student();                     //建立Student类的student
        System.out.println("请输入学号");
        student.setNum(sc.next());
        System.out.println("请输入姓名");
        student.setName(sc.next());
        System.out.println("请输入java成绩");
        student.setJava(sc.nextInt());
        System.out.println("请输入高数成绩");
        student.setMath(sc.nextInt());
        System.out.println("请输入英语成绩");
        student.setEnglish(sc.nextInt());

        temp += student.getJava();
        temp += student.getMath();
        temp += student.getEnglish();

        student.setAver(temp/3);
        student.setSum(temp);

        list.add(student);
    }

    //删除一条学生数据
    public static void deleteStudent(){
        String num ="";                                      //定义num且不赋值
        Student temp = null;

        System.out.println("请输入学生学号进行删除");
        num = sc.next();

        if((temp=findStudentByInput(num)) == null){           //temp赋值
            System.out.println("查无此学号");
        }else{
            list.remove(temp);                                //remove删除
            System.out.println("删除成功");
        }
    }

    //查找一条学生数据
    public static void findStudent(){
        String num = "";
        Student temp = null;

        System.out.println("请输入学生学号进行查找");
        num = sc.next();

        if((temp=findStudentByInput(num)) == null){
            System.out.println("查无此学号");
        }else{
            System.out.println(temp.toString());             //toString输出数组里的内容
        }
    }

    //修改一条学生数据
    public static void modifyStudent(){
        String num = "";
        Student temp = null;

        float t = 0;

        System.out.println("请输入学生学号进行查找");
        num = sc.next();

        if((temp=findStudentByInput(num)) == null){
            System.out.println("查无此学号");
        }else{
            System.out.println("请输入学号");
            temp.setNum(sc.next());
            System.out.println("请输入姓名");
            temp.setName(sc.next());
            System.out.println("请输入java成绩");
            temp.setJava(sc.nextInt());
            System.out.println("请输入高数成绩");
            temp.setMath(sc.nextInt());
            System.out.println("请输入英语成绩");
            temp.setEnglish(sc.nextInt());

            t += temp.getJava();
            t += temp.getMath();
            t += temp.getEnglish();

            temp.setAver(t/3);
            temp.setSum(t);

            System.out.println("修改成功");
        }
    }
    //显示学生数据
    public static void listStudent(){
        for(Student student : list){
            System.out.println(student.toString());
        }
    }

    //按照学生成绩排序
    public static void listsort(){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int)(o1.getSum() - o2.getSum());  //升序
            }
        });
        System.out.println("排序完成");
        listStudent();
    }

    //查找指定学生并返回该对象
    public static Student findStudentByInput(String input){
        Student target = null;                                     //局部变量初始化
        for(Student student : list){                               //遍历列表
            if(input.equals(student.getNum())){
                target = student;
                break;
            }
        }
        return target;
    }

}