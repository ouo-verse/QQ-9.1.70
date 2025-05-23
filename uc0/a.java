package uc0;

import android.text.SpannableString;
import com.tencent.biz.qqcircle.utils.l;
import com.tencent.mobileqq.R;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f438778a = l.d("exp_tagstrengthen_2");

    public static RichTextPreloadParserInfo a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        RichTextPreloadParserInfo richTextPreloadParserInfo = new RichTextPreloadParserInfo("immersive_feed_content_", new SpannableString(feedCloudMeta$StFeed.content.get()));
        richTextPreloadParserInfo.setConfig(new RichTextPreloadConfig().setImageSpanConfig(new RichTextPreloadConfig.TextImageSpanConfig()).setAtConfig(new RichTextPreloadConfig.TextAtConfig().setSpecialAreaColorId(R.color.f158017al3).setNeedSpecialAreaBold(true)).setTagConfig(new RichTextPreloadConfig.TextHashTagConfig().setSpecialAreaColorId(R.color.f158017al3).setNeedSpecialAreaBold(true).setSpecialAreaHashTagBackgroundColorId(R.color.cbq).setSpecialAreaHasBackgroundColorId(R.color.cbp).setNeedSpecialHashTagAreaBackground(f438778a)));
        return richTextPreloadParserInfo;
    }

    public static RichTextPreloadParserInfo b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return c(feedCloudMeta$StFeed, R.color.qvideo_skin_color_text_primary, false);
    }

    public static RichTextPreloadParserInfo c(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, boolean z16) {
        RichTextPreloadParserInfo richTextPreloadParserInfo = new RichTextPreloadParserInfo("mix_feed_content_", new SpannableString(feedCloudMeta$StFeed.content.get()));
        richTextPreloadParserInfo.setConfig(new RichTextPreloadConfig().setImageSpanConfig(new RichTextPreloadConfig.TextImageSpanConfig()).setAtConfig(new RichTextPreloadConfig.TextAtConfig().setSpecialAreaColorId(i3, z16).setNeedSpecialAreaBold(false)).setTagConfig(new RichTextPreloadConfig.TextHashTagConfig().setNeedSpecialAreaBold(false).setSpecialAreaColorId(i3, z16).setNeedSpecialHashTagAreaBackground(false).setTagTextSize(12)));
        return richTextPreloadParserInfo;
    }

    public static RichTextPreloadParserInfo d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        RichTextPreloadParserInfo richTextPreloadParserInfo = new RichTextPreloadParserInfo("pic_detail_feed_des_", new SpannableString(feedCloudMeta$StFeed.content.get()));
        richTextPreloadParserInfo.setConfig(new RichTextPreloadConfig().setImageSpanConfig(new RichTextPreloadConfig.TextImageSpanConfig()).setAtConfig(new RichTextPreloadConfig.TextAtConfig()).setTagConfig(new RichTextPreloadConfig.TextHashTagConfig().setSpecialAreaColorId(R.color.cla).setNeedSpecialAreaBold(true).setNeedSpecialHashTagAreaBackground(false)));
        return richTextPreloadParserInfo;
    }

    public static void e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        RFWPreloadParseRichTextHelper.g().preloadParserBaseRuleText(d(feedCloudMeta$StFeed));
        if (uq3.c.g6()) {
            RFWPreloadParseRichTextHelper.g().preloadParserBaseRuleText(a(feedCloudMeta$StFeed));
        }
        RFWPreloadParseRichTextHelper.g().preloadParserBaseRuleText(b(feedCloudMeta$StFeed));
    }
}
