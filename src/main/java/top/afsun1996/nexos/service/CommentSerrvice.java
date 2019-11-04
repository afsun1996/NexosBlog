package top.afsun1996.nexos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.afsun1996.nexos.mapper.CommentsMapper;
import top.afsun1996.nexos.po.Comments;

import java.util.List;

/**
 * @program: NexosBlog
 * @description:
 * @author: afsun
 * @create: 2019-11-01 09:46
 */
@Service
public class CommentSerrvice {

    @Autowired
    CommentsMapper mapper;

    
    /**
    *@Description: 获取对应文章的评论
    *@Param:
    *@return: 
    *@Author: afsun
    *@date: 2019/11/4
    */
    public List<Comments> selectByarticleid(int id){
        List<Comments> comments = this.mapper.selectByarticleid(id);
        return comments;
    }

    /**
    *@Description: 获取最新评论
    *@Param: 
    *@return: 
    *@Author: afsun
    *@date: 2019/11/4
    */
    public List<Comments> selectNew(){
        return mapper.selectNew();
    }

}