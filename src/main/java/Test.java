import java.io.IOException;
import java.net.*;
import java.util.List;

/**
 * Created by Viktor on 25.05.2018.
 */
public class Test {
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);

        //creates url for the given string
        URL url = null;
        try {
            url = new URL("http://advocrowd-forum.andersenlab.com/vanilla-forum/?sso=eyAidW5pcXVlaWQiOiAiMjciLCAiZW1haWwiOiAidG9waXhvZ0BldGgyYnRjLmluZm8iLCAibmFtZSI6ICJ0b3BpeG9nQGV0aDJidGMuaW5mbyIsICJjbGllbnRfaWQiOiAiMTY1NTMyOTgxMCIgfQ== d9934ba618ed6c99fc2543c0cc084832d60228ec 1527231684 hmacsha1");

            //open's a connection with the url specified and returns URLConnection object
            URLConnection  urlConnection = url.openConnection();
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
