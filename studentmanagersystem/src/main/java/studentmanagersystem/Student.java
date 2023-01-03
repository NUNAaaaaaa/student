package studentmanagersystem;

import java.io.Serializable;

public class Student implements Serializable {              //一定要实现Serializable接口才能被序列化
    String num;
    String name;
    int java;
    int math;
    int English;
    float sum;
    float aver;

    //借助get和set方法用于访问私有域变量
    public String getNum() {
        return num;                         //取值，设定字符串变量来得到num的值 并且将这个值保存

    }

    public void setNum(String num) {
        this.num = num;                     //设置，this代表Student
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int mathGrade) {
        this.math = math;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int English) {
        this.English = English;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public float getAver() {
        return aver;
    }

    public void setAver(float aver) {
        this.aver = aver;
    }

    @Override                                    //重写父类
    public String toString(){
        return "Student [学号="+num+",姓名="+name+",java="+java+",高数="+math+",英语="+English+",总分="+sum+",平局分="+aver+"]";
    }
}