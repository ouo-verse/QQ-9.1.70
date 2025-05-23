package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleLightinteract$StBatchGetUrgeStatusRsp extends MessageMicro<QQCircleLightinteract$StBatchGetUrgeStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"urgeStatusInfos"}, new Object[]{null}, QQCircleLightinteract$StBatchGetUrgeStatusRsp.class);
    public final PBRepeatMessageField<QQCircleLightinteract$StUrgeStatusInfo> urgeStatusInfos = PBField.initRepeatMessage(QQCircleLightinteract$StUrgeStatusInfo.class);
}
