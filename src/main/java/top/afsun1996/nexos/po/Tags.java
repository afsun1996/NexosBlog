package top.afsun1996.nexos.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Tags implements Serializable {
    /**
    * 标签id
    */
    private Integer id;

    /**
    * 标签名
    */
    private String tagname;

    /**
     * 标签使用数量
     */
    private String refnum;


    /**
    * 更新时间
    */
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}