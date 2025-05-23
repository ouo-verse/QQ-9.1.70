package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StShare;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StGpsPageData extends MessageMicro<QQCircleFeedBase$StGpsPageData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"pageDesc", "subsidiaryFieldDesc", "poiName", "shareInfo", "coverInfo"}, new Object[]{"", null, "", null, null}, QQCircleFeedBase$StGpsPageData.class);
    public final PBStringField pageDesc = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$Entry> subsidiaryFieldDesc = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBStringField poiName = PBField.initString("");
    public FeedCloudMeta$StShare shareInfo = new FeedCloudMeta$StShare();
    public FeedCloudMeta$StImage coverInfo = new FeedCloudMeta$StImage();
}
