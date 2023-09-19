package cn.lzy.mybatiscatalog;

import org.apache.ibatis.annotations.Mapper;

public interface ArticleMapper {

@Mapper
    public Article selectArticle(Integer id);

    public int updateArticle(Article article);
}
