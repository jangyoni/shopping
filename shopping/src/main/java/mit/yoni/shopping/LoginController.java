package mit.yoni.shopping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import net.sf.json.JSONSerializer;
import service.ShopService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;
import com.mysql.cj.Session;

import domain.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/*")
@Controller
@Log4j
public class LoginController {
	
	@Autowired
    private ShopService service;
	
	@GetMapping("naver-login")
	public String login(String code, String state) throws UnsupportedEncodingException {
		System.out.println("코드" +code);
		System.out.println("상태"+state);
		//여기까지 코드랑 상태를 가져온 코드임다
		String clientId = "K_lDw_1U5bAKyac1rt2l";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "yHav2PovYT";//애플리케이션 클라이언트 시크릿값";
	    String redirectURI = URLEncoder.encode("http://localhost:8080/login/naver-login", "UTF-8");  
	    String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"
	        + "&client_id=" + clientId
	        + "&client_secret=" + clientSecret
	        + "&redirect_uri=" + redirectURI
	        + "&code=" + code
	        + "&state=" + state;
	    String accessToken = "";
	    String refresh_token = "";
	    JSONObject user;
	    String name;
	    String id;
	    String email;
	    String birthday;
	    String birthyear;
	    String mobile;
	    
	    // 토큰 가져오기
	    try {
		      URL url = new URL(apiURL);
		      HttpURLConnection con = (HttpURLConnection)url.openConnection();
		      con.setRequestMethod("GET");
		      int responseCode = con.getResponseCode();
		      BufferedReader br;
		      if (responseCode == 200) { // 정상 호출
		        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		      } else {  // 에러 발생
		        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		      }
		      String inputLine;
		      StringBuilder res = new StringBuilder();
		      while ((inputLine = br.readLine()) != null) {
		        res.append(inputLine);
		      }
		      br.close();
		      if (responseCode == 200) {
		    	  JSONObject jsonObj = new JSONObject(res.toString());
		          accessToken = jsonObj.getString("access_token");
		          refresh_token = jsonObj.getString("refresh_token"); //토큰 제이슨 형태에서 바꾸기
			      }
		    } catch (Exception e) {
		      // Exception 로깅
		    }
		    String profileApiURL = "https://openapi.naver.com/v1/nid/me";
	        try {
            URL url = new URL(profileApiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer " + accessToken);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else { // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuilder res = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                res.append(inputLine);
            }
            br.close();
            if (responseCode == 200) {
           
                JSONObject userProfile = new JSONObject(res.toString());
                UserVO vo = new UserVO();
                user = userProfile.getJSONObject("response");
                name = user.getString("name"); //토큰 제이슨 형태에서 바꾸기
                id = user.getString("id");
                email = user.getString("email");
                birthday = user.getString("birthday");
                birthyear = user.getString("birthyear");
                mobile = user.getString("mobile");
                vo.setId(id);
                UserVO vo2 = service.signin(vo);
                if(vo2==null) { //디비에 해당유저가 존재하지않을때
                	//vo는 네이버에서 받아온거 vo2는 디비에서 가져온거임
                	vo.setId(id);
                	vo.setName(name);
                	vo.setEmail(email);
                	vo.setMobile(mobile);
                	vo.setName(name);
                	vo.setBirthday(birthday);
                	vo.setBirthyear(birthyear);
                	int a=service.signup(vo);
                	if(a==0) {
                		// 다시 로그인해라 디비에 입력하는게 실패했을때
                		
                	}else {
                		//세션에 유저정보를 넣고 main으로 redirect를 해라 ~~! 디비입력한걸 성공했을때
                		return "redirect:main"; //세션에 vo를 넣어준다.
                	}
                }else {
                	System.out.println("이미 잇는사용자"); //디비에 해당하는 유저가 존재할때
                	//존재할때 세션에 vo2를 넣어준다.
                }
                
            } else {
                System.out.println("프로필 조회 실패: " + res.toString());
            }
        } catch (Exception e) {
            e.printStackTrace(); // Exception 로깅
        }
	        return "main";
	}
}
