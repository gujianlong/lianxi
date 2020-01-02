package com.example.gujianlong1230.database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.gujianlong1230.bean.JsonBean;

import com.example.gujianlong1230.database.JsonBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig jsonBeanDaoConfig;

    private final JsonBeanDao jsonBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        jsonBeanDaoConfig = daoConfigMap.get(JsonBeanDao.class).clone();
        jsonBeanDaoConfig.initIdentityScope(type);

        jsonBeanDao = new JsonBeanDao(jsonBeanDaoConfig, this);

        registerDao(JsonBean.class, jsonBeanDao);
    }
    
    public void clear() {
        jsonBeanDaoConfig.clearIdentityScope();
    }

    public JsonBeanDao getJsonBeanDao() {
        return jsonBeanDao;
    }

}