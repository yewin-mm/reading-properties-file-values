package pers.yewin.getingpropertiesfilevalues.service;

import pers.yewin.getingpropertiesfilevalues.model.response.ReadConfigValuesResponse;
import pers.yewin.getingpropertiesfilevalues.model.response.ReadCustomFileConfigValuesReponse;

/**
 * @author: Ye Win
 * @created: 29/09/2022
 * @project: getting-properties-file-values
 * @package: pers.yewin.getingpropertiesfilevalues
 */

public interface ReadPropertiesFileValuesService {

    ReadConfigValuesResponse readByValueAnnotation();
    ReadConfigValuesResponse readByConfigurationProperties();
    ReadConfigValuesResponse readByEnvironment();
    ReadCustomFileConfigValuesReponse readCustomFileConfigs();
}
