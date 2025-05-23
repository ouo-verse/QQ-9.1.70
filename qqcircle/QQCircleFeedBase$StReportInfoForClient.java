package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StReportInfoForClient extends MessageMicro<QQCircleFeedBase$StReportInfoForClient> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"feedtype1", "feedtype2", "feedtype3", "datongJsonData"}, new Object[]{0, 0, 0, ""}, QQCircleFeedBase$StReportInfoForClient.class);
    public final PBUInt32Field feedtype1 = PBField.initUInt32(0);
    public final PBUInt32Field feedtype2 = PBField.initUInt32(0);
    public final PBUInt32Field feedtype3 = PBField.initUInt32(0);
    public final PBStringField datongJsonData = PBField.initString("");
}
