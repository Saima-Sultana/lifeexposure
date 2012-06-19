package net.therap.service;

import net.therap.domain.Photo;
import net.therap.domain.PhotoComments;
import net.therap.domain.PhotoRating;
import net.therap.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/6/12
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PhotoManager {
    public void savePhoto(Photo photo);
    public Photo getPhoto(long id);
    public List<Photo> getPhotos(User user);
    public void saveComment(PhotoComments photoComments);
    public List<PhotoComments> getPhotoComments(Photo photo);
    public byte[] getPhotoImage(long photoId) throws Exception;
    public void saveRating(PhotoRating photoRating);
    public float getRating(Photo photo);
}