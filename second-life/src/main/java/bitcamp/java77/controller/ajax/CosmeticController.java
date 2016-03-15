package bitcamp.java77.controller.ajax;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import bitcamp.java77.domain.AjaxResult;
import bitcamp.java77.domain.CosmeticCounsel;
import bitcamp.java77.domain.CosmeticMember;
import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewComment;
import bitcamp.java77.domain.CosmeticReviewPhoto;
import bitcamp.java77.domain.CosmeticSearch;
import bitcamp.java77.service.CosmeticService;
import bitcamp.java77.util.MultipartHelper;

@Controller("ajax.CosmeticController")
@RequestMapping("/cosmetic/ajax/*")
public class CosmeticController {
	
	
	@Autowired
	CosmeticService cosmeticService;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value="sendMail", method=RequestMethod.POST)
	public void sendMail(CosmeticCounsel cosmeticConsel) throws Exception, MessagingException {
		// 메일 관련 정보
        String host 	= "smtp.gmail.com";
        String username = "77secondlife@gmail.com";
        String password = "3whxptmxm";
         
        // 메일 내용
        String recipient = "kkokkodaek87@naver.com";
        String subject   = "상담 신청 메일 발송";
         
        //properties 설정
        Properties props = new Properties();
        props.put("mail.smtps.auth", "true");
        
        // 메일 세션
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
 
        // 메일 관련
        msg.setSubject(subject);
        Multipart multipart = new MimeMultipart();
        MimeBodyPart body = new MimeBodyPart();
        body.setContent(  "<table style='border: 1px solid #000000; border-collapse: collapse;'>"
		        		+ "		<tr style='border: 1px solid #000000; border-collapse: collapse;'>"
		        		+ "			<th style='border: 1px solid #000000; border-collapse: collapse;'>이름</th>"
		        		+ "			<td style='border: 1px solid #000000; border-collapse: collapse;'>"+ cosmeticConsel.getName() +"</td>"
		        		+ "		</tr>"
		        		+ "		<tr style='border: 1px solid #000000; border-collapse: collapse;'>"
		        		+ "			<th style='border: 1px solid #000000; border-collapse: collapse;'>나이</th>"
		        		+ "			<td style='border: 1px solid #000000; border-collapse: collapse;'>"+ cosmeticConsel.getAge() +"</td>"
		        		+ "		</tr>"
		        		+ "		<tr style='border: 1px solid #000000; border-collapse: collapse;'>"
		        		+ "			<th style='border: 1px solid #000000; border-collapse: collapse;'>시술법</th>"
		        		+ "			<td style='border: 1px solid #000000; border-collapse: collapse;'>"+ cosmeticConsel.getSway() +"</td>"
		        		+ "		</tr>"
		        		+ "		<tr style='border: 1px solid #000000; border-collapse: collapse;'>"
		        		+ "			<th style='border: 1px solid #000000; border-collapse: collapse;'>연락처</th>"
		        		+ "			<td style='border: 1px solid #000000; border-collapse: collapse;'>"+ cosmeticConsel.getTel() +"</td>"
		        		+ "		</tr>"
		        		+ "		<tr style='border: 1px solid #000000; border-collapse: collapse;'>"
		        		+ "			<th style='border: 1px solid #000000; border-collapse: collapse;'>상담내용</th>"
		        		+ "			<td style='border: 1px solid #000000; border-collapse: collapse;'>"+ cosmeticConsel.getContent() +"</td>"
		        		+ "		</tr>"
		        		+ "</table>"
		        		+ "</body>"
		        		+ "</html>", "text/html;charset=UTF-8");
        multipart.addBodyPart(body);
        msg.setContent(multipart);
//        msg.setText(body);
        msg.setFrom(new InternetAddress(username));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
        // 발송 처리
        Transport transport = session.getTransport("smtps");
        transport.connect(host, username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();  
	}
	
	@RequestMapping(value="join")
	public void join(CosmeticMember cosmeticMember) throws Exception {
		cosmeticService.insertMember(cosmeticMember);
	}
	
	@RequestMapping(value="idCheck")
	public AjaxResult idCheck(CosmeticMember cosmeticMember) throws Exception {
		int num    = cosmeticService.searchID(cosmeticMember.getId());
		String msg = "";
		
		if(num == 0) {
			msg = "사용 가능한 ID 입니다.";
		} else {
			msg = "이미 사용중인 ID 입니다.";
		}
		
		return new AjaxResult("success", msg);
	}
	
	@RequestMapping(value="reviewList",method=RequestMethod.GET)
	public Object reviewList(@RequestParam(name="pageNo",defaultValue="0")int pageNo,HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		CosmeticMember member =  (CosmeticMember)session.getAttribute("loginuser");
		
		pageNo = (pageNo == 0) ? 1 : pageNo;
		
		CosmeticSearch search = new CosmeticSearch();
		search.setStart((pageNo - 1) * 6); // +1을 안하는 이유는 Mysql limit함수 인덱스가 0부터 시작하기 때문이다...
		search.setEnd(pageNo * 6);
		
		
		List<CosmeticReview> list = cosmeticService.selectReviewList(search);
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("reviewList", list);
		resultMap.put("status", "success");
		resultMap.put("member", member);
		
		return resultMap;
	}
	
	@RequestMapping(value="mainReview",method=RequestMethod.GET)
	public Object mainReview(@RequestParam(name="pageNo",defaultValue="0")int pageNo,HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		CosmeticMember member =  (CosmeticMember)session.getAttribute("loginuser");
		
		pageNo = (pageNo == 0) ? 1 : pageNo;
		
		CosmeticSearch search = new CosmeticSearch();
		search.setStart((pageNo - 1) * 6); // +1을 안하는 이유는 Mysql limit함수 인덱스가 0부터 시작하기 때문이다...
		search.setEnd(pageNo * 6);
		
		
		List<CosmeticReview> list = cosmeticService.selectReviewList(search);
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("reviewList", list);
		resultMap.put("member", member);
		resultMap.put("status", "success");
		
		return resultMap;
	}
	
	@RequestMapping(value="reviewListDetail",method=RequestMethod.GET)
	public AjaxResult reviewListDetail(int reviewNo,HttpServletRequest req) throws Exception{
		// 로그인 세션정보 가져오기
		HttpSession session = req.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		
		HashMap<String, Object> resultMap = new HashMap<>();
		CosmeticReview review = cosmeticService.selectReviewListDetail(reviewNo);
		List<CosmeticReviewComment> comment  = cosmeticService.selectReviewComment(reviewNo);
		List<CosmeticReviewPhoto> reviewPhoto = cosmeticService.selectReviewPhoto(reviewNo);
		resultMap.put("review", review);
		resultMap.put("comment", comment);
		resultMap.put("photo", reviewPhoto);
		resultMap.put("member", member);
		
		return new AjaxResult("success", resultMap);
	}
	
	@RequestMapping(value="reviewAdd",method=RequestMethod.POST)
	public AjaxResult reviewAdd(CosmeticReview cosmeticReview, @RequestParam("files") MultipartFile[] files) throws Exception{
		CosmeticReviewPhoto cosmeticReviewPhoto = new CosmeticReviewPhoto();
		
		// reviewNo 추출
		cosmeticService.insertReview(cosmeticReview);
     	int reviewNo = cosmeticReview.getReviewNo();
		
	    for (MultipartFile file : files) {
	      if (file.getSize() > 0) {
	        String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());
	        
	        // DB에 저장되는 경로
	        String fileDBPath = "/second-life/reviewPhoto/";
	        
	        // 폴더 지정
	     	String saveFolder = servletContext.getRealPath("/reviewPhoto/");
	     	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	     	String path = sdf.format(new Date());
	     	
	     	// DB에 저장되는 경로
	     	fileDBPath += sdf.format(new Date()) + "/";
	     	
	     	// 실제 파일 저장경로
	     	saveFolder += path;
	     	File f = new File(saveFolder);
	     	f.mkdirs();
	        
	     	String filePath = saveFolder + "/" + newFileName;
	     	fileDBPath += newFileName;
	     	file.transferTo(new File(filePath));
	     	cosmeticReviewPhoto.setReviewNo(reviewNo);
	     	cosmeticReviewPhoto.setFilePath(fileDBPath);
	     	cosmeticService.insertReviewPhoto(cosmeticReviewPhoto);
	      }
	    }
		
	    
		return new AjaxResult("success",null);
	}

	@RequestMapping(value="login", method=RequestMethod.POST)
	public AjaxResult login(HttpServletRequest req) throws Exception {
		CosmeticMember member = new CosmeticMember();
		member.setId(req.getParameter("id"));
		member.setPwd(req.getParameter("password"));
		int no = cosmeticService.selectLogin(member);
		
		String msg = "fail";
		member =cosmeticService.selectMember(no);
		HttpSession session = null;
		
		if(member != null){
			// 세션에 로그인 객체를 등록
			session = req.getSession();
			msg = "success";
			session.setAttribute("loginuser", member);
		}
		return new AjaxResult(msg,member);
	}
	
	@RequestMapping(value="logout", method=RequestMethod.POST)
	public AjaxResult logout(HttpSession session) throws Exception{
		session.invalidate();
		return new AjaxResult("success", null);
	}
	
	@RequestMapping(value="loginCheck", method=RequestMethod.GET)
	public AjaxResult loginCheck(HttpServletRequest req) throws Exception{
		// 세션정보 가져오기
		HttpSession session = req.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		return new AjaxResult("success", member);
	}
}
