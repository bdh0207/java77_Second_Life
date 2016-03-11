package bitcamp.java77.dao;

import java.util.List;

import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewComment;
import bitcamp.java77.domain.CosmeticReviewPhoto;
import bitcamp.java77.domain.CosmeticSearch;

public interface CosmeticDao {
	int insertReview(CosmeticReview cosmeticReview);	// 리뷰 등록
	void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto); // 리뷰 사진 등록
	List<CosmeticReview> selectReviewList(CosmeticSearch search); // 리뷰 리스트
	CosmeticReview selectReviewListDetail(int reviewNo); // 리뷰 상세조회
	List<CosmeticReviewComment> selectReviewComment(int reviewNo); // 리뷰 댓글 조회
	List<CosmeticReviewPhoto> selectReviewPhoto(int reviewNo); //리뷰 사진 조회
}
