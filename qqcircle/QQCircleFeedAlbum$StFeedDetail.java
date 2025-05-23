package qqcircle;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$StFeedDetail extends MessageMicro<QQCircleFeedAlbum$StFeedDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{WidgetCacheConstellationData.NUM, "feed"}, new Object[]{0, null}, QQCircleFeedAlbum$StFeedDetail.class);
    public final PBInt32Field num = PBField.initInt32(0);
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
}
