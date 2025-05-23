package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleClientData$MsgBizReport extends MessageMicro<QQCircleClientData$MsgBizReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 56, 66}, new String[]{"subtype", "id", "opUid", "taskTransfer", "noticePattonType", "schemaUrl", "withPic", "datongJsonData"}, new Object[]{0, "", "", "", 0, "", 0, ""}, QQCircleClientData$MsgBizReport.class);
    public final PBInt32Field subtype = PBField.initInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429296id = PBField.initString("");
    public final PBStringField opUid = PBField.initString("");
    public final PBStringField taskTransfer = PBField.initString("");
    public final PBInt32Field noticePattonType = PBField.initInt32(0);
    public final PBStringField schemaUrl = PBField.initString("");
    public final PBInt32Field withPic = PBField.initInt32(0);
    public final PBStringField datongJsonData = PBField.initString("");
}
