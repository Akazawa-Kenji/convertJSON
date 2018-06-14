/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Crazian
 */
public class jsonToJava {

    public static void main(String[] args) {
        try {
            jsonToJava.convert_jsonToJava();
        } catch (Exception e) {
            System.out.println(e);
            //Try catch to print Error
        }
    }

    public static void convert_jsonToJava() throws Exception {
        String ip = "73.254.24.123";
        //my IP address
        String key = "8bb429ea380bb5e161a7ea25cff2bcf4b748f8696a00e9326099c363a9ce67c1";
        //API from www.ipinfodb.com

        String url = "http://api.ipinfodb.com/v3/ip-city/?key=" + key + "&ip=" + ip + "&format=json";
        URL obj = new URL(url);
        HttpURLConnection connect = (HttpURLConnection) obj.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("User", "Google");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connect.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

        ObjectMapper obj_ObjectMapper = new ObjectMapper();
        //creating an instance of ObjectMapper

        javaBean obj_javaBean = new javaBean();
        //creating javaBean Object to allow us to conver

        obj_javaBean = obj_ObjectMapper.readValue(response.toString(), javaBean.class);
        //readValue converts JSON into a Java Object. Getting response from server allows us the read the Value of the javaBean Object

        System.out.println("---Afer converting JSON to java object we can access it's properties---");
        System.out.println("ipAddress:" + obj_javaBean.getIpAddress());
        System.out.println("countryCode:" + obj_javaBean.getCountryCode());
        System.out.println("countryName:" + obj_javaBean.getCountryName());
        System.out.println("regionName:" + obj_javaBean.getRegionName());
        System.out.println("cityName:" + obj_javaBean.getCityName());
        System.out.println("zipCode:" + obj_javaBean.getZipCode());
        System.out.println("latitude:" + obj_javaBean.getLatitude());
        System.out.println("longitude:" + obj_javaBean.getLongitude());
        System.out.println("timeZone:" + obj_javaBean.getTimeZone());
        System.out.println("statusCode:" + obj_javaBean.getStatusCode());
        System.out.println("statusMessage:" + obj_javaBean.getStatusMessage());
    }
}
