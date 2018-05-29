import com.journaldev.spring.mongodb.vanilla.VanillaForumConnectService;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.*;
import java.security.InvalidKeyException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Viktor on 25.05.2018.
 */
public class CookieManEX {
    public static void main(String[] args) {
        //URL FOR SSO
        String forumURL = "http://advocrowd-forum.andersenlab.com/vanilla-forum/";
        Map user = new LinkedHashMap();
        user.put("uniqueid", "27");
        user.put("email", "topixog@eth2btc.info");
        user.put("name", "topixog@eth2btc.info");


        RestTemplate restTemplate = new RestTemplate();
        String sso = null;
        try {
            sso = VanillaForumConnectService.SSOString(user);
        } catch (InvalidKeyException e) {
            //log.error("Login to forum failed.");
            e.printStackTrace();
        }
        String fullURL = forumURL+"index.php?sso="+sso;

        //Cookie manager
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);

        //creates url for the given string
        URL url = null;
        try {
            url = new URL(fullURL);

            //open's a connection with the url specified and returns URLConnection object
            URLConnection urlConnection = url.openConnection();
            // get's the contents from this url specifies
            urlConnection.getContent();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //returns the cookie store(bunch of cookies)
        CookieStore cookieStore = cookieManager.getCookieStore();

        //getting cookies which returns in the form of List of type HttpCookie
        List<HttpCookie> listOfcookies = cookieStore.getCookies();

        for(HttpCookie httpCookie: listOfcookies){

            System.out.println("Cookie Name : "+httpCookie.getName()+" Cookie Value : "+httpCookie.getValue());
        }
    }
}
