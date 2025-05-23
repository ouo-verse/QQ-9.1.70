package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceProfile$GetISpaceInfoReq extends MessageMicro<QZIntimateSpaceProfile$GetISpaceInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"spaces"}, new Object[]{null}, QZIntimateSpaceProfile$GetISpaceInfoReq.class);
    public final PBRepeatMessageField<QZIntimateSpaceProfile$StIntimateSpace> spaces = PBField.initRepeatMessage(QZIntimateSpaceProfile$StIntimateSpace.class);
}
