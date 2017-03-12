package com.jeecms.plug.spider;

import com.google.gson.Gson;
import com.jeecms.plug.spider.processor.CsdnBlogPageProcessor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import java.util.List;

/**
 * Created by cc on 17-3-12.
 */
public class BlogSpider {

    public List<String> getBlogListByUserName(String username){
        long startTime, endTime;
        System.out.println("【爬虫开始】请耐心等待一大波数据到你碗里来...");
        startTime = System.currentTimeMillis();
        // 从用户博客首页开始抓，开启5个线程，启动爬虫
        CsdnBlogPageProcessor cbpp=new CsdnBlogPageProcessor();
        Spider.create(cbpp).addUrl("http://blog.csdn.net/" + username).thread(5).run();
        endTime = System.currentTimeMillis();

        System.out.println("【爬虫结束】共抓取" + cbpp.size + "篇文章，耗时约" + ((endTime - startTime) / 1000) + "秒，已保存到数据库，请查收！");
        return null;
    }

}
