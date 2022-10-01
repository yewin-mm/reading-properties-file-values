package pers.yewin.getingpropertiesfilevalues.model.response;

import lombok.Data;
import pers.yewin.getingpropertiesfilevalues.model.pojo.CustomFileConfigObject;

/**
 * @author: Ye Win
 * @created: 30/09/2022
 * @project: reading-properties-file-values
 * @package: pers.yewin.getingpropertiesfilevalues.model.response
 */

@Data
public class ReadCustomFileConfigValuesReponse {
    private String description;
    private String readType;
    private CustomFileConfigObject customFileConfigValues;
}
