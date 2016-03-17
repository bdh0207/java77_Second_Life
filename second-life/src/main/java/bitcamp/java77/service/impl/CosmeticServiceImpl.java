package bitcamp.java77.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bitcamp.java77.dao.CosmeticDao;
import bitcamp.java77.domain.CosmeticMember;
import bitcamp.java77.domain.CosmeticReview;
import bitcamp.java77.domain.CosmeticReviewComment;
import bitcamp.java77.domain.CosmeticReviewPhoto;
import bitcamp.java77.domain.CosmeticSearch;
import bitcamp.java77.service.CosmeticService;

@Service
public class CosmeticServiceImpl implements CosmeticService {
	
	@Autowired
	CosmeticDao cosmeticDao;
	
	@Override
	@Transactional
	public int insertReview(CosmeticReview cosmeticReview) throws Exception {
		return cosmeticDao.insertReview(cosmeticReview);
	}

	@Override
	@Transactional
	public void insertReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto) throws Exception {
		cosmeticDao.insertReviewPhoto(cosmeticReviewPhoto);
	}

	@Override
	@Transactional
	public CosmeticReview selectReviewListDetail(int reviewNo) throws Exception {
		return cosmeticDao.selectReviewListDetail(reviewNo);
	}

	@Override
	@Transactional
	public List<CosmeticReviewComment> selectReviewComment(int reviewNo) throws Exception {
		return cosmeticDao.selectReviewComment(reviewNo);
	}

	@Override
	@Transactional
	public List<CosmeticReviewPhoto> selectReviewPhoto(int reviewNo) throws Exception {
		return cosmeticDao.selectReviewPhoto(reviewNo);
	}

	@Override
	@Transactional
	public int searchID(String id) throws Exception {
		return cosmeticDao.searchID(id);
	}

	@Override
	@Transactional
	public void insertMember(CosmeticMember cosmeticMember) throws Exception {
		cosmeticDao.insertMember(cosmeticMember);
	}

	@Override
	@Transactional
	public List<CosmeticReview> selectReviewList(CosmeticSearch search) throws Exception {
		return cosmeticDao.selectReviewList(search);
	}

	@Override
	@Transactional
	public int selectLogin(CosmeticMember member) throws Exception {
		return cosmeticDao.selectLogin(member);
	}

	@Override
	@Transactional
	public CosmeticMember selectMember(CosmeticMember member) throws Exception {
		return cosmeticDao.selectMember(member);
	}

	@Override
	@Transactional
	public int selectReviewMatch(CosmeticReview cosmeticReview) throws Exception {
		return cosmeticDao.selectReviewMatch(cosmeticReview);
	}

	@Override
	@Transactional
	public void deleteReview(CosmeticReview cosmeticReview) throws Exception {
		cosmeticDao.deleteReviewPhoto(cosmeticReview.getReviewNo());
		cosmeticDao.deleteReview(cosmeticReview);
	}

	@Override
	@Transactional
	public void updateReview(CosmeticReview cosmeticReview) throws Exception {
		cosmeticDao.updateReview(cosmeticReview);
	}

	@Override
	@Transactional
	public List<CosmeticReviewPhoto> selectReviewPhotoNo(int reviewNo) throws Exception {
		return cosmeticDao.selectReviewPhotoNo(reviewNo);
	}

	@Override
	@Transactional
	public void updateReviewPhoto(CosmeticReviewPhoto cosmeticReviewPhoto) throws Exception {
		cosmeticDao.updateReviewPhoto(cosmeticReviewPhoto);
	}

	@Override
	@Transactional
	public int insertReviewComment(CosmeticReviewComment cosmeticReviewComment) throws Exception {
		return cosmeticDao.insertReviewComment(cosmeticReviewComment);
	}
	
	
}
