package pers.yewin.getingpropertiesfilevalues.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import pers.yewin.getingpropertiesfilevalues.config.byConfigurationProperties.AppConfigProperties;
import pers.yewin.getingpropertiesfilevalues.config.byConfigurationProperties.OtherConfigProperties;
import pers.yewin.getingpropertiesfilevalues.config.byEnvironment.AppConfigEnvironment;
import pers.yewin.getingpropertiesfilevalues.config.byExtraConfigFile.ExtraConfigFile;
import pers.yewin.getingpropertiesfilevalues.config.byValueAnnotation.AppConfigValue;
import pers.yewin.getingpropertiesfilevalues.model.pojo.ConfigObject;
import pers.yewin.getingpropertiesfilevalues.model.pojo.CustomFileConfigObject;
import pers.yewin.getingpropertiesfilevalues.model.response.ReadConfigValuesResponse;
import pers.yewin.getingpropertiesfilevalues.model.response.ReadCustomFileConfigValuesReponse;
import pers.yewin.getingpropertiesfilevalues.service.ReadPropertiesFileValuesService;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Ye Win
 * @created: 29/09/2022
 * @project: getting-properties-file-values
 * @package: pers.yewin.getingpropertiesfilevalues.service.impl
 */

@Service // declare class as bean type
public class ReadPropertiesFileValuesServiceImpl implements ReadPropertiesFileValuesService {

    @Autowired
    private AppConfigProperties appConfigProperties;

    @Autowired
    private OtherConfigProperties otherConfigProperties;

    @Autowired
    private AppConfigEnvironment appConfigEnvironment;

    // you can directly use below environment instead of above appConfigEnvironment when you want to get some config values only (not all config fields) from this class.
//    @Autowired
//    private Environment environment;

    @Autowired
    private AppConfigValue appConfigValue;

    // you can directly use @Value annotation instead of above appConfigValue when you want to get some config values only (not all config fields) from this class.
//    @Value("${app.config.header-excel-column1}")
//    private String headerExcelColumn1;


    @Autowired
    private ExtraConfigFile extraConfigFile;

    @Override
    public ReadConfigValuesResponse readByValueAnnotation() {
        ConfigObject configObject = appConfigValue.getConfigObject();

        /** below are some demo print out values from application.properties file **/

        System.out.println("----- Some demo print out values from application.properties file -----");
        System.out.println("Header Excel Column 1 value: " + configObject.getHeaderExcelColumn1());
        System.out.println("Header CSV Column 1 value: " + configObject.getHeaderCsvColumn1());
        System.out.println("Column List value: " + configObject.getColumnListValues());
        System.out.println("Recipient List value: " + configObject.getDefaultEmailRecipientList());

        System.out.println("Other Internal Email Service URL: " + configObject.getOtherInternalEmailServiceUrl());

        System.out.println("Third Party AA Company Post Pay URL: " + configObject.getThirdPartyAACompanyPostPaymentUrl());

        /**
         * Here, you can get values directly by using @Value annotation.
         * For that case ->
         * declare one variable with @Value annotation in top of this class (outside method).
         * you can use like eg. String headerExcelColumn1 = headerExcelColumn1 (variable from top of class with @Value annotation)
         * So, you can pull only some fields which you need to do your logic. No need to pull all fields.
         * But here, I pull (load) all config fields as this is demo project.
         */

//        String headerExcelColumn1 = headerExcelColumn1; // that is use when you want to get some config values only (not all config fields) from this class.

        /**
         * Actually, Config values is use for doing other logic
         * So, you can do your business logic with config values from properties file.
         * Getting some values (it might change as dynamic) from properties file is the good approach.
         * So, go with that way and add some values which might change (eg. api url) into properties file instead of adding hard coded values in class level and get that values is good approach in java projects.
         * You can do whatever you want with that values.
         * eg. calling other api (url can get from properties file), or adding prefix, getting columns name to export excel, checking id, getting client id to call api
         * eg. getting your server ip to do other operations, getting static email list to send (if it's increase day by day, it's better save in db), getting password, doing other logic or etc. whatever you want.
         * But here, I showed as reading config values demo project.
         * so, I don't do any logic and return that values as api response.
         */
        // return configObject
        ReadConfigValuesResponse readConfigValuesResponse = new ReadConfigValuesResponse();
        readConfigValuesResponse.setReadType("Read by using @Value");
        readConfigValuesResponse.setConfigValues(configObject);
        return readConfigValuesResponse;
    }

    @Override
    public ReadConfigValuesResponse readByConfigurationProperties() {

        /** below are some demo print out values from application.properties file **/

        System.out.println("----- Some demo print out values from application.properties file -----");
        System.out.println("Header Excel Column 1 value: " + appConfigProperties.getHeaderExcelColumn1());
        System.out.println("Header CSV Column 1 value: " + appConfigProperties.getHeaderCsvColumn1());
        System.out.println("Column String value (not converted into list): " + appConfigProperties.getColumnListValues());
        System.out.println("Recipient List value: " + appConfigProperties.getMailRecipients());


        System.out.println("Other Internal Email Service URL: " + otherConfigProperties.internalConfig().getServiceEmailUrl());
        // if you pull unknown fields which are not under prefix app.internal, you will get null.
        System.out.println("Unknown Field Demo Value: " + otherConfigProperties.internalConfig().getCompanyBBPassword()); // it will print null because companyBBPassword is not start with app.internal


        System.out.println("Third Party AA Company Post Pay URL: "+ otherConfigProperties.thirdPartyConfig().getCompanyAAPostPaymentUrl());
        // if you pull unknown fields which are not under prefix app.thirdparty, you will get null.
        System.out.println("Unknown Field Demo Value: " + otherConfigProperties.thirdPartyConfig().getServiceSecret()); // it will print null because serviceSecret is not start with app.thirdparty


        // call migrateDataToConfigObject to migrate data from appConfigProperties and otherConfigProperties to ConfigObject
        ConfigObject configObject = migrateDataToConfigObject();

        /**
         * Actually, Config values is use for doing other logic
         * So, you can do your business logic with config values from properties file.
         * Getting some values (it might change as dynamic) from properties file is the good approach.
         * So, go with that way and add some values which might change (eg. api url) into properties file instead of adding hard coded values in class level and get that values is good approach in java projects.
         * You can do whatever you want with that values.
         * eg. calling other api (url can get from properties file), or adding prefix, getting columns name to export excel, checking id, getting client id to call api
         * eg. getting your server ip to do other operations, getting static email list to send (if it's increase day by day, it's better save in db), getting password, doing other logic or etc. whatever you want.
         * But here, I showed as reading config values demo project.
         * so, I don't do any logic and return that values as api response.
         */
        // return configObject
        ReadConfigValuesResponse readConfigValuesResponse = new ReadConfigValuesResponse();
        readConfigValuesResponse.setReadType("Read by using Configuration Properties");
        readConfigValuesResponse.setConfigValues(configObject);
        return readConfigValuesResponse;

    }



    @Override
    public ReadConfigValuesResponse readByEnvironment() {

        /**
         * Actually, it's better load config when application was started instead of doing load like below code.
         * eg. you can load application started by using @EventListener.
         * eg. create a new class call LoadConfig
         * and add one method and add @EventListener on that method and call below load config method.
         * Please note that class also should be bean type (you can simply add @Component on that class)
         * But here, I show as demo and so not load config when application was started.
         */

        appConfigEnvironment.loadConfig(); // load config values from properties file.

        // get config object which already added field values by above loadConfig method.
        ConfigObject configObject = appConfigEnvironment.getConfigObject();

        /** below are some demo print out values from application.properties file **/

        System.out.println("----- Some demo print out values from application.properties file -----");
        System.out.println("Header Excel Column 1 value: " + configObject.getHeaderExcelColumn1());
        System.out.println("Header CSV Column 1 value: " + configObject.getHeaderCsvColumn1());
        System.out.println("Column List value: " + configObject.getColumnListValues());
        System.out.println("Recipient List value: " + configObject.getDefaultEmailRecipientList());

        System.out.println("Other Internal Email Service URL: " + configObject.getOtherInternalEmailServiceUrl());

        System.out.println("Third Party AA Company Post Pay URL: " + configObject.getThirdPartyAACompanyPostPaymentUrl());

        /**
         * Here, you can get values directly by using environment variable.
         * For that case ->
         * declare environment variable with @Autowired in top of this class (outside method).
         * you can use like eg. String headerExcelColumn1 = environment.getProperty("app.config.header-excel-column1"); // that field need to same with properties file.
         * So, you can pull only some fields which you need to do your logic. No need to pull all fields.
         * But here, I pull (load) all config fields as this is demo project.
         */

//        String headerExcelColumn1 = environment.getProperty("app.config.header-excel-column1"); // that is use when you want to get some config values only (not all config fields) from this class.


        /**
         * Actually, Config values is use for doing other logic
         * So, you can do your business logic with config values from properties file.
         * Getting some values (it might change as dynamic) from properties file is the good approach.
         * So, go with that way and add some values which might change (eg. api url) into properties file instead of adding hard coded values in class level and get that values is good approach in java projects.
         * You can do whatever you want with that values.
         * eg. calling other api (url can get from properties file), or adding prefix, getting columns name to export excel, checking id, getting client id to call api
         * eg. getting your server ip to do other operations, getting static email list to send (if it's increase day by day, it's better save in db), getting password, doing other logic or etc. whatever you want.
         * But here, I showed as reading config values demo project.
         * so, I don't do any logic and return that values as api response.
         */
        // return configObject
        ReadConfigValuesResponse readConfigValuesResponse = new ReadConfigValuesResponse();
        readConfigValuesResponse.setReadType("Read by using Environment");
        readConfigValuesResponse.setConfigValues(configObject);
        return readConfigValuesResponse;
    }

    @Override
    public ReadCustomFileConfigValuesReponse readCustomFileConfigs() {

        // you can use any methods as below and here, I will use to load config by environment.
        extraConfigFile.loadCustomConfigsByEnvironment(); // load extra config file values by using environment
//        extraConfigFile.loadCustomConfigsByValueAnnotation(); // load extra config file values by using @Value

        CustomFileConfigObject customFileConfigObject = extraConfigFile.getCustomFileConfigObject();
        System.out.println("Extra custom file config value: " +customFileConfigObject);


        /**
         * Actually, Config values is use for doing other logic
         * So, you can do your business logic with config values from properties file.
         * Getting some values (it might change as dynamic) from properties file is the good approach.
         * So, go with that way and add some values which might change (eg. api url) into properties file instead of adding hard coded values in class level and get that values is good approach in java projects.
         * You can do whatever you want with that values.
         * eg. calling other api (url can get from properties file), or adding prefix, getting columns name to export excel, checking id, getting client id to call api
         * eg. getting your server ip to do other operations, getting static email list to send (if it's increase day by day, it's better save in db), getting password, doing other logic or etc. whatever you want.
         * But here, I showed as reading config values demo project.
         * so, I don't do any logic and return that values as api response.
         */
        // return customConfigFileObject
        ReadCustomFileConfigValuesReponse readCustomFileConfigValuesReponse = new ReadCustomFileConfigValuesReponse();
        readCustomFileConfigValuesReponse.setDescription("Read from extra custom config file");
        readCustomFileConfigValuesReponse.setReadType("Read by using Environment");
        readCustomFileConfigValuesReponse.setCustomFileConfigValues(customFileConfigObject);
        return readCustomFileConfigValuesReponse;
    }


    // migrate data from appConfigProperties and otherConfigProperties to ConfigObject and return config object
    private ConfigObject migrateDataToConfigObject(){

        // set data into config object from appConfigProperties and otherConfigProperties

        ConfigObject configObject = new ConfigObject();

        /** add application config values into pojo class **/
        configObject.setHeaderExcelColumn1(appConfigProperties.getHeaderExcelColumn1());
        configObject.setHeaderExcelColumn2(appConfigProperties.getHeaderExcelColumn2());
        configObject.setHeaderCsvColumn1(appConfigProperties.getHeaderCsvColumn1());
        configObject.setName(appConfigProperties.getName());
        configObject.setUploadFileUrl(appConfigProperties.getUploadFileUrl());
        configObject.setSmtpPort(appConfigProperties.getSmtpPort());
        configObject.setEmailAddress(appConfigProperties.getEmailAddress());
        configObject.setEmailPassword(appConfigProperties.getEmailPassword());
        configObject.setPhoneNoPrefix(appConfigProperties.getPhoneNoPrefix());
        configObject.setKey(appConfigProperties.getKey());

        String colListValuesStr = appConfigProperties.getColumnListValues(); // column values string and we will change it into list by comma separated
        // check colListValuesStr for null case and if not null, split with comma separated and convert from string array to arrayList, if null, go with empty string array
        List<String> colListValues = Arrays.asList(colListValuesStr!=null?colListValuesStr.split("\\s*,\\s*") : new String[0]);
        configObject.setColumnListValues(colListValues);

        // no need to create list, and it's already been list as configuration properties already converted into list in appConfigProperties class.
        configObject.setDefaultEmailRecipientList(appConfigProperties.getMailRecipients());


        /** add other services config values into pojo class **/
        configObject.setOtherInternalEmailServiceUrl(otherConfigProperties.internalConfig().getServiceEmailUrl());
        configObject.setOtherInternalBillServiceUrl(otherConfigProperties.internalConfig().getServiceBillUrl());
        configObject.setOtherInternalIntegrationServiceUrl(otherConfigProperties.internalConfig().getServiceIntegrationUrl());
        configObject.setOtherInternalServiceSecret(otherConfigProperties.internalConfig().getServiceSecret());


        /** add third party services config values into pojo class **/
        configObject.setThirdPartyAACompanyClientId(otherConfigProperties.thirdPartyConfig().getCompanyAAClientId());
        configObject.setThirdPartyAACompanySecretKey(otherConfigProperties.thirdPartyConfig().getCompanyAASecretKey());
        configObject.setThirdPartyAACompanyGetDetailUrl(otherConfigProperties.thirdPartyConfig().getCompanyAAGetDetailUrl());
        configObject.setThirdPartyAACompanyPostPaymentUrl(otherConfigProperties.thirdPartyConfig().getCompanyAAPostPaymentUrl());
        configObject.setThirdPartyBBCompanyUsername(otherConfigProperties.thirdPartyConfig().getCompanyBBUsername());
        configObject.setThirdPartyBBCompanyPassword(otherConfigProperties.thirdPartyConfig().getCompanyBBPassword());
        configObject.setThirdPartyBBCompanyPurchaseApiUrl(otherConfigProperties.thirdPartyConfig().getCompanyBBPurchaseApiUrl());
        configObject.setThirdPartyGGMicrofinanceCompanyLoanUrl(otherConfigProperties.thirdPartyConfig().getMicrofinanceGGCompanyLoanUrl());
        configObject.setThirdPartyOoredooOperatorEloadTopupUrl(otherConfigProperties.thirdPartyConfig().getOperatorOoredooEloadTopupUrl());
        configObject.setThirdPartyTelenorOperatorPackageUrl(otherConfigProperties.thirdPartyConfig().getOperatorTelenorPackageUrl());

        return configObject;

    }
}
