package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleMaterial$MaterialRspInfo extends MessageMicro<QQCircleMaterial$MaterialRspInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"detail"}, new Object[]{null}, QQCircleMaterial$MaterialRspInfo.class);
    public final PBRepeatMessageField<QQCircleMaterial$MaterialInfo> detail = PBField.initRepeatMessage(QQCircleMaterial$MaterialInfo.class);
}
