package com.booksLover.java.book.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booksLover.java.book.service.BookService;


/**
 * @create 01/25/23
 * @author sunjin
 * @title Naver Book Search ServiceImplement
 */
@Service
public class BookServicempl implements BookService {
	
	
	@Override
	@Transactional(readOnly = true)
	public Object doSearch(String keyword) {
        //1. 검색어 가져오기
        
        if( keyword != null && !keyword.equals("")) {
        	//2. OpenAPI 요청 -> 결과 반환(JSON)
        	String stringResult = search(keyword);
        	
        	//3. JSON 분석 -> 자바 형태로 변환
        	JSONParser jsonParser = new JSONParser(); //json안에 json이 있을 때 

        	//4. 제이슨 객체 생성
    		JSONObject jsonObj = new JSONObject(); //중괄호에 들어갈 속성
    		
    		JSONArray jsonArray = new JSONArray(); //대괄호 정의(json들이 들어있는 Array(json 이외의 다른 데이트도 들어갈 수 있음)
    		
    		
			try {
				//스트링 -> JSON형태로 파싱 -> 제이슨 객체로 형변환
				jsonObj = (JSONObject) jsonParser.parse(stringResult);
				
				System.out.println("jsonObj타입"+jsonObj.get("items").getClass().getName());
				System.out.println("jsonObj"+jsonObj);
				
				// JSON정보를 담을 Array 선언
//				HashMap<String, Object> hashMap = new HashMap<String, Object>();
//				ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
//				
//				hashMap.put("bookInfo", (JSONObject)jsonParser.parse(stringResult));
//				System.out.println("해시맵"+ hashMap);
//				hashMap.put("total", list);
				
//				System.out.println(jsonObj);
//				jsonObj.put(jsonObj[0]);
				
				//5. 총 검색건수
				String total = jsonObj.get("total").toString();
				System.out.println("검색결과: "+total);
//				jsonObj.put("total", total);
				
				// 4. 제이슨 배열에 제이슨 객체 담기 // 대괄호 정의
				JSONArray arrayResult = (JSONArray) jsonObj.get("items");
				System.out.println();
				return arrayResult;
				
			} catch (ParseException e) {
				e.printStackTrace();
			}

        }
		return keyword;
	}
	
	
	private static String search(String keyword) {
        String clientId = "3R9T8D3kQyU8MikI2dNK"; // 아이디
        String clientSecret = "ZmejvEeVGQ"; // 시크릿


        String text = null;
        try {
            text = URLEncoder.encode(keyword, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text + "&display=20&start=1";    // JSON 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders); //응답받을 get함수


//        System.out.println(responseBody.getClass().getSimpleName());
        return responseBody;
    }

    //응답받을 get함수
    private static String get(String apiUrl, Map<String, String> requestHeaders){
        // 스트림 연결
    	HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출(200)
                
                /*
                 * 스트림은 단방향이라 입력과 출력이 동시에 발생할 수 없다.
                 * 그렇기 때문에 용도에 따라 입력스트림 출력스트림으로 나뉘며, 둘은 분리되어 있다.
                 * (IO가 꼭 하드웨어일 필요는 없다.)
                 * 
                 * 자바에서 가장 기본이 되는 입력 스트림은 InputStream이다.
                 * 반대로 출력스트림은 OutputStream이다.
                 * 
                 * [System.in]
                 * System 클래스의 in이라는 필드는 InputStream의 정적필드다.
                 * 그래서 System 클래스의 in 변수는 '표준 입력 스트림'이며 일반적으로
                 * 콘솔, 명령줄 인수 등을 통해 입력을 받을 수 있다.
                 * 
                 * 즉, in이라는 변수는 InputStream의 변수이다.
                 */
            	
            	
            	// 들어온 인풋스트림으로 웹 정보를 파싱하는 부분
            	// 웹 정보 마다 다른 문자열 타입일 수 있으므로 맞는 문자열 셋팅을 해줘야 함
            	return readBody(con.getInputStream()); //Http 입력스트림 가져오기
            	
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) { 
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    // 응답받을 connect 함수
    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl); // 커넥션 생성
            //접속을 확립한뒤 헤더 필드와 내용에 액세스 하려면 다음의 메서드를 사용합니다.
            return (HttpURLConnection)url.openConnection(); // url 연결
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


	// 요청받은 값을 읽어들이는 함수
    private static String readBody(InputStream body){
    	//InputStreamReader : '문자'를 처리함.
        InputStreamReader InputStreamReader = new InputStreamReader(body);

        // BufferedReader
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // byte 타입으로 읽어들이는 in을 char 타입으로 처리한 뒤 String, 
        // 즉 문자열로 저장할 수 있게 한다는 의미로 해석할 수 있다.
        // 버퍼가 있는 스트림이다.
        // 별다른 정규식을 검사하지 않는다.
        // -> 하나하나 문자를 보내는 것이 아닌 한 번에 모아둔 다음 보내니 훨씬 속도가 빠르고 별다른 정규식을 검사하지 않으니 더더욱 속도는 빠를 수밖에 없다.
        
        
        // 버퍼연결(문자열)
        try (BufferedReader lineReader = new BufferedReader(InputStreamReader)) { //문자열 세팅
            
        	// StringBuilder은 ArrayList<String>과 비슷하다.
        	// append로 String을 저장한 뒤 호출하면 쭉 읽는다.
        	StringBuilder responseBody = new StringBuilder(); //String을 배열로 저장하여 한번에 출력
        	
            
            String line; 
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }
            
            return responseBody.toString(); // 결과값을 읽어 String형태로 search함수에서 받아옴
            
            
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }

}
