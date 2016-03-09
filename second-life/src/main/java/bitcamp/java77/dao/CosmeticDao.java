package bitcamp.java77.dao;

import java.util.List;

import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewPhoto;

public interface CosmeticDao {
	int insertReview(CosmeticReview cosmeticReview);
	void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto);
	List<CosmeticReview> selectReviewList();
}
