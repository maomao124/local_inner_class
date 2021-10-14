/**
 * Project name(项目名称)：局部内部类
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/14
 * Time(创建时间)： 19:58
 * Version(版本): 1.0
 * Description(描述)： 局部内部类是指在一个方法中定义的内部类
 * 局部内部类有如下特点：
 * 1）局部内部类与局部变量一样，不能使用访问控制修饰符（public、private 和 protected）和 static 修饰符修饰。
 * 2）局部内部类只在当前方法中有效。
 * 3）局部内部类中不能定义 static 成员。
 * 4）局部内部类中还可以包含内部类，但是这些内部类也不能使用访问控制修饰符（public、private 和 protected）和 static 修饰符修饰。
 * 5）在局部内部类中可以访问外部类的所有成员。
 * 6）在局部内部类中只可以访问当前方法中 final 类型的参数与变量。如果方法中的成员与外部类中的成员同名，
 * 则可以使用 <OuterClassName>.this.<MemberName> 的形式访问外部类中的成员。
 */

public class test
{
    int a = 0;
    int b = 1;

    public void method()
    {
        int c = 2;
        int d = 3;
        final int e = 4;
        class inner
        {
            final int a1 = a;
            final int b1 = b;
            final int c1 = c;
            final int d1 = d;
            final int e1 = e;
            final int c2 = test.this.a;
        }
        inner i = new inner();
        System.out.println(i.a1);
        System.out.println(i.b1);
        System.out.println(i.c1);
        System.out.println(i.d1);
        System.out.println(i.e1);
        System.out.println(i.c2);
    }

    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------

        test t = new test();
        t.method();

        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
