package qqcircle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDitto$StFeedItemInfo extends MessageMicro<QQCircleDitto$StFeedItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"normalFeed", WadlProxyConsts.KEY_JUMP_URL}, new Object[]{null, ""}, QQCircleDitto$StFeedItemInfo.class);
    public FeedCloudMeta$StFeed normalFeed = new FeedCloudMeta$StFeed();
    public final PBStringField jumpUrl = PBField.initString("");
}
