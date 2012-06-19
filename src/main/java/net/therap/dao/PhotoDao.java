package net.therap.dao;

import net.therap.domain.Photo;
import net.therap.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.Blob;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: saima
 * Date: 5/31/12
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhotoDao extends HibernateDaoSupport {
    private static final Logger log = LoggerFactory.getLogger(PhotoDao.class);

    public void savePhoto(Photo photo) {
        log.info("in savePhoto");
        this.getHibernateTemplate().saveOrUpdate(photo);
/*        //for checking transaction
        throw new RuntimeException();*/
    }

    public Photo getPhoto(long id) {
        return (Photo) this.getHibernateTemplate().load(Photo.class, id);
    }

    public List<Photo> getPhotos(User user) {
        log.info("in getting comments");
        String query = "FROM Photo photo WHERE photo.user = :userObj";

        List<Photo> photos = this.getHibernateTemplate().findByNamedParam(query, "userObj", user);
        log.info("in dao", photos);
        return photos;
    }

    public Blob getPhotoImage(long photoId) {
        String query = "SELECT photo.photo FROM Photo photo WHERE photo.photoId = :photo_id";

        List<Blob> blobList = this.getHibernateTemplate().findByNamedParam(query, "photo_id", photoId);
        if (blobList.size() == 0)
            return null;
        return blobList.get(0);
    }
}
