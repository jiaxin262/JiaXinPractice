package com.example.jiaxin.qunarnews.result;

import com.example.jiaxin.qunarnews.NewsItem.NewsItem;
import com.example.jiaxin.qunarnews.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaxin on 15-8-17.
 */
public class NewsListResult {

    public List<NewsItem> datas;
    public int code;
    public String msg;

    public static NewsListResult mock(){
        NewsListResult result = new NewsListResult();
        result.datas = new ArrayList<>();
        NewsItem newsItem = null;
        newsItem = new NewsItem();
        newsItem.title = "解读李克强的“当头炮”：将简政放权进行到底";
        newsItem.content = "截至7月28日，本届政府已召开100次国务院常务会议，播发100篇新闻通稿。你知道“简政放权”这4个字在新闻通稿中出现了多少次？";
        newsItem.imageId = R.drawable.demo_news_image1;
        result.datas.add(newsItem);
        newsItem = new NewsItem();
        newsItem.title = "抗战阅兵彩排最新照片 空警2000如泰山压顶";
        newsItem.content = "9月3日，纪念抗日战争胜利70周年阅兵仪式将在天安门广场举行。近日，参加阅兵的空中方队进行了多次彩排演练。";
        newsItem.imageId = R.drawable.demo_news_image2;
        result.datas.add(newsItem);
        newsItem = new NewsItem();
        newsItem.title = "美的少东家卷入做空疑团 旗下对冲基金账户被查";
        newsItem.content = "“阳光底下无新事”。一场由A股持续大跌而引发的力度空前的股市“维稳”，不但让家电大亨美的集团少东家卷入做空漩涡，亦令其创始人何享健父子的金融帝国浮出水面。";
        newsItem.imageId = R.drawable.demo_news_image3;
        result.datas.add(newsItem);
        newsItem = new NewsItem();
        newsItem.title = "体育总局排球运动管理中心主任潘志琛接受调查";
        newsItem.content = "据驻国家体育总局纪检组消息：国家体育总局排球运动管理中心主任潘志琛涉嫌严重违纪违法，目前正在接受组织调查。（驻国家体育总局纪检组）";
        newsItem.imageId = R.drawable.demo_news_image4;
        result.datas.add(newsItem);
        newsItem = new NewsItem();
        newsItem.title = "王岐山在下一盘很大的棋：将党纪和国法拆分";
        newsItem.content = "刚过去的一个月，相较于一年之前有过之而无不及。侠客岛（xiake_island）曾把2014年6月称为“风暴的六月”——那个月里，徐才厚、苏荣、令政策、万庆良等老虎先后落马；而在从6月25日到现在的38天里，则有包括郭伯雄、周本顺、奚晓明、肖天等在内的9只老虎被打掉。";
        newsItem.imageId = R.drawable.demo_news_image5;
        result.datas.add(newsItem);
        newsItem = new NewsItem();
        newsItem.title = "解读李克强的“当头炮”：将简政放权进行到底";
        newsItem.content = "截至7月28日，本届政府已召开100次国务院常务会议，播发100篇新闻通稿。你知道“简政放权”这4个字在新闻通稿中出现了多少次？";
        newsItem.imageId = R.drawable.demo_news_image1;
        result.datas.add(newsItem);
        newsItem = new NewsItem();
        newsItem.title = "抗战阅兵彩排最新照片 空警2000如泰山压顶";
        newsItem.content = "9月3日，纪念抗日战争胜利70周年阅兵仪式将在天安门广场举行。近日，参加阅兵的空中方队进行了多次彩排演练。";
        newsItem.imageId = R.drawable.demo_news_image2;
        result.datas.add(newsItem);
        newsItem = new NewsItem();
        newsItem.title = "美的少东家卷入做空疑团 旗下对冲基金账户被查";
        newsItem.content = "“阳光底下无新事”。一场由A股持续大跌而引发的力度空前的股市“维稳”，不但让家电大亨美的集团少东家卷入做空漩涡，亦令其创始人何享健父子的金融帝国浮出水面。";
        newsItem.imageId = R.drawable.demo_news_image3;
        result.datas.add(newsItem);
        newsItem = new NewsItem();
        newsItem.title = "体育总局排球运动管理中心主任潘志琛接受调查";
        newsItem.content = "据驻国家体育总局纪检组消息：国家体育总局排球运动管理中心主任潘志琛涉嫌严重违纪违法，目前正在接受组织调查。（驻国家体育总局纪检组）";
        newsItem.imageId = R.drawable.demo_news_image4;
        result.datas.add(newsItem);
        newsItem = new NewsItem();
        newsItem.title = "王岐山在下一盘很大的棋：将党纪和国法拆分";
        newsItem.content = "刚过去的一个月，相较于一年之前有过之而无不及。侠客岛（xiake_island）曾把2014年6月称为“风暴的六月”——那个月里，徐才厚、苏荣、令政策、万庆良等老虎先后落马；而在从6月25日到现在的38天里，则有包括郭伯雄、周本顺、奚晓明、肖天等在内的9只老虎被打掉。";
        newsItem.imageId = R.drawable.demo_news_image5;
        result.datas.add(newsItem);
        return result;
    }

    @Override
    public String toString() {
        return "code:" + code + "\n" +
                "msg:" + msg + "\n" +
                datas.toString();
    }
}
