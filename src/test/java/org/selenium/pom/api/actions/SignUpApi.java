package org.selenium.pom.api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.FakerUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SignUpApi {

    private Cookies cookies;

    public Cookies getCookies() {
        return cookies;
    }

    public String getNONCEValueUsingJsoup(){
        Response response=getAccount();
        Document doc= Jsoup.parse(response.body().prettyPrint());
        Element element=doc.selectFirst("#woocommerce-register-nonce");
        return element.attr("value");
    }

private Response getAccount(){
        Cookies cookies=new Cookies();
       Response response= given().
                baseUri(ConfigLoader.getInstance().getbaseURL()).
                cookies(cookies).
               log().all().
        when().
                get("/account").

        then().
               log().all().
                extract().
                response();
        if(response.getStatusCode()!=200){
            throw new RuntimeException("Failed to get account information" + "HttpStatus code is="+response.getStatusCode());
        }
        return response;

}



    protected Response register(){
        Cookies cookies=new Cookies();
        Header header=new Header("Content-Type","application/x-www-form-urlencoded");
        Headers headers=new Headers(header);
        HashMap<String,String> formParams=new HashMap<String,String>();
//        formParams.put("username","demouser"+FakerUtils.fakeNumbers().toString());
//        formParams.put("email","demouser10"+FakerUtils.fakeNumbers().toString()+"@mayank.com");
        formParams.put("username","demouser198");
        formParams.put("email","demouser198@mayank.com");

        formParams.put("password","demopwd");
        formParams.put("woocommerce-register-nonce",getNONCEValueUsingJsoup());
        formParams.put("_wp_http_referer","/account/");
        formParams.put("register","Register");

        Response response= given().
                baseUri(ConfigLoader.getInstance().getbaseURL()).
                cookies(cookies).
                headers(headers).
                formParams(formParams).
                log().all().
                when().
                post("/account").

                then().
                log().all().
                extract().
                response();
        if(response.getStatusCode()!=302){
            throw new RuntimeException("Failed to get account information" + "HttpStatus code is="+response.getStatusCode());
        }
        this.cookies=response.getDetailedCookies();
        return response;

    }

    public static void main(String[] args) {
       SignUpApi signupapi= new SignUpApi();
       signupapi.register();
        System.out.println(signupapi.getCookies());

    }


}
