/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import java.io.StringWriter;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Crazian
 */
public class javaToJson {

    public static void main(String[] args) {
        try {
            javaBean obj_javaBean = new javaBean();            
            obj_javaBean.setCountryName("United States");
            obj_javaBean.setIpAddress("5.5.5.5.5.5");
            obj_javaBean.setCountryCode("US");
            obj_javaBean.setRegionName("California");
            obj_javaBean.setCityName("Los Angeles");
            obj_javaBean.setZipCode("90007");
            obj_javaBean.setLatitude("11.3656155");
            obj_javaBean.setLongitude("123.123");
            obj_javaBean.setTimeZone("-07:00");
            obj_javaBean.setStatusCode("Yes");
            obj_javaBean.setStatusMessage("Testing");
            ObjectMapper objectMapper = new ObjectMapper();
            StringWriter stringIt = new StringWriter();
            objectMapper.writeValue(stringIt, obj_javaBean);
            System.out.println("Here is an object converted to JSON \n" + stringIt);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
      
