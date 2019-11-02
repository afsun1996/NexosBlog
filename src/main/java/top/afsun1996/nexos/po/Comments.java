package top.afsun1996.nexos.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Comments implements Serializable {
    private Integer id;

    /**
     * 文章id
     */
    private Integer articleid;

    /**
     * 评论昵称
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 评论
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;
}