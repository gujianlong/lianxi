package com.example.my.database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.my.bean.Bean;

import com.example.my.database.BeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig beanDaoConfig;

    private final BeanDao beanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        beanDaoConfig = daoConfigMap.get(BeanDao.class).clone();
        beanDaoConfig.initIdentityScope(type);

        beanDao = new BeanDao(beanDaoConfig, this);

        registerDao(Bean.class, beanDao);
    }
    
    public void clear() {
        beanDaoConfig.clearIdentityScope();
    }

    public BeanDao getBeanDao() {
        return beanDao;
    }

}
