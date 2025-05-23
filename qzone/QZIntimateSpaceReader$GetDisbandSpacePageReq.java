package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetDisbandSpacePageReq extends MessageMicro<QZIntimateSpaceReader$GetDisbandSpacePageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext", "space_id"}, new Object[]{null, ""}, QZIntimateSpaceReader$GetDisbandSpacePageReq.class);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBStringField space_id = PBField.initString("");
}
