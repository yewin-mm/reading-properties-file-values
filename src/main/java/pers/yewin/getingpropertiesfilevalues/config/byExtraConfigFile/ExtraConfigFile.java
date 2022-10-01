package pers.yewin.getingpropertiesfilevalues.config.byExtraConfigFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import pers.yewin.getingpropertiesfilevalues.model.pojo.CustomFileConfigObject;

/**
 * @author: Ye Win
 * @created: 02/10/2022
 * @project: reading-properties-file-values
 * @package: pers.yewin.getingpropertiesfilevalues.config.byExtraConfigFile
 */

@PropertySource(ignoreResourceNotFound = true, value = "classpath:config.properties")
@Component // create bean type
public class ExtraConfigFile {

    /**
     * PropertiesSource will define file as config properties file which file will find by spring.
     * So, that other extra config file will same with application properties file.
     * So, we can use both @Value and Environment to get field values from that file.
     * Here, I will show you as demo by getting data using environment
     */

    @Autowired
    private Environment environment; // provided by spring to load value from that extra config file as per fields name

    // @Value annotation will read from extra config properties file and get value as per field name and add value into variable.
    @Value("${custom.config.value}")
    private String configValue;

    @Value("${custom.config.idname}")
    private String configIdName;

    @Value("${custom.config.predefine.value}")
    private String configPredefineValue;

    private CustomFileConfigObject customFileConfigObject = new CustomFileConfigObject();

    public CustomFileConfigObject getCustomFileConfigObject() {
        return customFileConfigObject;
    }


    // load by using environment
    // this method should be call only one time when application was started
    public void loadCustomConfigsByEnvironment(){

        // get value from extra config properties file and set into pojo class.
        // field inside getProperty method have to same with extra config properties file fields
        /** add extra config file values into pojo class **/
        customFileConfigObject.setCustomConfigValue(environment.getProperty("custom.config.value"));
        customFileConfigObject.setCustomConfigIdname(environment.getProperty("custom.config.idname"));
        customFileConfigObject.setCustomConfigPredefinedValue(environment.getProperty("custom.config.predefine.value"));

    }

    // you can use load by @Value instead of above using environment method
    public void loadCustomConfigsByValueAnnotation(){

        /** add extra config file values into pojo class **/
        customFileConfigObject.setCustomConfigValue(configValue);
        customFileConfigObject.setCustomConfigIdname(configIdName);
        customFileConfigObject.setCustomConfigPredefinedValue(configPredefineValue);

    }
}
