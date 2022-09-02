package test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.atguigu.spring5.autowire.Empt;
import com.atguigu.spring5.bean.Orders;
import com.atguigu.spring5.collections.Course;
import com.atguigu.spring5.collections.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class TestCollections {
    @Test
    public void testCollection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.testDemo();
    }

    @Test
    public void testBean2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Course course = context.getBean("course", Course.class);
        course.test();
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("myBean", Course.class);
        course.test();
        System.out.println(course);
        Course course1 = context.getBean("myBean", Course.class);
        course1.test();
        System.out.println(course1);
    }

    @Test
    public void test4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        System.out.println("！！！！！！！！！！！context生成");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第4步，实例化" + orders.toString());
        // 手动销毁
        context.close();
    }

    @Test
    public void test5() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        System.out.println("！！！！！！！！！！！context生成");
        Empt empt = context.getBean("empt", Empt.class);
        System.out.println(empt.toString());
        empt.test();
        // 手动销毁
        context.close();
    }

    @Test
    public void test6() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        System.out.println("!!!!!! context生成");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection.toString());
    }
}
