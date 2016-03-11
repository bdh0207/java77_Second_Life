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
	
	@RequestMapping(value="reviewList",method=RequestMethod.GET)
	public Object reviewList(@RequestParam(name="pageNo",defaultValue="0")int pageNo) throws Exception{
		
		pageNo = (pageNo == 0) ? 1 : pageNo;
		
		CosmeticSearch search = new CosmeticSearch();
		search.setStart((pageNo - 1) * 6); // +1을 안하는 이유는 Mysql limit함수 인덱스가 0부터 시작하기 때문이다...
		search.setEnd(pageNo * 6);
		
		
		List<CosmeticReview> list = cosmeticService.selectReviewList(search);
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("reviewList", list);
		resultMap.put("status", "success");
		
		return resultMap;
	}
	
	@RequestMapping(value="reviewListDetail",method=RequestMethod.GET)
	public AjaxResult reviewListDetail(int reviewNo) throws Exception{
		HashMap<String, Object> resultMap = new HashMap<>();
		CosmeticReview review = cosmeticService.selectReviewListDetail(reviewNo);
		List<CosmeticReviewComment> comment  = cosmeticService.selectReviewComment(reviewNo);
		List<CosmeticReviewPhoto> reviewPhoto = cosmeticService.selectReviewPhoto(reviewNo);
		resultMap.put("review", review);
		resultMap.put("comment", comment);
		resultMap.put("photo", reviewPhoto);
		
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
}
