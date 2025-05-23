package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StSingleRecomReportInfo extends MessageMicro<QQCircleFeedBase$StSingleRecomReportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"reportID", "reportData"}, new Object[]{"", ByteStringMicro.EMPTY}, QQCircleFeedBase$StSingleRecomReportInfo.class);
    public final PBStringField reportID = PBField.initString("");
    public final PBBytesField reportData = PBField.initBytes(ByteStringMicro.EMPTY);
}
