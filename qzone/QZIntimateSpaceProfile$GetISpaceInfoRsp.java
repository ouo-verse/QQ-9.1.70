package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceProfile$GetISpaceInfoRsp extends MessageMicro<QZIntimateSpaceProfile$GetISpaceInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"spaces"}, new Object[]{null}, QZIntimateSpaceProfile$GetISpaceInfoRsp.class);
    public final PBRepeatMessageField<QZIntimateSpaceProfile$StIntimateSpace> spaces = PBField.initRepeatMessage(QZIntimateSpaceProfile$StIntimateSpace.class);
}
