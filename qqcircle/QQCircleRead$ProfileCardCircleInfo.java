package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleRead$ProfileCardCircleInfo extends MessageMicro<QQCircleRead$ProfileCardCircleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"userCircleList"}, new Object[]{null}, QQCircleRead$ProfileCardCircleInfo.class);
    public final PBRepeatMessageField<QQCircleRead$UserCircleSimpleInfo> userCircleList = PBField.initRepeatMessage(QQCircleRead$UserCircleSimpleInfo.class);
}
