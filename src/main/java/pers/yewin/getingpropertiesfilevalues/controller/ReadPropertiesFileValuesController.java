package pers.yewin.getingpropertiesfilevalues.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yewin.getingpropertiesfilevalues.model.response.ReadConfigValuesResponse;
import pers.yewin.getingpropertiesfilevalues.model.response.ReadCustomFileConfigValuesReponse;
import pers.yewin.getingpropertiesfilevalues.service.ReadPropertiesFileValuesService;

/**
 * @author: Ye Win
 * @created: 29/09/2022
 * @project: getting-properties-file-values
 * @package: pers.yewin.getingpropertiesfilevalues.controller
 */

@RestController
public class ReadPropertiesFileValuesController {

    @Autowired
    ReadPropertiesFileValuesService readPropService;

    @GetMapping("/readByValueAnnotation")
    public ResponseEntity<?> readByValueAnnotation(){
        try {
            System.out.println("========== Start Read By Using Value Annotation Method ==========");
            ReadConfigValuesResponse readConfigValuesResponse = readPropService.readByValueAnnotation();
            System.out.println("========== End Read By Using Value Annotation Method ==========");
            return ResponseEntity.ok(readConfigValuesResponse);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/readByConfigurationProperties")
    public ResponseEntity<?> readByConfigurationProperties(){
        try {
            System.out.println("========== Start Read By Using Configuration Properties Method ==========");
            ReadConfigValuesResponse readConfigValuesResponse = readPropService.readByConfigurationProperties();
            System.out.println("========== End Read By Using Configuration Properties Method ==========");
            return ResponseEntity.ok(readConfigValuesResponse);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/readByEnvironment")
    public ResponseEntity<?> readByEnvironment(){
        try {
            System.out.println("========== Start Read By Using Environment Method ==========");
            ReadConfigValuesResponse readConfigValuesResponse = readPropService.readByEnvironment();
            System.out.println("========== End Read By Using Environment Method ==========");
            return ResponseEntity.ok(readConfigValuesResponse);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/readCustomFileConfigs")
    public ResponseEntity<?> readCustomFileConfigs(){
        try {
            System.out.println("========== Start Read Extra Custom File Configs ==========");
            ReadCustomFileConfigValuesReponse readCustomFileConfigValuesReponse = readPropService.readCustomFileConfigs();
            System.out.println("========== End Read Extra Custom File Configs ==========");
            return ResponseEntity.ok(readCustomFileConfigValuesReponse);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}
