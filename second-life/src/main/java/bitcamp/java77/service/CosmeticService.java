package bitcamp.java77.service;

import java.util.HashMap;
import java.util.List;

import bitcamp.java77.domain.CosmeticEvent;
import bitcamp.java77.domain.CosmeticHospital;
import bitcamp.java77.domain.CosmeticMember;
import bitcamp.java77.domain.CosmeticQnA;
import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewComment;
import bitcamp.java77.domain.CosmeticReviewPhoto;
import bitcamp.java77.domain.CosmeticReviewRecom;
import bitcamp.java77.domain.CosmeticSearch;
import bitcamp.java77.domain.CosmeticWish;
import bitcamp.java77.domain.CosmeticWishEvent;

public interface CosmeticService {
	public int insertReview(CosmeticReview cosmeticReview) throws Exception;
	public void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto) throws Exception;
	public int searchID(String id) throws Exception;
	public void insertMember(CosmeticMember cosmeticMember) throws Exception;
	public HashMap<String, Object> selectReviewList(CosmeticSearch search) throws Exception;
	public List<CosmeticEvent> selectEventList(CosmeticSearch search) throws Exception;
	public CosmeticReview selectReviewListDetail(int reviewNo) throws Exception;
	public HashMap<String, Object> selectReviewComment(CosmeticSearch search) throws Exception;
	public List<CosmeticReviewPhoto> selectReviewPhoto(int reviewNo) throws Exception;
	public int selectLogin(CosmeticMember member) throws Exception; 
	public CosmeticMember selectMember(CosmeticMember member) throws Exception;
	public int selectReviewMatch(CosmeticReview cosmeticReview) throws Exception;
	public void deleteReview(CosmeticReview cosmeticReview) throws Exception;
	public void updateReview(CosmeticReview cosmeticReview) throws Exception;
	public List<CosmeticReviewPhoto> selectReviewPhotoNo(int reviewNo) throws Exception;
	public void updateReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto) throws Exception;
	public HashMap<String, Object> insertReviewComment(HashMap<String, Object> paramMap) throws Exception;
	public HashMap<String, Object> deleteReviewCommentByNo(HashMap<String, Object> paramMap) throws Exception;
	public List<CosmeticHospital> hospitalInfo() throws Exception;
	public HashMap<String, Object> insertWish(CosmeticWish cosmeticWish) throws Exception;
	public HashMap<String, Object> insertReviewRecom(CosmeticReviewRecom reviewRecom) throws Exception;
	public List<CosmeticWish> selectReviewWish(int memberNo) throws Exception;
	public HashMap<String, Object> insertSugeryInfo(int wishNo, int reviewNo) throws Exception;
	public CosmeticReview selectSurgeryInfo(int reviewNo) throws Exception;
	public void deleteWish(CosmeticWish wish) throws Exception;
	public void updateEventViewCnt(int eventNo) throws Exception;
	public int selectEventViewCnt(int eventNo) throws Exception;
	public void insertWishEvent(CosmeticWishEvent wishEvent) throws Exception;
	public int selectWishEvent(CosmeticWishEvent wishEvent) throws Exception;
	public CosmeticHospital selectHospitalInfoDetail(int hospitalNo) throws Exception;
	public List<CosmeticHospital> selectHospitalInfoByName(String name) throws Exception;
	public void insertHospital(CosmeticHospital cosmeticHospital) throws Exception;
	public void insertEvent(CosmeticEvent cosmeticEvent) throws Exception;
	public List<CosmeticReview> selectMainReviewList(CosmeticSearch search) throws Exception;
	public List<CosmeticQnA> qnaList(int mNo) throws Exception;
	public void insertQnA(CosmeticQnA cosmeticQnA) throws Exception;
}
