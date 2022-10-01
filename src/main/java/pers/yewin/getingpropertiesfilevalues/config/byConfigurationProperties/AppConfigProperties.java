package pers.yewin.getingpropertiesfilevalues.config.byConfigurationProperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author: Ye Win
 * @created: 30/09/2022
 * @project: reading-properties-file-values
 * @package: pers.yewin.getingpropertiesfilevalues.config
 */

@Configuration // declare class as bean
@ConfigurationProperties(prefix = "app.config") // read values from properties which behind 'app.config' prefix
@Data // using lombok to get getter and setter method which is needed to inject data from properties file into fields by setter method, getter method is need for access field value from other class.
public class AppConfigProperties {

    /**
     * ConfigurationProperties bind with properties file
     * So, we need to make sure fields name are same with application.properties values.
     * We already declare prefix 'app.config', so, no need to add that in field name.
     * In application.properties file, I used dash(-) instead of dot(.) after prefix key, (you can define any prefix key if you want).
     * if you set multi dot(.) (nested dot) ConfigurationProperties can't read and for that case, you need to create pojo classes for each dot.
     * I don't want to create many pojo classes, So, I used dash(-).
     * The other ways to read properties file, eg. @Value or Environment, you can go with nested dot format.
     *
     * For the prefix which not start with 'app.config' (eg. 'app.internal', etc), ConfigurationProperties can't read because we declare prefix like 'app.config'.
     * For that case, we need to create new Config Properties class with prefix app.internal. see. OtherConfigProperties class.
     * Anyway, that is up to your fields design,
     * Because you can also use 'app' as prefix not use 'app.config' and follow fields from 'app' can separate by dash.
     * So that you don't need to create OtherConfigProperties to avoid mess case for you.
     * Here, I want to show you to control multi prefix, So, I'm going like that design (multi-prefix) for properties fields.
     *
     * Reference link -> https://www.baeldung.com/configuration-properties-in-spring-boot
     */

    // you can do second character as small letter, ConfigurationProperties can understand that too.
    private String headerExcelColumn1;
    private String headerExcelColumn2;
    private String headerCsvColumn1;
    private String name;
    private String uploadFileUrl;
    private String smtpPort;
    private String emailAddress;
    private String emailPassword;
    private String phoneNoPrefix;
    private String key;
    private String columnListValues;
    private List<String> mailRecipients; // configuration properties already transformed into list when it saw like that symbol [0] [1] in properties file

}
