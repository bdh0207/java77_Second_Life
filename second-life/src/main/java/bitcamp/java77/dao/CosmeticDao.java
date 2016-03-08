package bitcamp.java77.dao;

import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewPhoto;

public interface CosmeticDao {
	int insertReview(CosmeticReview cosmeticReview);
	void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto);
}
