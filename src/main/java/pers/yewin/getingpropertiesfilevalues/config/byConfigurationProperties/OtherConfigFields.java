package pers.yewin.getingpropertiesfilevalues.config.byConfigurationProperties;

import lombok.Data;

/**
 * @author: Ye Win
 * @created: 30/09/2022
 * @project: reading-properties-file-values
 * @package: pers.yewin.getingpropertiesfilevalues.config
 */


@Data // using lombok to get getter and setter method which is needed to inject data from properties file into fields by setter method, getter method is need for access field value from other class.
public class OtherConfigFields {

    /**
     * Declare all fields for different prefix, for app.internal and app.thirparty in application.properties
     * See the OtherConfigProperties class for separate prefix.
     * ConfigurationProperties bind with properties file
     * So, we need to make sure fields name are same with application.properties values.
     * No need to add internal and thirdparty because we will add that as prefix in OtherConfigProperties class.
     *
     */

    private String serviceEmailUrl;
    private String serviceBillUrl;
    private String serviceIntegrationUrl;
    private String serviceSecret;
    private String companyAAClientId;
    private String companyAASecretKey;
    private String companyAAGetDetailUrl;
    private String companyAAPostPaymentUrl;
    private String companyBBUsername;
    private String companyBBPassword;
    private String companyBBPurchaseApiUrl;
    private String microfinanceGGCompanyLoanUrl;
    private String operatorOoredooEloadTopupUrl;
    private String operatorTelenorPackageUrl;


}
