package com.consdata.solejnik.newssearch.mapper;

import com.consdata.solejnik.newssearch.dto.Article;
import com.consdata.solejnik.newssearch.newsapi.dto.ExternalArticle;
import com.consdata.solejnik.newssearch.newsapi.dto.ExternalSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.GregorianCalendar;

@RunWith(SpringRunner.class)
public class ArticleMapperTest {

    @Test
    public void should_properlyMapArticle() {

        // given
        final String author = "stefan";

        final String sourceName = "immortal";
        final ExternalSource source = new ExternalSource();
        source.setName(sourceName);
        final String expectedDate = "2019-09-26";
        final ExternalArticle externalArticle = new ExternalArticle();
        externalArticle.setAuthor(author);
        externalArticle.setPublishedAt(new GregorianCalendar(2019, Calendar.SEPTEMBER, 26).getTime());
        externalArticle.setSource(source);

        // when
        Article actualArticle = ArticleMapper.map(externalArticle);

        //
        Assert.assertEquals(author, actualArticle.getAuthor());
        Assert.assertEquals(expectedDate, actualArticle.getDate());
        Assert.assertEquals(sourceName, actualArticle.getSourceName());
    }
}
