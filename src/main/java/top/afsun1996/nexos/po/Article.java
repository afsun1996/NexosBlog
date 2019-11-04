package top.afsun1996.nexos.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.sun.tools.corba.se.idl.constExpr.Equal;
import lombok.Data;

@Data
public class Article implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 文章id
     */
    private Long articleid;

    /**
     * 作者名称
     */
    private String author;

    /**
     * 原作者
     */
    private String originalauthor;

    /**
     * 文章标题
     */
    private String articletitle;

    /**
     * 文章内容
     */
    private String articlecontent;

    /**
     * 标签
     */
    private String articletags;

    /**
     * 类型
     */
    private String articletype;

    /**
     * 分类
     */
    private String articlecategories;

    /**
     * 发布日期
     */
    private Date publishdate;

    /**
     * 更新日文
     */
    private Date updatedate;

    /**
     * 文章地址
     */
    private String articleurl;

    /**
     * 摘要
     */
    private String articletabloid;

    /**
     * 点赞数
     */
    private Integer likes;

    /**
     * 评论
     */
    private List<Comments> comments;

    /**
     * 点击量
     */
    private Long views;

    /**
     * 文章类型
     */
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) &&
                Objects.equals(articleid, article.articleid) &&
                Objects.equals(author, article.author) &&
                Objects.equals(originalauthor, article.originalauthor) &&
                Objects.equals(articletitle, article.articletitle) &&
                Objects.equals(articlecontent, article.articlecontent) &&
                Objects.equals(articletags, article.articletags) &&
                Objects.equals(articletype, article.articletype) &&
                Objects.equals(articlecategories, article.articlecategories) &&
                Objects.equals(publishdate, article.publishdate) &&
                Objects.equals(updatedate, article.updatedate) &&
                Objects.equals(articleurl, article.articleurl) &&
                Objects.equals(articletabloid, article.articletabloid) &&
                Objects.equals(likes, article.likes) &&
                Objects.equals(comments, article.comments) &&
                Objects.equals(views, article.views);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articleid, author, originalauthor, articletitle, articlecontent, articletags, articletype, articlecategories, publishdate, updatedate, articleurl, articletabloid, likes, comments, views);
    }

    private static final long serialVersionUID = 1L;
}