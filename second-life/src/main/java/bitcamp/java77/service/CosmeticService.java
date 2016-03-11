package bitcamp.java77.service;

import java.util.HashMap;
import java.util.List;

import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewComment;
import bitcamp.java77.domain.CosmeticReviewPhoto;
import bitcamp.java77.domain.CosmeticSearch;

public interface CosmeticService {
	public int insertReview(CosmeticReview cosmeticReview) throws Exception;
	public void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto) throws Exception;
	public List<CosmeticReview> selectReviewList(CosmeticSearch search) throws Exception;
	public CosmeticReview selectReviewListDetail(int reviewNo) throws Exception;
	public List<CosmeticReviewComment> selectReviewComment(int reviewNo) throws Exception;
	public List<CosmeticReviewPhoto> selectReviewPhoto(int reviewNo) throws Exception;
}
