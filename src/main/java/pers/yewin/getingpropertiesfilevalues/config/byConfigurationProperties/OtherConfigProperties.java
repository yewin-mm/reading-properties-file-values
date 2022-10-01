package pers.yewin.getingpropertiesfilevalues.config.byConfigurationProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Ye Win
 * @created: 30/09/2022
 * @project: reading-properties-file-values
 * @package: pers.yewin.getingpropertiesfilevalues.config
 */


@Configuration // declare class as bean
//@ConfigurationProperties(prefix = "app.internal") // Here we don't add that and I will show two beans ways to get values from two prefix
public class OtherConfigProperties {

    /**
     * Here, I showed for multi prefix control by one class.
     * If you want to make clear, you can separate classes like AppConfigProperties and prefix for that multi prefix fields.
     *
     * Or you can also combine AppConfigProperties class as bean in here (add fields in OtherConfigFields class),
     * and you can control for that prefix 'app.config' from here too.
     * In this project, I showed multi ways, and so you can use whatever you want.
     *
     * You can separate class for prefix 'app.internal' and prefix 'app.thirdparty' for more clear.
     * You can also use dash instead of dot(.) and control all by one class and you can also use prefix 'app' for all fields.
     * That's up to your design and here I will show to control for multi-prefix fields.
     * So, whatever, you can go with your prefer way that will make easy for you.
     */

    @Bean // create to become bean type
    @ConfigurationProperties(prefix = "app.internal") // @ConfigurationProperties for prefix 'app.internal'
    public OtherConfigFields internalConfig() {
        return new OtherConfigFields(); // return pojo class which has all fields for both app.internal and app.thirdparty prefix.
    }

    @Bean // create to become bean type
    @ConfigurationProperties(prefix = "app.thirdparty")  // @ConfigurationProperties for prefix 'app.thirdparty'
    public OtherConfigFields thirdPartyConfig(){
        return new OtherConfigFields();  // return pojo class which has all fields for both app.internal and app.thirdparty prefix.
    }
}
