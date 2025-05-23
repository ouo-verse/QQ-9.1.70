package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleMaterial$MaterialDetailInfos extends MessageMicro<QQCircleMaterial$MaterialDetailInfos> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"detail"}, new Object[]{null}, QQCircleMaterial$MaterialDetailInfos.class);
    public final PBRepeatMessageField<QQCircleMaterial$MaterialDetail> detail = PBField.initRepeatMessage(QQCircleMaterial$MaterialDetail.class);
}
