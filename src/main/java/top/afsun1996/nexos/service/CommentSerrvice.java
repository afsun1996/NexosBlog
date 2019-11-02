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


    public List<Comments> selectByarticleid(int id){
        List<Comments> comments = this.mapper.selectByarticleid(id);
        return comments;
    }

}