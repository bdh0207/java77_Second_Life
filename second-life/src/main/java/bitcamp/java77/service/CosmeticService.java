package bitcamp.java77.service;

import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewPhoto;

public interface CosmeticService {
	public int insertReview(CosmeticReview cosmeticReview);
	public void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto);
}
