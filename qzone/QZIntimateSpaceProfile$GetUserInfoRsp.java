package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceProfile$GetUserInfoRsp extends MessageMicro<QZIntimateSpaceProfile$GetUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"fields"}, new Object[]{null}, QZIntimateSpaceProfile$GetUserInfoRsp.class);
    public final PBRepeatMessageField<QZoneBaseCommon$Entry> fields = PBField.initRepeatMessage(QZoneBaseCommon$Entry.class);
}
