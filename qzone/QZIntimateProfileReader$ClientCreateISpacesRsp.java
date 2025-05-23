package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$ClientCreateISpacesRsp extends MessageMicro<QZIntimateProfileReader$ClientCreateISpacesRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"space_id", "ext"}, new Object[]{"", null}, QZIntimateProfileReader$ClientCreateISpacesRsp.class);
    public final PBStringField space_id = PBField.initString("");
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
}
