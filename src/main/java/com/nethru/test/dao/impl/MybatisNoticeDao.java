package com.nethru.test.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nethru.test.dao.NoticeDao;
import com.nethru.test.model.Notice;

@Repository
@Profile("production")
public class MybatisNoticeDao implements NoticeDao {
    
    private static final Logger logger = LoggerFactory.getLogger(JdbcNoticeDao.class);
    
    private static final String MAPPER_NAMESPACE = "NOTICE_MAPPER.";
    
    @Autowired
    private SqlSession sqlSession;

    @Override
    public Notice getNewestNotice()
    {
        logger.debug("getNewestNotice() start");
        
        Notice notice = sqlSession.selectOne(MAPPER_NAMESPACE + "getNewestNotice");
        logger.debug("notice : {}", notice);
        
        logger.debug("getNewestNotice() end");
        return notice;
    }

}
