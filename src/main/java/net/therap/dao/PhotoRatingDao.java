package net.therap.dao;

import net.therap.domain.Photo;
import net.therap.domain.PhotoRating;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/18/12
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class PhotoRatingDao extends HibernateDaoSupport {
    private static final Logger log = LoggerFactory.getLogger(PhotoRatingDao.class);

    public void saveRating(PhotoRating photoRating) {
        log.info("PhotoRatingDao: in saveRating");
        Session session = getSession();
        session.saveOrUpdate(photoRating);
        session.flush();
    }

    public double getRating(Photo photo) {
        log.info("PhotoRatingDao: in getting ratings");

/*        String query = "FROM PhotoRating photoRating WHERE photoRating.photo = :photoObj";
        List<PhotoRating> ratingList = this.getHibernateTemplate().findByNamedParam(query, "photoObj", photo);*//*

        String query = "SELECT AVG(photoRating.rating) from PhotoRating photoRating WHERE photoRating.photo = :photoObj";
        List<Double> avgRatingList = this.getHibernateTemplate().findByNamedParam(query, "photoObj", photo);
        if(avgRatingList == null) {
          return 0;
        }
        log.info("ListSize:", avgRatingList.size());
        double avgRating = avgRatingList.get(0);
        return (float)avgRating;*/
        String query = "FROM PhotoRating photoRating WHERE photoRating.photo = :photoObj";
        List<PhotoRating> ratingList = this.getHibernateTemplate().findByNamedParam(query, "photoObj", photo);

        if (ratingList.isEmpty())
            return 0;
        else {
            Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
            Query query1 = session.createQuery("SELECT AVG(photoRating.rating) from PhotoRating as photoRating WHERE photoRating.photo = :photoObj");
            query1.setParameter("photoObj", photo);
            return ((Double) query1.iterate().next()).doubleValue();

            //return (avgRatingList.size() == 0) ? 0 : avgRatingList.get(0);
        }

    }
}
