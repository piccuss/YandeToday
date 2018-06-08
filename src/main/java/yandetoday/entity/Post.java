package yandetoday.entity;

import marker.builder.MarkdownBuilder;
import marker.core.Image;
import marker.core.Link;

import java.util.ArrayList;
import java.util.List;

public class Post {

    private long id;
    private String tags;
    private long created_at;
    private long updated_at;
    private String author;
    private String source;
    private int score;
    private String md5;

    private long file_size;
    private String file_ext;
    private String file_url;
    private int width;
    private int height;

    private String preview_url;
    private int actual_preview_width;
    private int actual_preview_height;

    private String sample_url;
    private int sample_width;
    private int sample_height;
    private long sample_file_size;

    private String jpeg_url;
    private int jpeg_width;
    private int jpeg_height;
    private long jpeg_file_size;

    private String rating;

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getFile_size() {
        return file_size;
    }

    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }

    public String getFile_ext() {
        return file_ext;
    }

    public void setFile_ext(String file_ext) {
        this.file_ext = file_ext;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public int getActual_preview_width() {
        return actual_preview_width;
    }

    public void setActual_preview_width(int actual_preview_width) {
        this.actual_preview_width = actual_preview_width;
    }

    public int getActual_preview_height() {
        return actual_preview_height;
    }

    public void setActual_preview_height(int actual_preview_height) {
        this.actual_preview_height = actual_preview_height;
    }

    public String getSample_url() {
        return sample_url;
    }

    public void setSample_url(String sample_url) {
        this.sample_url = sample_url;
    }

    public int getSample_width() {
        return sample_width;
    }

    public void setSample_width(int sample_width) {
        this.sample_width = sample_width;
    }

    public int getSample_height() {
        return sample_height;
    }

    public void setSample_height(int sample_height) {
        this.sample_height = sample_height;
    }

    public long getSample_file_size() {
        return sample_file_size;
    }

    public void setSample_file_size(long sample_file_size) {
        this.sample_file_size = sample_file_size;
    }

    public String getJpeg_url() {
        return jpeg_url;
    }

    public void setJpeg_url(String jpeg_url) {
        this.jpeg_url = jpeg_url;
    }

    public int getJpeg_width() {
        return jpeg_width;
    }

    public void setJpeg_width(int jpeg_width) {
        this.jpeg_width = jpeg_width;
    }

    public int getJpeg_height() {
        return jpeg_height;
    }

    public void setJpeg_height(int jpeg_height) {
        this.jpeg_height = jpeg_height;
    }

    public long getJpeg_file_size() {
        return jpeg_file_size;
    }

    public void setJpeg_file_size(long jpeg_file_size) {
        this.jpeg_file_size = jpeg_file_size;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", tags='" + tags + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", author='" + author + '\'' +
                ", source='" + source + '\'' +
                ", score=" + score +
                ", md5='" + md5 + '\'' +
                ", file_size=" + file_size +
                ", file_ext='" + file_ext + '\'' +
                ", file_url='" + file_url + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

    public String getMarkdown() {
        MarkdownBuilder markdownBuilder = new MarkdownBuilder();
        markdownBuilder.addHeader(new Link("Id: " + id, file_url).markdownSerialized(), 2);

        List<Object> list = new ArrayList<>();
        list.add("Author: " + author);
        list.add("Score: " + score);
        list.add("Tags: " + tags);
        list.add("Size: " + width + "×" + height);
        list.add("Md5: " + md5);
        list.add("Sample: ");
        markdownBuilder.addList(list);
        markdownBuilder.addImage("sample", preview_url, Image.ALIGN_CENTER);

        return markdownBuilder.toString();
    }
}

