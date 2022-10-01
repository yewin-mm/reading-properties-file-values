package pers.yewin.getingpropertiesfilevalues.model.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author: Ye Win
 * @created: 01/10/2022
 * @project: reading-properties-file-values
 * @package: pers.yewin.getingpropertiesfilevalues.mode.pojo
 */

@Data
public class ConfigObject {

    /**
     * Actually this class is no need because you can only pull your needed fields in your service class.
     * But here, I want to add all config fields in one place to show as demo. So, I created this class.
     */


    // config fields for this application
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
    private List<String> columnListValues;
    private List<String> defaultEmailRecipientList;

    // config fields for other microservices
    private String otherInternalEmailServiceUrl;
    private String otherInternalBillServiceUrl;
    private String otherInternalIntegrationServiceUrl;
    private String otherInternalServiceSecret;

    // config fields for thirdparty services
    private String thirdPartyAACompanyClientId;
    private String thirdPartyAACompanySecretKey;
    private String thirdPartyAACompanyGetDetailUrl;
    private String thirdPartyAACompanyPostPaymentUrl;
    private String thirdPartyBBCompanyUsername;
    private String thirdPartyBBCompanyPassword;
    private String thirdPartyBBCompanyPurchaseApiUrl;
    private String thirdPartyGGMicrofinanceCompanyLoanUrl;
    private String thirdPartyOoredooOperatorEloadTopupUrl;
    private String thirdPartyTelenorOperatorPackageUrl;
}
