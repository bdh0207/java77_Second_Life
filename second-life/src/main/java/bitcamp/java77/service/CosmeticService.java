package bitcamp.java77.service;

import java.util.HashMap;
import java.util.List;

import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewPhoto;

public interface CosmeticService {
	public int insertReview(CosmeticReview cosmeticReview) throws Exception;
	public void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto) throws Exception;
	public List<CosmeticReview> selectReviewList() throws Exception;
}
