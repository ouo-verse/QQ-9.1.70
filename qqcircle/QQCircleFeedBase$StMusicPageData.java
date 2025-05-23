package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import feedcloud.FeedCloudMeta$StFeedMusic;
import feedcloud.FeedCloudMeta$StShare;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StMusicPageData extends MessageMicro<QQCircleFeedBase$StMusicPageData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 74}, new String[]{"music", "desc", "publishSchema", "title", QQWinkConstants.TAB_SUBTITLE, "include_music", "include_publish_schema", "is_collect", "shareInfo"}, new Object[]{null, "", "", "", "", null, "", Boolean.FALSE, null}, QQCircleFeedBase$StMusicPageData.class);
    public FeedCloudMeta$StFeedMusic music = new FeedCloudMeta$StFeedMusic();
    public final PBStringField desc = PBField.initString("");
    public final PBStringField publishSchema = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField subTitle = PBField.initString("");
    public FeedCloudMeta$StFeedMusic include_music = new FeedCloudMeta$StFeedMusic();
    public final PBStringField include_publish_schema = PBField.initString("");
    public final PBBoolField is_collect = PBField.initBool(false);
    public FeedCloudMeta$StShare shareInfo = new FeedCloudMeta$StShare();
}
