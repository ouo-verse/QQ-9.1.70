package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceProfile$GetUserISpacesRsp extends MessageMicro<QZIntimateSpaceProfile$GetUserISpacesRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"userspaces"}, new Object[]{null}, QZIntimateSpaceProfile$GetUserISpacesRsp.class);
    public final PBRepeatMessageField<QZIntimateSpaceProfile$UserSpaceEntry> userspaces = PBField.initRepeatMessage(QZIntimateSpaceProfile$UserSpaceEntry.class);
}
