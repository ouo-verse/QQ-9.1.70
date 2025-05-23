package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StRecentWatchPageData extends MessageMicro<QQCircleFeedBase$StRecentWatchPageData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"topContent", "bottomContent"}, new Object[]{"", ""}, QQCircleFeedBase$StRecentWatchPageData.class);
    public final PBStringField topContent = PBField.initString("");
    public final PBStringField bottomContent = PBField.initString("");
}
