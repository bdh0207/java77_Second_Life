package bitcamp.java77.service;

import java.util.HashMap;
import java.util.List;

import bitcamp.java77.domain.CosmeticMember;
import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewComment;
import bitcamp.java77.domain.CosmeticReviewPhoto;
import bitcamp.java77.domain.CosmeticSearch;

public interface CosmeticService {
	public int insertReview(CosmeticReview cosmeticReview) throws Exception;
	public void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto) throws Exception;
	public int searchID(String id) throws Exception;
	public void insertMember(CosmeticMember cosmeticMember) throws Exception;
	public List<CosmeticReview> selectReviewList(CosmeticSearch search) throws Exception;
	public CosmeticReview selectReviewListDetail(int reviewNo) throws Exception;
	public List<CosmeticReviewComment> selectReviewComment(int reviewNo) throws Exception;
	public List<CosmeticReviewPhoto> selectReviewPhoto(int reviewNo) throws Exception;
	public int selectLogin(CosmeticMember member) throws Exception; 
	public CosmeticMember selectMember(CosmeticMember member) throws Exception;
	public int selectReviewMatch(CosmeticReview cosmeticReview) throws Exception;
	public void deleteReview(CosmeticReview cosmeticReview) throws Exception;
	public void updateReview(CosmeticReview cosmeticReview) throws Exception;
	public List<CosmeticReviewPhoto> selectReviewPhotoNo(int reviewNo) throws Exception;
	public void updateReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto) throws Exception;
	public int insertReviewComment(CosmeticReviewComment cosmeticReviewComment) throws Exception;
	public int hospitalInfo(CosmeticReviewComment cosmeticReviewComment) throws Exception;
}
