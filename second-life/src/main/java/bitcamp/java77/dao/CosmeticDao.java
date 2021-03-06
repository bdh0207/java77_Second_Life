package bitcamp.java77.dao;

import java.util.List;

import bitcamp.java77.domain.CosmeticCounsel;
import bitcamp.java77.domain.CosmeticCounselPhoto;
import bitcamp.java77.domain.CosmeticEvent;
import bitcamp.java77.domain.CosmeticHospital;
import bitcamp.java77.domain.CosmeticMember;
import bitcamp.java77.domain.CosmeticQnA;
import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewComment;
import bitcamp.java77.domain.CosmeticReviewPhoto;
import bitcamp.java77.domain.CosmeticReviewRecom;
import bitcamp.java77.domain.CosmeticSearch;
import bitcamp.java77.domain.CosmeticSugeryInfo;
import bitcamp.java77.domain.CosmeticWish;
import bitcamp.java77.domain.CosmeticWishEvent;

public interface CosmeticDao {
	int searchID(String id); // ID 중복확인
	void insertMember(CosmeticMember cosmeticMember); // 회원등록
	int insertReview(CosmeticReview cosmeticReview);	// 리뷰 등록
	void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto); // 리뷰 사진 등록
	List<CosmeticReview> selectReviewList(CosmeticSearch search); // 리뷰 리스트
	List<CosmeticEvent> selectEventList(CosmeticSearch search); 	// 이벤트 리스트
	CosmeticReview selectReviewListDetail(int reviewNo); // 리뷰 상세조회
	List<CosmeticReviewComment> selectReviewComment(CosmeticSearch search); // 리뷰 댓글 조회
	List<CosmeticReviewComment> selectReviewCommentByReviewNo(CosmeticSearch search); // 리뷰 댓글 조회
	List<CosmeticReviewPhoto> selectReviewPhoto(int reviewNo); //리뷰 사진 조회
	int selectLogin(CosmeticMember member); // 로그인
	CosmeticMember selectMember(CosmeticMember member);
	int selectReviewMatch(CosmeticReview cosmeticReview);
	void deleteReviewPhoto(int reviewNo);
	void deleteReview(CosmeticReview cosmeticReview);
	void deleteReviewCommentByReviewNo(int reviewNo);
	void updateReview(CosmeticReview cosmeticReview);
	List<CosmeticReviewPhoto> selectReviewPhotoNo(int reviewNo);
	void updateReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto);
	int insertReviewComment(CosmeticReviewComment cosmeticReviewComment);
	int deleteReviewCommentByNo(CosmeticReviewComment cosmeticReviewComment);
	int selectReviewCommentCount(int reviewNo);
	String selectHospital(CosmeticHospital cosmeticHospital);
	int selectWishCheck(CosmeticWish cosmeticWish);
	void insertWish(CosmeticWish cosmeticWish);
	int selectReviewRecomCheck(CosmeticReviewRecom reviewRecom);
	void insertReviewRecom(CosmeticReviewRecom reviewRecom);
	List<CosmeticWish> selectReviewWish(int memberNo);
	int selectInfoCheck(int reviewNo);
	CosmeticSugeryInfo selectReviewSugeryInfo(int reviewNo);
	void insertSugeryInfo(CosmeticSugeryInfo cosmeticSugeryInfo);
	CosmeticReview selectSurgeryInfo(int reviewNo);
	void deleteSugeryInfo(CosmeticWish wish);
	void deleteWish(CosmeticWish wish);
	void updateReviewViewCnt(int reviewNo);
	void updateEventViewCnt(int eventNo);
	int selectEventViewCnt(int eventNo);
	void insertWishEvent(CosmeticWishEvent wishEvent);
	int selectWishEvent(CosmeticWishEvent wishEvent);
	CosmeticHospital selectHospitalInfoDetail(int hospitalNo);
	List<CosmeticHospital> selectHospitalInfoByName(String name);
	List<CosmeticHospital> selectHospital();
	void insertHospital(CosmeticHospital cosmeticHospital);
	void insertEvent(CosmeticEvent cosmeticEvent);
	List<CosmeticReview> selectReviewBest();
	List<CosmeticSugeryInfo> selectSurgeryInfoByMemberNo(int memberNo);
	List<String> selectWishGetNo(int reviewNo);
	void deleteSugeryInfoByNo(int sugeryNo);
	int selectWishStatus(CosmeticReview cosmeticReview);
	void deleteReviewRecom(CosmeticReview cosmeticReview);
	void deleteWishByNo(int reviewNo);
	List<CosmeticQnA> selectQnA(int mNo);
	void insertQnA(CosmeticQnA cosmeticQnA);
	void insertCounsel(CosmeticCounsel cosmeticCounsel);
	void insertCounselPhoto(CosmeticCounselPhoto cosmeticCounselPhoto);
	List<CosmeticCounselPhoto> selectCounselPhoto(int counselNo);
	void deleteSugeryInfo(int sugeryNo);
	CosmeticQnA selectQnAByNo(int qno);
	void deleteQnA(int qno);
	void updateQnA(CosmeticQnA cosmeticQnA);
}
