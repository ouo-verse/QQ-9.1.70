package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudMeta$StUser;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StFavoritesFeedsPageRsp extends MessageMicro<QQCircleFeedBase$StFavoritesFeedsPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"title", "share_info", "author", "status"}, new Object[]{"", null, null, 0}, QQCircleFeedBase$StFavoritesFeedsPageRsp.class);
    public final PBStringField title = PBField.initString("");
    public FeedCloudMeta$StShare share_info = new FeedCloudMeta$StShare();
    public FeedCloudMeta$StUser author = new FeedCloudMeta$StUser();
    public final PBInt32Field status = PBField.initInt32(0);
}
