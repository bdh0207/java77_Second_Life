package bitcamp.java77.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bitcamp.java77.dao.CosmeticDao;
import bitcamp.java77.domain.CosmeticHospital;
import bitcamp.java77.domain.CosmeticMember;
import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewComment;
import bitcamp.java77.domain.CosmeticReviewPhoto;
import bitcamp.java77.domain.CosmeticReviewRecom;
import bitcamp.java77.domain.CosmeticSearch;
import bitcamp.java77.domain.CosmeticWish;
import bitcamp.java77.service.CosmeticService;

@Service
public class CosmeticServiceImpl implements CosmeticService {
	
	@Autowired
	CosmeticDao cosmeticDao;
	 
	@Override
	@Transactional
	public int insertReview(CosmeticReview cosmeticReview) throws Exception {
		return cosmeticDao.insertReview(cosmeticReview);
	}

	@Override
	@Transactional
	public void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto) throws Exception {
		cosmeticDao.insertReviewPhoto(cosmeticReviewPhoto);
	}

	@Override
	@Transactional
	public CosmeticReview selectReviewListDetail(int reviewNo) throws Exception {
		return cosmeticDao.selectReviewListDetail(reviewNo);
	}

	@Override
	@Transactional
	public HashMap<String, Object> selectReviewComment(CosmeticSearch search) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		result.put("comment", cosmeticDao.selectReviewComment(search));
		result.put("cnt", cosmeticDao.selectReviewCommentCount(search.getReviewNo()));
		return result;
	}

	@Override
	@Transactional
	public List<CosmeticReviewPhoto> selectReviewPhoto(int reviewNo) throws Exception {
		return cosmeticDao.selectReviewPhoto(reviewNo);
	}

	@Override
	@Transactional
	public int searchID(String id) throws Exception {
		return cosmeticDao.searchID(id);
	}

	@Override
	@Transactional
	public void insertMember(CosmeticMember cosmeticMember) throws Exception {
		cosmeticDao.insertMember(cosmeticMember);
	}

	@Override
	@Transactional
	public List<CosmeticReview> selectReviewList(CosmeticSearch search) throws Exception {
		return cosmeticDao.selectReviewList(search);
	}

	@Override
	@Transactional
	public int selectLogin(CosmeticMember member) throws Exception {
		return cosmeticDao.selectLogin(member);
	}

	@Override
	@Transactional
	public CosmeticMember selectMember(CosmeticMember member) throws Exception {
		return cosmeticDao.selectMember(member);
	}

	@Override
	@Transactional
	public int selectReviewMatch(CosmeticReview cosmeticReview) throws Exception {
		return cosmeticDao.selectReviewMatch(cosmeticReview);
	}

	@Override
	@Transactional
	public void deleteReview(CosmeticReview cosmeticReview) throws Exception {
		cosmeticDao.deleteReviewCommentByReviewNo(cosmeticReview.getReviewNo());
		cosmeticDao.deleteReviewPhoto(cosmeticReview.getReviewNo());
		cosmeticDao.deleteReview(cosmeticReview);
	}

	@Override
	@Transactional
	public void updateReview(CosmeticReview cosmeticReview) throws Exception {
		cosmeticDao.updateReview(cosmeticReview);
	}

	@Override
	@Transactional
	public List<CosmeticReviewPhoto> selectReviewPhotoNo(int reviewNo) throws Exception {
		return cosmeticDao.selectReviewPhotoNo(reviewNo);
	}

	@Override
	@Transactional
	public void updateReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto) throws Exception {
		cosmeticDao.updateReviewPhoto(cosmeticReviewPhoto);
	}

	@Override
	@Transactional
	public HashMap<String, Object> insertReviewComment(HashMap<String, Object> paramMap) throws Exception {
		CosmeticSearch search = (CosmeticSearch)paramMap.get("search");
		CosmeticReviewComment cosmeticReviewComment = (CosmeticReviewComment)paramMap.get("cosmeticReviewComment");
		
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("commentNo", cosmeticDao.insertReviewComment(cosmeticReviewComment));
		int reviewNo = cosmeticReviewComment.getReviewNo();
		resultMap.put("commentList", cosmeticDao.selectReviewCommentByReviewNo(search));
		return resultMap;
	}

	@Override
	@Transactional
	public HashMap<String, Object> deleteReviewCommentByNo(HashMap<String, Object> paramMap) throws Exception {
		CosmeticSearch search = (CosmeticSearch)paramMap.get("search");
		CosmeticReviewComment cosmeticReviewComment = (CosmeticReviewComment)paramMap.get("cosmeticReviewComment");
		
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("resultCnt", cosmeticDao.deleteReviewCommentByNo(cosmeticReviewComment));
		resultMap.put("commentList", cosmeticDao.selectReviewCommentByReviewNo(search));
		return resultMap;
	}

	@Override
	@Transactional
	public List<CosmeticHospital> hospitalInfo() throws Exception {
		return null;
		//cosmeticDao.selectHospital();
	}

	@Override
	@Transactional
	public HashMap<String, Object> insertWish(CosmeticWish cosmeticWish) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		int cnt = cosmeticDao.selectWishCheck(cosmeticWish);
		String msg = "fail";
		if(cnt == 0){
			msg = "success";
			cosmeticDao.insertWish(cosmeticWish);
			System.out.println("위시리스트 추가 완료");
		}
		
		resultMap.put("msg", msg);
		return resultMap;
	}

	@Override
	@Transactional
	public HashMap<String, Object> insertReviewRecom(CosmeticReviewRecom reviewRecom) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		int cnt = cosmeticDao.selectReviewRecomCheck(reviewRecom);
		String msg = "fail";
		if(cnt == 0){
			msg = "success";
			cosmeticDao.insertReviewRecom(reviewRecom);
			System.out.println("리뷰 추천 완료");
		}
		resultMap.put("msg", msg);
		
		return resultMap;
	}
	

	@Override
	@Transactional
	public CosmeticReview selectSurgeryInfo(int reviewNo) throws Exception {
		return cosmeticDao.selectSurgeryInfo(reviewNo);
	}
	 
}
