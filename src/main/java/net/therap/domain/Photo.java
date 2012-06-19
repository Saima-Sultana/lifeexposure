package net.therap.domain;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: saima
 * Date: 5/31/12
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "SS_PHOTO")
public class Photo {
    private long photoId;
    private User user;
    private long albumId;
    private Blob photo;
    private Blob photoThumbnail;
    private String privacy = "public";
    private Date uploadDate;
    private String caption;
    private String location;
    private String description;
    private double rating = 0;
    private int report = 0;
    private int views = 0;
    private Set<PhotoComments> photoCommentsSet;
    private Set<PhotoRating> photoRatingSet;
/*    private PhotoDetails photoDetails;*/
    private long version;

    public Photo() {
    }

    public Photo(String caption, String location, String description) {
        this.caption = caption;
        this.location = location;
        this.description = description;
    }

    @Id
    @SequenceGenerator(name = "SS_PHOTO_SEQ",sequenceName = "SS_PHOTO_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "SS_PHOTO_SEQ")
    @Column(name = "PHOTO_ID")
    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "ALBUM_ID")
    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    @Lob
    @Column(name = "PHOTO", columnDefinition = "blob")
    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    @Lob
    @Column(name = "PHOTO_THUMBNAIL", columnDefinition = "blob")
    public Blob getPhotoThumbnail() {
        return photoThumbnail;
    }

    public void setPhotoThumbnail(Blob photoThumbnail) {
        this.photoThumbnail = photoThumbnail;
    }

    @Column(name = "PRIVACY", nullable = false)
    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @Column(name = "UPLOAD_DATE", nullable = false)
    @Type(type = "date")
    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Column(name = "CAPTION", nullable = false)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "RATING", nullable = false)
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Column(name = "REPORT", nullable = false)
    public int getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
    }

    @Column(name = "VIEWS", nullable = false)
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @OneToMany(mappedBy = "photo",
            targetEntity = PhotoComments.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<PhotoComments> getPhotoCommentsSet() {
        return photoCommentsSet;
    }

    public void setPhotoCommentsSet(Set<PhotoComments> photoCommentsSet) {
        this.photoCommentsSet = photoCommentsSet;
    }

    @OneToMany(mappedBy = "photo",
            targetEntity = PhotoRating.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<PhotoRating> getPhotoRatingSet() {
        return photoRatingSet;
    }

    public void setPhotoRatingSet(Set<PhotoRating> photoRatingSet) {
        this.photoRatingSet = photoRatingSet;
    }

/*    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="PHOTO_DETAILS_ID", unique = true)
    public PhotoDetails getPhotoDetails() {
        return photoDetails;
    }

    public void setPhotoDetails(PhotoDetails photoDetails) {
        this.photoDetails = photoDetails;
    } */

    @Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
