package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$Entry;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StTabInfo extends MessageMicro<QQCircleFeedBase$StTabInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 56, 64, 74, 82, 90, 96, 106, 114, 122}, new String[]{"tabName", "tabType", "tagId", "status", "attachInfo", "urlInfo", "sourceType", "pageId", "serverCallee", "dtPgID", "subTabInfo", "defaultSubTabindex", "tabInfoFromYuheng", "tabInfoByOperators", "tabExtInfo"}, new Object[]{"", 0, "", 0, "", null, 0, 0, "", "", null, 0, ByteStringMicro.EMPTY, null, null}, QQCircleFeedBase$StTabInfo.class);
    public final PBStringField tabName = PBField.initString("");
    public final PBUInt32Field tabType = PBField.initUInt32(0);
    public final PBStringField tagId = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBInt32Field sourceType = PBField.initInt32(0);
    public final PBInt32Field pageId = PBField.initInt32(0);
    public final PBStringField serverCallee = PBField.initString("");
    public final PBStringField dtPgID = PBField.initString("");
    public final PBRepeatMessageField<QQCircleFeedBase$StSubTabInfo> subTabInfo = PBField.initRepeatMessage(QQCircleFeedBase$StSubTabInfo.class);
    public final PBUInt32Field defaultSubTabindex = PBField.initUInt32(0);
    public final PBBytesField tabInfoFromYuheng = PBField.initBytes(ByteStringMicro.EMPTY);
    public QQCircleFeedBase$StTabOpInfo tabInfoByOperators = new QQCircleFeedBase$StTabOpInfo();
    public final PBRepeatMessageField<FeedCloudCommon$Entry> tabExtInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
