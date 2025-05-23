package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$ClientModISpaceInfoReq extends MessageMicro<QZIntimateProfileReader$ClientModISpaceInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"space_id", "fields", "ext_info"}, new Object[]{"", null, null}, QZIntimateProfileReader$ClientModISpaceInfoReq.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseCommon$Entry> fields = PBField.initRepeatMessage(QZoneBaseCommon$Entry.class);
    public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
}
