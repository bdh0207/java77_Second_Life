package bitcamp.java77.dao;

import java.util.List;

import bitcamp.java77.domain.CosmeticHospital;
import bitcamp.java77.domain.CosmeticMember;
import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewComment;
import bitcamp.java77.domain.CosmeticReviewPhoto;
import bitcamp.java77.domain.CosmeticSearch;

public interface CosmeticDao {
	int searchID(String id); // ID 중복확인
	void insertMember(CosmeticMember cosmeticMember); // 회원등록
	int insertReview(CosmeticReview cosmeticReview);	// 리뷰 등록
	void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto); // 리뷰 사진 등록
	List<CosmeticReview> selectReviewList(CosmeticSearch search); // 리뷰 리스트
	CosmeticReview selectReviewListDetail(int reviewNo); // 리뷰 상세조회
	List<CosmeticReviewComment> selectReviewComment(int reviewNo); // 리뷰 댓글 조회
	List<CosmeticReviewPhoto> selectReviewPhoto(int reviewNo); //리뷰 사진 조회
	int selectLogin(CosmeticMember member); // 로그인
	CosmeticMember selectMember(CosmeticMember member);
	int selectReviewMatch(CosmeticReview cosmeticReview);
	void deleteReviewPhoto(int reviewNo);
	void deleteReview(CosmeticReview cosmeticReview);
	void updateReview(CosmeticReview cosmeticReview);
	List<CosmeticReviewPhoto> selectReviewPhotoNo(int reviewNo);
	void updateReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto);
	int insertReviewComment(CosmeticReviewComment cosmeticReviewComment);
<<<<<<< HEAD
	String selectHospital(CosmeticHospital cosmeticHospital);
=======
	List<CosmeticHospital> selectHospital();
>>>>>>> Chorong-Development
}
