package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceProfile$ModUserInfoReq extends MessageMicro<QZIntimateSpaceProfile$ModUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"fields"}, new Object[]{null}, QZIntimateSpaceProfile$ModUserInfoReq.class);
    public final PBRepeatMessageField<QZoneBaseCommon$Entry> fields = PBField.initRepeatMessage(QZoneBaseCommon$Entry.class);
}
