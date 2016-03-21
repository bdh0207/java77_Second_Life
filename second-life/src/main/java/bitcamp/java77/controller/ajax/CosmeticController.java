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

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import javax.mail.internet.MimeUtility;

import bitcamp.java77.domain.AjaxResult;
import bitcamp.java77.domain.CosmeticCounsel;
import bitcamp.java77.domain.CosmeticHospital;
import bitcamp.java77.domain.CosmeticMember;
import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewComment;
import bitcamp.java77.domain.CosmeticReviewPhoto;
import bitcamp.java77.domain.CosmeticReviewRecom;
import bitcamp.java77.domain.CosmeticSearch;
import bitcamp.java77.domain.CosmeticWish;
import bitcamp.java77.service.CosmeticService;
import bitcamp.java77.util.MultipartHelper;

@Controller("ajax.CosmeticController")
@RequestMapping("/cosmetic/ajax/*")
public class CosmeticController {
	
	
	@Autowired
	CosmeticService cosmeticService;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value="hospitalInfo")
	public AjaxResult hospitalInfo() throws Exception {
		// 병원 정보 불러오기
		List<CosmeticHospital> hospitalInfoList = cosmeticService.hospitalInfo();
		System.out.println(hospitalInfoList.size());
		return new AjaxResult("success", hospitalInfoList);
	}
 
	@RequestMapping(value="selectMemInfo", method=RequestMethod.GET)
	public AjaxResult selectMemInfo(HttpServletRequest req) throws Exception {
		HttpSession session   = req.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");

		member = cosmeticService.selectMember(member);
		
		return new AjaxResult("success", member);
	}

	@RequestMapping(value="viewInfo")
	public AjaxResult viewInfo(int reviewNo) throws Exception {
		CosmeticReview review = cosmeticService.selectSurgeryInfo(reviewNo);
		return new AjaxResult("success", review);
	}
	
//	@RequestMapping(value="sendMail", method=RequestMethod.POST)
//	public void sendMail(CosmeticCounsel cosmeticConsel) throws Exception, MessagingException {
//		// 메일 관련 정보
//        String host 	= "smtp.gmail.com";
//        String username = "77secondlife@gmail.com";
//        String password = "3whxptmxm";
//         
//        // 메일 내용
//        String recipient = cosmeticConsel.getEmail();
//        String subject   = "상담 신청 메일 발송";
//         
//        //properties 설정
//        Properties props = new Properties();
//        props.put("mail.smtps.auth", "true");
//        
//        // 메일 세션
//        Session session = Session.getDefaultInstance(props);
//        MimeMessage msg = new MimeMessage(session);
// 
//        // 메일 관련
//        msg.setSubject(subject);
//        Multipart multipart = new MimeMultipart();
//        MimeBodyPart body   = new MimeBodyPart();
//         
//        body.setContent(  "<table style='width: 700px; border: 1px solid #000000; border-collapse: collapse;'>"
//		        		+ "		<tr style='border: 1px solid #000000; border-collapse: collapse; height: 30px;'>"
//		        		+ "			<th style='border: 1px solid #000000; border-collapse: collapse; width: 100px;'>이름</th>"
//		        		+ "			<td style='border: 1px solid #000000; border-collapse: collapse; padding-left: 10px;'>"+ cosmeticConsel.getName() +"</td>"
//		        		+ "		</tr>"
//		        		+ "		<tr style='border: 1px solid #000000; border-collapse: collapse; height: 30px;'>"
//		        		+ "			<th style='border: 1px solid #000000; border-collapse: collapse;'>나이</th>"
//		        		+ "			<td style='border: 1px solid #000000; border-collapse: collapse; padding-left: 10px;'>"+ cosmeticConsel.getAge() +"</td>"
//		        		+ "		</tr>"
//		        		+ "		<tr style='border: 1px solid #000000; border-collapse: collapse; height: 30px;'>"
//		        		+ "			<th style='border: 1px solid #000000; border-collapse: collapse;'>연락처</th>"
//		        		+ "			<td style='border: 1px solid #000000; border-collapse: collapse; padding-left: 10px;'>"+ cosmeticConsel.getTel() +"</td>"
//		        		+ "		</tr>"
//		        		+ "		<tr style='border: 1px solid #000000; border-collapse: collapse; height: 30px;'>"
//		        		+ "			<th style='border: 1px solid #000000; border-collapse: collapse;'>시술법</th>"
//		        		+ "			<td style='border: 1px solid #000000; border-collapse: collapse; padding-left: 10px;'>"+ cosmeticConsel.getSurgeryWay() +"</td>"
//		        		+ "		</tr>"
//		        		+ "		<tr style='border: 1px solid #000000; border-collapse: collapse; height: 30px;'>"
//		        		+ "			<th style='border: 1px solid #000000; border-collapse: collapse;'>상담내용</th>"
//		        		+ "			<td style='border: 1px solid #000000; border-collapse: collapse; padding-left: 10px;'>"+ cosmeticConsel.getContent() +"</td>"
//		        		+ "		</tr>"
//		        		+ "</table>"
//		        		+ "</body>"
//		        		+ "</html>", "text/html;charset=UTF-8");
//        
//        multipart.addBodyPart(body);
//        msg.setContent(multipart);
//        msg.setFrom(new InternetAddress(username));
//        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
// 
//        // 발송 처리
//        Transport transport = session.getTransport("smtps");
//        transport.connect(host, username, password);
//        transport.sendMessage(msg, msg.getAllRecipients());
//        transport.close();  
//	}
	
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
	public AjaxResult reviewListDetail(@RequestParam(name="pageNo",defaultValue="0")int pageNo,int reviewNo,HttpServletRequest req) throws Exception{
		
		// 로그인 세션정보 가져오기
		HttpSession session = req.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		
		// 페이징 관련변수
		pageNo = (pageNo == 0) ? 1 : pageNo;
		CosmeticSearch search = new CosmeticSearch();
		
		search.setStart((pageNo-1)*5);
		search.setEnd(pageNo * 5);
		search.setReviewNo(reviewNo);
		
		HashMap<String, Object> resultMap = new HashMap<>();
		CosmeticReview review = cosmeticService.selectReviewListDetail(reviewNo);
		HashMap<String, Object> result  = cosmeticService.selectReviewComment(search);
		// 댓글 리스트 가져오기
		List<CosmeticReviewComment> comment = (List<CosmeticReviewComment>)result.get("comment");
		List<CosmeticReviewPhoto> reviewPhoto = cosmeticService.selectReviewPhoto(reviewNo);
		
		// 페이징을 위한 변수 정리
		// 전체 게시물 수
		int cnt = (Integer)result.get("cnt");
		
		// 마지막 페이지
		int lastPage = (cnt % 5 ==0) ? cnt / 5 : cnt/ 5 + 1;
		
		// 현재 화면의 탭
		int currTab = (pageNo-1)/5 + 1;
		
		// 화면의 시작 페이지 번호
		int beginPage = (currTab-1) * 5 +1;
		
		// 화면의 마지막 페이지 번호
		int endPage = (currTab * 5 > lastPage) ? lastPage : currTab * 5;
		
		
		resultMap.put("review", review);
		resultMap.put("comment", comment);
		resultMap.put("photo", reviewPhoto);
		resultMap.put("member", member);
		resultMap.put("pageNo", pageNo);
		resultMap.put("beginPage", beginPage);
		resultMap.put("lastPage", lastPage);
		resultMap.put("endPage", endPage);
		resultMap.put("commentCnt", cnt);
		
		return new AjaxResult("success", resultMap);
	}
	
	@RequestMapping(value="reviewAdd",method=RequestMethod.POST)
	public AjaxResult reviewAdd(MultipartHttpServletRequest mRequest) throws Exception{
		HttpSession session = mRequest.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		
		SimpleDateFormat transFormat  = new SimpleDateFormat("yyyy-MM-dd");
		CosmeticReviewPhoto cosmeticReviewPhoto = new CosmeticReviewPhoto();
		CosmeticReview cosmeticReview = new CosmeticReview();
		
		cosmeticReview.setMemberNo(member.getMemberNo());
		cosmeticReview.setTitle(mRequest.getParameter("title"));
		cosmeticReview.setContent(mRequest.getParameter("content"));
		cosmeticReview.setSugeryPart(mRequest.getParameter("sugeryPart"));
		String str = mRequest.getParameter("status");
		char status = str.charAt(0);
		cosmeticReview.setStatus(status);
		// 상태값이 1이면 수술정보에 관련된 데이터를 insert한다.
		if(status == '1'){
			cosmeticReview.setHospitalName(mRequest.getParameter("hospitalName"));
			cosmeticReview.setDoctorName(mRequest.getParameter("doctorName"));
			cosmeticReview.setSugeryWay(mRequest.getParameter("sugeryWay"));
			cosmeticReview.setSugeryPrice(Integer.parseInt(mRequest.getParameter("sugeryPrice")));
			cosmeticReview.setSugeryDate(transFormat.parse(mRequest.getParameter("sugeryDate"))); // String to Date
		}
		
		// reviewNo 추출
		cosmeticService.insertReview(cosmeticReview);
		transFormat = null;
     	int reviewNo = cosmeticReview.getReviewNo();
     	
     	Iterator<String> files = mRequest.getFileNames();
     	while(files.hasNext()){
     		String fName = files.next();
     		MultipartFile file = mRequest.getFile(fName);
     		
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
		return new AjaxResult("success",null);
	}
	
	@RequestMapping(value="reviewUpdate", method=RequestMethod.POST)
	public AjaxResult reviewUpdate(MultipartHttpServletRequest mRequest) throws Exception{
		HttpSession session = mRequest.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		
		SimpleDateFormat transFormat  = new SimpleDateFormat("yyyy-MM-dd");
		CosmeticReviewPhoto cosmeticReviewPhoto = new CosmeticReviewPhoto();
		CosmeticReview cosmeticReview = new CosmeticReview();
		
		cosmeticReview.setReviewNo(Integer.parseInt(mRequest.getParameter("reviewNo")));
		cosmeticReview.setMemberNo(member.getMemberNo());
		cosmeticReview.setTitle(mRequest.getParameter("title"));
		cosmeticReview.setContent(mRequest.getParameter("content"));
		cosmeticReview.setSugeryPart(mRequest.getParameter("sugeryPart"));
		String str = mRequest.getParameter("status");
		char status = str.charAt(0);
		cosmeticReview.setStatus(status);
		// 상태값이 1이면 수술정보에 관련된 데이터를 insert한다.
		if(status == '1'){
			cosmeticReview.setHospitalName(mRequest.getParameter("hospitalName"));
			cosmeticReview.setDoctorName(mRequest.getParameter("doctorName"));
			cosmeticReview.setSugeryWay(mRequest.getParameter("sugeryWay"));
			cosmeticReview.setSugeryPrice(Integer.parseInt(mRequest.getParameter("sugeryPrice")));
			cosmeticReview.setSugeryDate(transFormat.parse(mRequest.getParameter("sugeryDate"))); // String to Date
		}
		
		// reviewNo 추출
		cosmeticService.updateReview(cosmeticReview);
		transFormat = null;
     	int reviewNo = cosmeticReview.getReviewNo();
     	
     	List<CosmeticReviewPhoto> list = cosmeticService.selectReviewPhotoNo(reviewNo);
     	// 사진 번호 인덱스
     	int i = 0;
     	
     	// 파일 관련 로직
     	Iterator<String> files = mRequest.getFileNames();
     	while(files.hasNext()){
     		String fName = files.next();
     		MultipartFile file = mRequest.getFile(fName);
     		
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
	     	cosmeticReviewPhoto.setPhotoNo(list.get(i).getPhotoNo());
	     	cosmeticReviewPhoto.setReviewNo(reviewNo);
	     	cosmeticReviewPhoto.setFilePath(fileDBPath);
	     	cosmeticService.updateReviewPhoto(cosmeticReviewPhoto);
	     	i++;
     	}
		
		
		return new AjaxResult("success",null);
	}
	
	@RequestMapping(value="reviewDelete", method=RequestMethod.GET)
	public AjaxResult reviewDelete(int reviewNo, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		
		CosmeticReview cosmeticReview = new CosmeticReview();
		cosmeticReview.setReviewNo(reviewNo);
		cosmeticReview.setMemberNo(member.getMemberNo());
		
		String msg = "fail";
		// 유저번호와 게시물번호로 일치하는 데이터가 있는지 확인
		int cnt = cosmeticService.selectReviewMatch(cosmeticReview);
		
		if(cnt != 0){
			msg = "success";
			cosmeticService.deleteReview(cosmeticReview);
		}
		
		return new AjaxResult(msg,null);
	}
	
	// 권한 체크
	@RequestMapping(value="authority",method=RequestMethod.GET)
	public AjaxResult authorityCheck(int reviewNo, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		
		CosmeticReview cosmeticReview = new CosmeticReview();
		cosmeticReview.setReviewNo(reviewNo);
		cosmeticReview.setMemberNo(member.getMemberNo());
		
		String msg = "fail";
		int cnt = cosmeticService.selectReviewMatch(cosmeticReview);
		
		if(cnt != 0){
			msg = "success";
		}
		
		return new AjaxResult(msg,null);
	}

	@RequestMapping(value="login", method=RequestMethod.POST)
	public AjaxResult login(HttpServletRequest req) throws Exception {
		CosmeticMember member = new CosmeticMember();
		member.setId(req.getParameter("id"));
		member.setPwd(req.getParameter("password"));
		// 계정이 있는지 체크
		int no = cosmeticService.selectLogin(member);
		
		String msg = "fail";
		HttpSession session = null;
		
		if(no != 0){
			member = cosmeticService.selectMember(member);			
		}
		else{
			member = null;
		}
		
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
	
	@RequestMapping(value="reviewCommentAdd", method=RequestMethod.POST)
	public Object reviewCommentAdd(CosmeticReviewComment cosmeticReviewComment, HttpServletRequest req) throws Exception{
		
		int pageNo = 1;
		// 세션정보 가져오기
		HttpSession session = req.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		cosmeticReviewComment.setMemberNo(member.getMemberNo());
		
		CosmeticSearch search = new CosmeticSearch();
		search.setStart((pageNo - 1) * 5); // +1을 안하는 이유는 Mysql limit함수 인덱스가 0부터 시작하기 때문이다...
		search.setEnd(pageNo * 5);
		search.setReviewNo(cosmeticReviewComment.getReviewNo());
		
		HashMap<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("search", search);
		paramMap.put("cosmeticReviewComment", cosmeticReviewComment);
		
		
		
		// 댓글 등록 서비스
		// 수정 삭제를 위한 댓글번호 반환
		HashMap<String, Object> resultMap = cosmeticService.insertReviewComment(paramMap);
		HashMap<String, Object> result  = cosmeticService.selectReviewComment(search);
		
		// 페이징을 위한 변수 정리
		int cnt = (Integer)result.get("cnt");
		
		
		// 마지막 페이지
		int lastPage = (cnt % 5 ==0) ? cnt / 5 : cnt/ 5 + 1;
				
		// 현재 화면의 탭
		int currTab = (pageNo-1)/5 + 1;
				
		// 화면의 시작 페이지 번호
		int beginPage = (currTab-1) * 5 +1;
				
		// 화면의 마지막 페이지 번호
		int endPage = (currTab * 5 > lastPage) ? lastPage : currTab * 5;
		
		resultMap.put("id", member.getId());
		resultMap.put("pageNo", pageNo);
		resultMap.put("beginPage", beginPage);
		resultMap.put("lastPage", lastPage);
		resultMap.put("endPage", endPage);
		resultMap.put("commentCnt", cnt);
		return resultMap;
	}
	
	@RequestMapping(value="reviewCommentDelete", method=RequestMethod.GET)
	public AjaxResult reviewCommentDelete(@RequestParam(name="pageNo",defaultValue="0")int pageNo,CosmeticReviewComment cosmeticReviewComment, HttpServletRequest req) throws Exception{
		// 세션정보 가져오기
		HttpSession session = req.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		cosmeticReviewComment.setMemberNo(member.getMemberNo());
		int reviewNo = cosmeticReviewComment.getReviewNo();
		
		// 페이징 관련변수
		pageNo = (pageNo == 0) ? 1 : pageNo;
		
		CosmeticSearch search = new CosmeticSearch();
		search.setStart((pageNo - 1)*5);
		search.setReviewNo(reviewNo);
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("search", search);
		paramMap.put("cosmeticReviewComment", cosmeticReviewComment);
		
		String msg = "fail";
		HashMap<String, Object> resultMap = cosmeticService.deleteReviewCommentByNo(paramMap);
		HashMap<String, Object> result  = cosmeticService.selectReviewComment(search);
		// 권한이 있는지
		int resultCnt = (Integer)resultMap.get("resultCnt");
		
		// 페이징을 위한 변수 정리
		int cnt = (Integer)result.get("cnt");
				
				
		// 마지막 페이지
		int lastPage = (cnt % 5 ==0) ? cnt / 5 : cnt/ 5 + 1;
						
		// 현재 화면의 탭
		int currTab = (pageNo-1)/5 + 1;
						
		// 화면의 시작 페이지 번호
		int beginPage = (currTab-1) * 5 +1;
						
		// 화면의 마지막 페이지 번호
		int endPage = (currTab * 5 > lastPage) ? lastPage : currTab * 5;
		
		if(resultCnt != 0){
			msg = "success";
			resultMap.put("pageNo", pageNo);
			resultMap.put("beginPage", beginPage);
			resultMap.put("lastPage", lastPage);
			resultMap.put("endPage", endPage);
			resultMap.put("commentCnt", cnt);
		}
		
		
		return new AjaxResult(msg,resultMap);
	}
	
	@RequestMapping(value="searchComment",method=RequestMethod.GET)
	public Object searchComment(@RequestParam(name="pageNo",defaultValue="0")int pageNo,int reviewNo) throws Exception{
//		// 세션정보 가져오기
//		HttpSession session = req.getSession();
//		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		
		pageNo = (pageNo == 0) ? 1 : pageNo;
		
		HashMap<String, Object> resultMap = new HashMap<>();
		CosmeticSearch search = new CosmeticSearch();
		search.setStart((pageNo - 1) * 5); // +1을 안하는 이유는 Mysql limit함수 인덱스가 0부터 시작하기 때문이다...
		search.setEnd(pageNo * 5);
		search.setReviewNo(reviewNo);
		
		HashMap<String, Object> result =cosmeticService.selectReviewComment(search);
		List<CosmeticReviewComment> comment = (List<CosmeticReviewComment>)result.get("comment");
		
		// 페이징을 위한 변수 정리
		// 전체 게시물 수
		int cnt = (Integer)result.get("cnt");
				
		// 마지막 페이지
		int lastPage = (cnt % 5 ==0) ? cnt / 5 : cnt/ 5 + 1;
				
		// 현재 화면의 탭
		int currTab = (pageNo-1)/5 + 1;
				
		// 화면의 시작 페이지 번호
		int beginPage = (currTab-1) * 5 +1;
				
		// 화면의 마지막 페이지 번호
		int endPage = (currTab * 5 > lastPage) ? lastPage : currTab * 5;
		
		resultMap.put("comment", comment);
		resultMap.put("commentCnt", cnt);
		resultMap.put("lastPage", lastPage);
		resultMap.put("pageNo", pageNo);
		resultMap.put("beginPage", beginPage);
		resultMap.put("endPage", endPage);
		
		return resultMap;
	}
	
	// 찜 등록
	@RequestMapping(value="wishAdd", method=RequestMethod.GET)
	public AjaxResult wishAdd(int reviewNo, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		
		CosmeticWish cosmeticWish = new CosmeticWish();
		cosmeticWish.setReviewNo(reviewNo);
		cosmeticWish.setMemberNo(member.getMemberNo());
		
		HashMap<String, Object> resultMap = cosmeticService.insertWish(cosmeticWish);
		String msg = (String)resultMap.get("msg");
		
		return new AjaxResult(msg, null);
	}
	
	// 추천 등록
	@RequestMapping(value="reivewRecomAdd",method=RequestMethod.GET)
	public AjaxResult reivewRecomAdd(int reviewNo, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		CosmeticMember member = (CosmeticMember)session.getAttribute("loginuser");
		
		CosmeticReviewRecom reviewRecom = new CosmeticReviewRecom();
		reviewRecom.setMemberNo(member.getMemberNo());
		reviewRecom.setReviewNo(reviewNo);
		
		HashMap<String, Object> resultMap = cosmeticService.insertReviewRecom(reviewRecom);
		String msg = (String)resultMap.get("msg");
		
		return new AjaxResult(msg,null);
	}
}
