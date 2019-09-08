package top.afsun1996.nexos.po;

import java.io.Serializable;
import java.util.Date;
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

    private static final long serialVersionUID = 1L;
}