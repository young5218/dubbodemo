package dubbotest.dubbodemo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
    public static void main(String[] args) throws Exception {
    	String path="provider.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        context.start();
        System.in.read(); // 按任意键退出
    }
}
