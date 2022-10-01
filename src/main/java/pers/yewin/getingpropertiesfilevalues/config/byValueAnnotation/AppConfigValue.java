package pers.yewin.getingpropertiesfilevalues.config.byValueAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pers.yewin.getingpropertiesfilevalues.model.pojo.ConfigObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ye Win
 * @created: 01/10/2022
 * @project: reading-properties-file-values
 * @package: pers.yewin.getingpropertiesfilevalues.config.byValueAnnotation
 */

@Component // create bean type
public class AppConfigValue {

    /**
     * You can declare @Value annotation in any class which is bean type in spring.
     * eg. you can use @Value annotation in one of the controller or service class.
     * Actually, this class is no need.
     * Because You can pull only one by one fields which you want to know the value in you service class by @Value annotation.
     * But here, I want to load all configs in one place as demo show to you.
     * And so, I will add that all config fields in this class.
     */

    // @Value annotation will read from application.properties and get value as per field name and add value into variable.
    @Value("${app.config.header-excel-column1}")
    private String headerExcelColumn1;

    @Value("${app.config.header-excel-column2}")
    private String headerExcelColumn2;

    @Value("${app.config.header-csv-column1}")
    private String headerCSVColumn1;

    @Value("${app.config.name}")
    private String configName;

    @Value("${app.config.upload-file-url}")
    private String uploadFilePath;

    @Value("${app.config.smtp-port}")
    private String smtpPort;

    @Value("${app.config.email-address}")
    private String emailAddress;

    @Value("${app.config.email-password}")
    private String emailPassword;

    @Value("${app.config.phoneNo-prefix}")
    private String phoneNoPrefix;

    @Value("${app.config.key}")
    private String key;

    // split comma separated and add into list
    @Value("#{'${app.config.column-listValues}'.split(',')}")
    private List<String> columnListValues;

    @Value("${app.config.mail-recipients[0]}")
    private String recipient1;

    @Value("${app.config.mail-recipients[1]}")
    private String recipient2;

    @Value("${app.internal.service-email-url}")
    private String internalOtherServiceEmailUrl;

    @Value("${app.internal.service-bill-url}")
    private String internalOtherServiceBillUrl;

    @Value("${app.internal.service-integration-url}")
    private String internalOtherServiceIntegrationUrl;

    @Value("${app.internal.service-secret}")
    private String internalOtherServiceSecret;

    @Value("${app.thirdparty.company-AA-clientId}")
    private String thirdpartyCompanyAAClientId;

    @Value("${app.thirdparty.company-AA-secretKey}")
    private String thirdpartyCompanyAASecretKey;

    @Value("${app.thirdparty.company-AA-get-detail-url}")
    private String thirdpartyCompanyAAGetDetailUrl;

    @Value("${app.thirdparty.company.AA-post-payment-url}")
    private String thirdpartyCompanyAAPostPaymentUrl;

    @Value("${app.thirdparty.company-BB-username}")
    private String thirdpartyCompanyBBUsername;

    @Value("${app.thirdparty.company-BB-password}")
    private String thirdpartyCompanyBBPassword;

    @Value("${app.thirdparty.company-BB-purchase-api-url}")
    private String thirdPartyCompanyBBPurchaseApiUrl;

    @Value("${app.thirdparty.microfinance-GGCompany-loan-url}")
    private String thirdPartyMicrofinanceGGCompanyLoanUrl;

    @Value("${app.thirdparty.operator-ooredoo-eload-topup-url}")
    private String thirdpartyOperatorOoredooEloadTopupUrl;

    @Value("${app.thirdparty.operator-telenor-package-url}")
    private String thirdpartyOperatorTelenorPackageUrl;


    // you can call this method only one time when application was started
    // for that case, you need to set return type as void, and declare ConfigObject outside that method and set value into that object from this below method.
    // you would have one method call getConfig and return ConfigObject.
    // you can reference method structure at AppConfigEnvironment class.
    public ConfigObject getConfigObject(){

        ConfigObject configObject = new ConfigObject();

        /** add application config values into pojo class **/
        configObject.setHeaderExcelColumn1(headerExcelColumn1);
        configObject.setHeaderExcelColumn2(headerExcelColumn2);
        configObject.setHeaderCsvColumn1(headerCSVColumn1);
        configObject.setName(configName);
        configObject.setUploadFileUrl(uploadFilePath);
        configObject.setSmtpPort(smtpPort);
        configObject.setEmailAddress(emailAddress);
        configObject.setEmailPassword(emailPassword);
        configObject.setPhoneNoPrefix(phoneNoPrefix);
        configObject.setKey(key);

        // no need to create list and it's already been list as we already split by comma in @Value for column list fields in above.
        configObject.setColumnListValues(columnListValues);

        // add into list, here, if you use configuration properties way, you don't need to add single string into list like below.
        List<String> recipientList = new ArrayList<String>();
        recipientList.add(recipient1);
        recipientList.add(recipient2);
        configObject.setDefaultEmailRecipientList(recipientList);


        /** add other services config values into pojo class **/
        configObject.setOtherInternalEmailServiceUrl(internalOtherServiceEmailUrl);
        configObject.setOtherInternalBillServiceUrl(internalOtherServiceBillUrl);
        configObject.setOtherInternalIntegrationServiceUrl(internalOtherServiceIntegrationUrl);
        configObject.setOtherInternalServiceSecret(internalOtherServiceSecret);


        /** add third party services config values into pojo class **/
        configObject.setThirdPartyAACompanyClientId(thirdpartyCompanyAAClientId);
        configObject.setThirdPartyAACompanySecretKey(thirdpartyCompanyAASecretKey);
        configObject.setThirdPartyAACompanyGetDetailUrl(thirdpartyCompanyAAGetDetailUrl);
        configObject.setThirdPartyAACompanyPostPaymentUrl(thirdpartyCompanyAAPostPaymentUrl);
        configObject.setThirdPartyBBCompanyUsername(thirdpartyCompanyBBUsername);
        configObject.setThirdPartyBBCompanyPassword(thirdpartyCompanyBBPassword);
        configObject.setThirdPartyBBCompanyPurchaseApiUrl(thirdPartyCompanyBBPurchaseApiUrl);
        configObject.setThirdPartyGGMicrofinanceCompanyLoanUrl(thirdPartyMicrofinanceGGCompanyLoanUrl);
        configObject.setThirdPartyOoredooOperatorEloadTopupUrl(thirdpartyOperatorOoredooEloadTopupUrl);
        configObject.setThirdPartyTelenorOperatorPackageUrl(thirdpartyOperatorTelenorPackageUrl);

        return configObject;

    }

}
