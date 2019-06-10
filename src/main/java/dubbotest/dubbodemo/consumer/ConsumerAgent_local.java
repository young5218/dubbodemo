package dubbotest.dubbodemo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

public class ConsumerAgent_local {

	private static final String APPLICATION_NAME = "yyyYonyouCloud_DubboAvl_Agent";
	private static final String STR_ECHO = "$echo";
	private static final String STR_JAVA_LANG_STRING = "java.lang.String";

	private static final String ECHO_PARAMETER = "$yyyYonyouCloud_DubboAvl";

	public static void main(String[] args) {
		ApplicationConfig application = new ApplicationConfig();
		application.setName(APPLICATION_NAME);
		ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
		// 弱类型接口名
		reference.setInterface("dubbotest.dubbodemo.provider.DemoService");
		// 声明为泛化接口
		reference.setGeneric(true);
		reference.setUrl("dubbo://192.168.56.1:20880");
		reference.setApplication(application);
		GenericService genericService = reference.get();

		Object result = genericService.$invoke(STR_ECHO, new String[] { STR_JAVA_LANG_STRING },
				new Object[] { ECHO_PARAMETER });

		if (ECHO_PARAMETER.equals((String) result))

		{
			System.out.println("true");
			System.out.println((String)result);
		} else {
			System.out.println("false");
		}
	}
}
