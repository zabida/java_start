package com.at.tool.wx.wxapi;

import lombok.Data;

import java.util.List;

@Data
public class ApiReleaseArticleListResp {
    private Integer total_count;
    private Integer item_count;
    private List<Item> item;

    @Data
    public static class Item{
        private String article_id;
        private Integer update_time;
        private Content content;
    }

    @Data
    public static class Content{
        private List<NewsItem> news_item;
        private Integer create_time;
        private Integer update_time;
    }

    @Data
    public static class NewsItem{
        private String title;
        private String author;
        private String digest;
        private String content;
        private String content_source_url;
        private String thumb_media_id;
        private Integer show_cover_pic;
        private String url;
        private String thumb_url;
        private Integer need_open_comment;
        private Integer only_fans_can_comment;
        private Boolean is_deleted;
    }
}
