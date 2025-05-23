package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceProfile$ModISpaceInfoReq extends MessageMicro<QZIntimateSpaceProfile$ModISpaceInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"space"}, new Object[]{null}, QZIntimateSpaceProfile$ModISpaceInfoReq.class);
    public final PBRepeatMessageField<QZIntimateSpaceProfile$StIntimateSpace> space = PBField.initRepeatMessage(QZIntimateSpaceProfile$StIntimateSpace.class);
}
