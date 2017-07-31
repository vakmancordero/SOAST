package com.candlelabs.soast.service;

import com.candlelabs.soast.model.Grant;
import com.candlelabs.soast.persistence.GenericDao;
import com.candlelabs.soast.persistence.dao.GrantDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VakSF
 */
public class GrantService {
    
    private GenericDao<Grant, Long> grantDao;

    public GrantService() {
        this.grantDao = new GrantDao();
    }
    
    protected GenericDao<Grant, Long> getDao() {
        return grantDao;
    }
    
    public void setMaterialTypeDao(GenericDao<Grant, Long> grantDao) {
        this.grantDao = grantDao;
    }
    
    public Long saveGrant(String name) {
        return this.grantDao.create(new Grant(name));
    }
    
    public Grant findByName(String grantName) {
        
        Grant grant = null;
        
        if (grantName != null && !grantName.isEmpty()) {
            Criteria findbyName = getDao().getSession().createCriteria(getDao().clazz());
            findbyName.add(Restrictions.eq("name", grantName));
            grant = getDao().readUniqueByCriteria(findbyName);
        }
        
        return grant;
    }
    
}
