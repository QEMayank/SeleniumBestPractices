package org.selenium.pom.api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.FakerUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AddCartApi {
    private Cookies cookies;

    public AddCartApi() {
    }

    public AddCartApi(Cookies cookies) {
        this.cookies=cookies;
    }







    public Response addToCart(int productId,int Quantity){
        Header header=new Header("Content-Type","application/x-www-form-urlencoded");
        Headers headers=new Headers(header);
        HashMap<String, Object> formParams=new HashMap<String, Object>();
        formParams.put("product_sku:","");
        formParams.put("product_id",productId);
        formParams.put("quantity",Quantity);

        if(cookies==null) {
             cookies=new Cookies();
        }

        Response response= given().
                baseUri(ConfigLoader.getInstance().getbaseURL()).
                cookies(cookies).
                headers(headers).
                formParams(formParams).
                log().all().
                when().
                post("/?wc-ajax=add_to_cart").

                then().
                log().all().
                extract().
                response();
        if(response.getStatusCode()!=200){
            throw new RuntimeException("Failed to get account information" + "HttpStatus code is="+response.getStatusCode());
        }
        this.cookies=response.getDetailedCookies();
        return response;

    }


    public static void main(String[] args) {


        SignUpApi signupapi= new SignUpApi();
        signupapi.register();
        AddCartApi addCartApi=new AddCartApi(signupapi.getCookies());
        addCartApi.addToCart(1215,4);

    }
}

