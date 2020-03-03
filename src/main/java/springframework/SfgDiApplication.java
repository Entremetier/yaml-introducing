package springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springframework.examplebeans.FakeDataSource;
import springframework.examplebeans.FakeJmsBroker;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getUser());

		FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);

		System.out.println(fakeJmsBroker.getUrl());

		//dieses projekt ist der nachfolger vom "fake-data-property-source" projekt

		//änderungen finden sich im application.properties, datasource.properties, jms.properties und PropertyConfig
	}
}
