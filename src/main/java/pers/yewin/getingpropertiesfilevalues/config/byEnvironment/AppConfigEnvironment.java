package pers.yewin.getingpropertiesfilevalues.config.byEnvironment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import pers.yewin.getingpropertiesfilevalues.model.pojo.ConfigObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Ye Win
 * @created: 01/10/2022
 * @project: reading-properties-file-values
 * @package: pers.yewin.getingpropertiesfilevalues.config
 */

@Component // create bean type
public class AppConfigEnvironment {

    /**
     * You can declare environment variable in any class which is bean type in spring.
     * eg. you can use environment variable in one of the controller or service class.
     * Actually, this class is no need.
     * Because You can pull only one by one fields which you want to know the value in you service class by creating environment variable.
     * But here, I want to load all configs in one place as demo show to you.
     * And so, I will add that all config fields in this class.
     */

    @Autowired
    private Environment environment; // provided by spring to load value from properties file as per fields name

    private ConfigObject configObject = new ConfigObject();

    public ConfigObject getConfigObject() {
        return configObject;
    }


    // this method should be call only one time when application was started
    public void loadConfig(){

        // get value from application.properties and set into pojo class.
        // field inside getProperty method have to same with application.properties file fields
        /** add application config values into pojo class **/
        configObject.setHeaderExcelColumn1(environment.getProperty("app.config.header-excel-column1"));
        configObject.setHeaderExcelColumn2(environment.getProperty("app.config.header-excel-column2"));
        configObject.setHeaderCsvColumn1(environment.getProperty("app.config.header-csv-column1"));
        configObject.setName(environment.getProperty("app.config.name"));
        configObject.setUploadFileUrl(environment.getProperty("app.config.upload-file-url"));
        configObject.setSmtpPort(environment.getProperty("app.config.smtp-port"));
        configObject.setEmailAddress(environment.getProperty("app.config.email-address"));
        configObject.setEmailPassword(environment.getProperty("app.config.email-password"));
        configObject.setPhoneNoPrefix(environment.getProperty("app.config.phoneNo-prefix"));
        configObject.setKey(environment.getProperty("app.config.key"));

        String colListValuesStr = environment.getProperty("app.config.column-listValues"); // properties file values return comma separated string value
        // check colListValuesStr for null case and if not null, split with comma separated and convert from string array to arrayList, if null, go with empty string array
        List<String> colListValues = Arrays.asList(colListValuesStr!=null?colListValuesStr.split("\\s*,\\s*") : new String[0]);
        configObject.setColumnListValues(colListValues);

        // add into list, here, if you use configuration properties way, you don't need to add single string into list like below.
        List<String> recipientList = new ArrayList<String>();
        recipientList.add(environment.getProperty("app.config.mail-recipients[0]"));
        recipientList.add(environment.getProperty("app.config.mail-recipients[1]"));
        configObject.setDefaultEmailRecipientList(recipientList);


        /** add other services config values into pojo class **/
        configObject.setOtherInternalEmailServiceUrl(environment.getProperty("app.internal.service-email-url"));
        configObject.setOtherInternalBillServiceUrl(environment.getProperty("app.internal.service-bill-url"));
        configObject.setOtherInternalIntegrationServiceUrl(environment.getProperty("app.internal.service-integration-url"));
        configObject.setOtherInternalServiceSecret(environment.getProperty("app.internal.service-secret"));


        /** add third party services config values into pojo class **/
        configObject.setThirdPartyAACompanyClientId(environment.getProperty("app.thirdparty.company-AA-clientId"));
        configObject.setThirdPartyAACompanySecretKey(environment.getProperty("app.thirdparty.company-AA-secretKey"));
        configObject.setThirdPartyAACompanyGetDetailUrl(environment.getProperty("app.thirdparty.company-AA-get-detail-url"));
        configObject.setThirdPartyAACompanyPostPaymentUrl(environment.getProperty("app.thirdparty.company.AA-post-payment-url"));
        configObject.setThirdPartyBBCompanyUsername(environment.getProperty("app.thirdparty.company-BB-username"));
        configObject.setThirdPartyBBCompanyPassword(environment.getProperty("app.thirdparty.company-BB-password"));
        configObject.setThirdPartyBBCompanyPurchaseApiUrl(environment.getProperty("app.thirdparty.company-BB-purchase-api-url"));
        configObject.setThirdPartyGGMicrofinanceCompanyLoanUrl(environment.getProperty("app.thirdparty.microfinance-GGCompany-loan-url"));
        configObject.setThirdPartyOoredooOperatorEloadTopupUrl(environment.getProperty("app.thirdparty.operator-ooredoo-eload-topup-url"));
        configObject.setThirdPartyTelenorOperatorPackageUrl(environment.getProperty("app.thirdparty.operator-telenor-package-url"));

    }


}
