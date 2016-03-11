package bitcamp.java77.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bitcamp.java77.dao.CosmeticDao;
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
	public List<CosmeticReview> selectReviewList(CosmeticSearch search) throws Exception {
		return cosmeticDao.selectReviewList(search);
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
	
	
	
}
