package top.afsun1996.nexos.mapper;

import top.afsun1996.nexos.po.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}