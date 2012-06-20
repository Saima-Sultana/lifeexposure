package net.therap.service;

import net.therap.dao.PhotoCommentDao;
import net.therap.dao.PhotoDao;
import net.therap.dao.PhotoRatingDao;
import net.therap.domain.Photo;
import net.therap.domain.PhotoComments;
import net.therap.domain.PhotoRating;
import net.therap.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/5/12
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("PhotoManager")
public class PhotoManagerImpl implements PhotoManager {
    private static final Logger log = LoggerFactory.getLogger(PhotoManagerImpl.class);

    @Autowired
    private PhotoDao photoDao;

    @Autowired
    private PhotoCommentDao photoCommentDao;

    @Autowired
    private PhotoRatingDao photoRatingDao;

    public void savePhoto(Photo photo) {
        photoDao.savePhoto(photo);
    }

    public void updatePhoto(Photo photo) {
        photoDao.updatePhoto(photo);
    }

    public Photo getPhoto(long id) {
        return (Photo) photoDao.getPhoto(id);
    }

    public List<Photo> getPhotos(User user) {
        log.info("in photomanager loginname:", user.getLoginName());
        return photoDao.getPhotos(user);
    }

    public List<Photo> getAllPhotos() {
        return photoDao.getAllPhotos();
    }

    public void saveComment(PhotoComments photoComments) {
        photoCommentDao.saveComment(photoComments);
    }

    public List<PhotoComments> getPhotoComments(Photo photo) {
        log.info("in photomanager caption:", photo.getCaption());
        return photoCommentDao.getPhotoComments(photo);
    }

    public byte[] getPhotoImage(long photoId) throws Exception {
        Blob imageData = photoDao.getPhotoImage(photoId);

        if (imageData == null) {
            throw new Exception();
        }

        byte[] bytes = new byte[(int) imageData.length()];
        imageData.getBinaryStream().read(bytes);
        imageData.getBinaryStream().close();
        return bytes;
    }

    public void saveRating(PhotoRating photoRating) {
        log.info("photomanager: in save rating");
        photoRatingDao.saveRating(photoRating);
    }

    public double getRating(Photo photo) {
        log.info("photomanager: in get rating");
        return photoRatingDao.getRating(photo);
    }

    public boolean isDoubleRating(Photo photo, User user) {
        return photoRatingDao.isDoubleRating(photo, user);
    }
}
