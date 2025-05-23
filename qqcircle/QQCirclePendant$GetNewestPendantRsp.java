package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCirclePendant$GetNewestPendantRsp extends MessageMicro<QQCirclePendant$GetNewestPendantRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pendantInfos"}, new Object[]{null}, QQCirclePendant$GetNewestPendantRsp.class);
    public final PBRepeatMessageField<QQCirclePendant$UserPendantInfo> pendantInfos = PBField.initRepeatMessage(QQCirclePendant$UserPendantInfo.class);
}
