package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StImage;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StSubTabInfo extends MessageMicro<QQCircleFeedBase$StSubTabInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 56, 66, 74}, new String[]{"tabName", "sourceType", "tagId", "status", "urlInfo", "pendantInfo", "pageId", "dtPgID", "busiInfo"}, new Object[]{"", 0, "", 0, null, null, 0, "", null}, QQCircleFeedBase$StSubTabInfo.class);
    public final PBStringField tabName = PBField.initString("");
    public final PBInt32Field sourceType = PBField.initInt32(0);
    public final PBStringField tagId = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public FeedCloudMeta$StImage pendantInfo = new FeedCloudMeta$StImage();
    public final PBInt32Field pageId = PBField.initInt32(0);
    public final PBStringField dtPgID = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$Entry> busiInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
