package net.therap.dao;

import net.therap.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.sql.Blob;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: saima
 * Date: 5/31/12
 * Time: 1:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDao extends HibernateDaoSupport {
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);

    public void saveUser(User user) {
        log.info("in saveUser");
        this.getHibernateTemplate().saveOrUpdate(user);
    }

    public User getUser(long id) {
        return (User) this.getHibernateTemplate().load(User.class, id);
    }

    public User getUserByLoginName(String userName) {
        String query = "FROM User user WHERE user.loginName = :login_name";

        List<User> userList = this.getHibernateTemplate().findByNamedParam(query, "login_name", userName);
        if (userList.size() == 0)
            return null;
        return userList.get(0);
    }

    public Blob getUserImage(long userId) {
        String query = "SELECT user.profilePicThumbnail FROM User user WHERE user.userId = :user_id";

        List<Blob> blobList = this.getHibernateTemplate().findByNamedParam(query, "user_id", userId);
        if (blobList.size() == 0)
            return null;
        return blobList.get(0);
    }
}
