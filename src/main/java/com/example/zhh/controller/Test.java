package com.example.zhh.controller;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Test implements Runnable{

    NeiBu test = new NeiBu();
    class NeiBu{
        NeiBu(){

        }
        private  int a ;

        public  void add(int x){

                a += x;


        }
    }





    public static String getPinYinHeadChar(String str) {


        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert.toLowerCase(Locale.ROOT);
    }


    public static void main(String[] args) throws IOException {


        int[] ak = new int[21600];
        for(int i = 1;i<=21600;i++){
            ak[i-1] = i;
        }
        String s1 = Arrays.toString(ak);
        String join = StringUtils.join(ak, ",");
        System.out.println("kk"+s1);



        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(objects.size());

        String substring = StringUtils.substring("123", 4);
        System.out.println("111"+substring);
        int aaaccc= '2';
        System.out.println(aaaccc);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();

        stringObjectHashMap.put(null,"123");
        stringObjectHashMap.put("123",null);
        stringObjectHashMap.put(null,null);

        Set<Map.Entry<String, Object>> entries = stringObjectHashMap.entrySet();
        for (Map.Entry m:entries) {
            System.out.println("key:"+m.getKey()+"value:"+m.getValue());
        }
        final byte aaa = 5;
        final byte bbb = 3;
        Byte c = aaa+bbb;

        System.out.println(c);

/*        outer://java 中的标签只能用于循环前
        for(int i=0;i<3;i++){
            inner:
            for(int j=0;j<3;j++){
                System.out.println(i+"---"+j);
                //当j=2时结束outer标识符指定的循环
                if(j==1){
                    break;
                }
            }
        }*/

        int a = 10;
        int b = 10;
        a = ++a;
        b = b++;
        //b = a + b++;
        System.out.println(a);
        System.out.println(b);


        String s = "1122";
        String u = "11"+"22";
        System.out.println(s==u);

        //Test.stopByFlag();
/*        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(null);
        integers.add(8);
        integers.add(66);
        integers.add(14);
        integers.add(25);

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(null,null);

        TreeMap<Integer, Integer> integerIntegerTreeMap = new TreeMap<>();
        integerIntegerTreeMap.put(null,null);

        System.out.System.out.println(integers);


        System.out.System.out.println(478*0.42);
        Category[] values = Category.values();
        String name = values[0].name();
        int ordinal = values[1].ordinal();
        System.out.System.out.println(Category.BLANK.languageKey);
        System.out.System.out.println(Arrays.toString(values));
        System.out.System.out.println(name);
        System.out.System.out.println(ordinal);*/
/*
        String state = "1 , 2";
        String stateStr=state.replace(",","").replace(" ","");
        System.out.System.out.println(stateStr);
*/


/*        ResponseBo fault = ResponseBo.fault();
        System.out.System.out.println("ok");*/

/*        String a = "1-2";
        String[] split = a.split(",");
        System.out.System.out.println(split[0]);*/


/*        File file =new File("d:\\test.properties.doc");
        if(!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        Map<String, Object> map =new HashMap<>();
        new DocumentHandler().exportDoc("temp",map,file);*/





//        String pinyin = getPinYinHeadChar("王语嫣1");
//        System.out.System.out.println(pinyin);
//        String encrypt = MD5Utils.encrypt("mrbird","123456");
//        System.out.System.out.println("mrbird"+encrypt);

//        try{
/*            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection ct= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "oracle");
            Statement sm = ct.createStatement();
            ResultSet rs = sm.executeQuery("select* from DEPT");
            while(rs.next()){
                System.out.System.out.println("用户名"+rs.getString(2));
            }
            rs.close();
            sm.close();
            ct.close();*/


/*            String format = "";
            System.out.System.out.println("format:"+format);*/

/*            Test test.properties = new Test();
            Thread thread = new Thread(test.properties);
            Thread thread1 = new Thread(test.properties);
            thread.start();
            System.out.println("1已经启动");
            thread1.start();
            System.out.println("2已经启动");
            for(int i = 1;i<1000;i++){
                System.out.println(i);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }*/


        ArrayList<Integer> integers = new ArrayList<>();
        for(int i = 0; i<40;i++){
            integers.add(i);
        }

        System.out.println("分页前"+integers.toString());
        List<Integer> page = new Test().page(2l, 20l, integers);
        System.out.println("分页后"+page.toString());


    }


//    流式分页
    public List<Integer> page(long pageNo, long pageSize, List<Integer> list){
        List<Integer> collect = list.stream().skip((pageNo - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        return collect;
    }


    static void stopByFlag() {
        ARunnable ar = new ARunnable();
        Thread thread = new Thread(ar);
        thread.start();
/*        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

/*        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        ar.tellToStop();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        ar.tellToResume();
    }

    static class ARunnable implements Runnable {

        volatile boolean stop;

        void tellToStop() {
            System.out.println("我最先执行");
            stop = true;
        }

        void tellToResume() {
            synchronized (this) {
                System.out.println("我最hou执行");
                this.notify();
            }
        }

        @Override
        public void run() {
            System.out.println("进入不可停止区域 1。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("收到中断异常。。。");
                System.out.println("做一些相关处理。。。");
                e.printStackTrace();
            }
            System.out.println("退出不可停止区域 1。。。");
            System.out.println("检测标志位:"+ String.valueOf(stop));
            if (stop) {
                try {
                    synchronized (this) {
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("进入不可停止区域 2。。。");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("退出不可停止区域 2。。。");
        }

    }

    @Override
    public void run() {
        synchronized (this) {
        for(int i =0;i<3;i++){

                test.add(50);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+test.a);
            }

        }

    }

    public enum Category{

        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
         Category(String languageKey, int scriptKey) {
            this.languageKey = languageKey;
            this.scriptKey = scriptKey;
        }

         String languageKey;
         int scriptKey;

    }





    //定义抽象类
    public abstract class Drink {
        public abstract double cost();
    }
    //定义两个抽象类的实现类
    public class Juice extends Drink{
        @Override
        public double cost() {
            System.out.println("juice: "+16);
            return 16;
        }
    }
    public class Milk extends Drink{
        @Override
        public double cost() {
            System.out.println("milk: "+12);
            return 12;
        }
    }
    //定义装饰抽象类
    public abstract class Decorator extends Drink {
        public abstract double cost();
    }
    //定义两个装饰具体实现类
    public class Chocolate extends Decorator{
        private final static double COST = 4;
        private Drink drink;

        public Chocolate(Drink drink) {
            this.drink = drink;
        }

        @Override
        public double cost() {
            System.out.println("chocolate:"+4);
            return COST+drink.cost();
        }
    }
    public class Pudding extends Decorator{
        private final static double COST = 5;
        private Drink drink;

        public Pudding(Drink drink) {
            this.drink = drink;
        }

        @Override
        public double cost() {
            System.out.println("pudding:"+5);
            return COST+drink.cost();
        }
    }

}
