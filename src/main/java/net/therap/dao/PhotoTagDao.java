package net.therap.dao;

import net.therap.domain.PhotoTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/20/12
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhotoTagDao extends HibernateDaoSupport {
    private static final Logger log = LoggerFactory.getLogger(PhotoTagDao.class);

    public List<PhotoTag> getAllTags() {
        String query = "FROM PhotoTag photoTag";
        List<PhotoTag> photoTagList = this.getHibernateTemplate().find(query);
        return photoTagList;
    }

    public PhotoTag getPhotoTagObj(String tag) {
        String query = "FROM PhotoTag photoTag WHERE photoTag.tag = :tagName";

        List<PhotoTag> photoTagList = this.getHibernateTemplate().findByNamedParam(query, "tagName", tag);
        return photoTagList.get(0);
    }
}