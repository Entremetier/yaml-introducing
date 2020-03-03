package springframework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springframework.examplebeans.FakeDataSource;
import springframework.examplebeans.FakeJmsBroker;

@Configuration
//@PropertySource fällt weg da Spring automatisch im application.properties ordner nach den informationen schaut
public class PropertyConfig {

    @Value("${guru.username}")
    String username;

    @Value("${guru.password}")
    String password;

    @Value("${guru.dburl}")
    String url;
    //die value werte werden aus dem application.properties im resources folder geholt, darum müssen die namen übereinstimmen

    @Value("${guru.jms.username}")
    String jmsUsername;

    @Value("${guru.jms.password}")
    String jmsPassword;

    @Value("${guru.jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }
    //die fakedaten werden hier gesetzt um damit später zu arbeiten, es wird eine Datenbank simuliert

    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker jmsBroker = new FakeJmsBroker();
        jmsBroker.setUser(jmsUsername);
        jmsBroker.setPassword(jmsPassword);
        jmsBroker.setUrl(jmsUrl);
        return jmsBroker;
    }

    //PropertySourcesPlaceholderConfigurer wurde gelöscht weil dies auch automatisch von Spring angewendet wird
}
