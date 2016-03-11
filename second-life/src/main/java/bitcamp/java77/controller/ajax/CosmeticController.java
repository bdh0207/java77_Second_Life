package bitcamp.java77.controller.ajax;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import bitcamp.java77.domain.AjaxResult;
import bitcamp.java77.domain.CosmeticMember;
import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewPhoto;
import bitcamp.java77.service.CosmeticService;
import bitcamp.java77.util.MultipartHelper;

@Controller("ajax.CosmeticController")
@RequestMapping("/cosmetic/ajax/*")
public class CosmeticController {
	
	
	@Autowired
	CosmeticService cosmeticService;
	@Autowired
	ServletContext servletContext;
	
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
	
	@RequestMapping(value="reviewList")
	public Object reviewList() throws Exception{
		List<CosmeticReview> list = cosmeticService.selectReviewList();
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("reviewList", list);
		resultMap.put("status", "success");
		
		return resultMap;
	}
	
	@RequestMapping(value="reviewAdd",method=RequestMethod.POST)
	public AjaxResult reviewAdd(CosmeticReview cosmeticReview, @RequestParam("files") MultipartFile[] files) throws Exception{
		CosmeticReviewPhoto cosmeticReviewPhoto = new CosmeticReviewPhoto();

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
	     	cosmeticService.insertReview(cosmeticReview);
	     	int reviewNo = cosmeticReview.getReviewNo();
	     	cosmeticReviewPhoto.setReviewNo(reviewNo);
	     	cosmeticReviewPhoto.setFilePath(fileDBPath);
	     	cosmeticService.insertReviewPhoto(cosmeticReviewPhoto);
	      }
	    }
		
	    
		return new AjaxResult("success",null);
	}
}
