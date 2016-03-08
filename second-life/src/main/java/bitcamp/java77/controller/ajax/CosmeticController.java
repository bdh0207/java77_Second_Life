package bitcamp.java77.controller.ajax;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
	
	@RequestMapping(value="reviewAdd",method=RequestMethod.POST)
	public AjaxResult reviewAdd(CosmeticReview cosmeticReview, @RequestParam("files") MultipartFile[] files) throws Exception{
		CosmeticReviewPhoto cosmeticReviewPhoto = new CosmeticReviewPhoto();

	    for (MultipartFile file : files) {
	      if (file.getSize() > 0) {
	        String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
	        
	        // 폴더 지정
	     	String saveFolder = servletContext.getRealPath("/reviewPhoto/");
	     	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	     	String path = sdf.format(new Date());
	     	saveFolder += path;
	     	File f = new File(saveFolder);
	     	f.mkdirs();
	        
	     	String filePath = saveFolder + "/" + newFileName;
	     	file.transferTo(new File(filePath));
	     	cosmeticService.insertReview(cosmeticReview);
	     	int reviewNo = cosmeticReview.getReviewNo();
	     	cosmeticReviewPhoto.setReviewNo(reviewNo);
	     	cosmeticReviewPhoto.setFilePath(filePath);
	     	cosmeticService.insertReviewPhoto(cosmeticReviewPhoto);
	      }
	    }
		
	    
		return new AjaxResult("success",null);
	}
}
