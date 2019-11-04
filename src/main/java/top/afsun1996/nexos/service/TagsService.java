package top.afsun1996.nexos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.afsun1996.nexos.mapper.TagsMapper;
import top.afsun1996.nexos.po.Tags;

import java.util.List;

/**
 * @program: NexosBlog
 * @description:
 * @author: afsun
 * @create: 2019-11-04 15:49
 */
@Service
public class TagsService {

    @Autowired
    TagsMapper mapper;

    public List<Tags> selectAllTags(){
        return this.mapper.selectAllTags();
    }

}