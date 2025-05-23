package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleMaterial$MaterialDetail extends MessageMicro<QQCircleMaterial$MaterialDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"MaterialKeyInt", "MaterialValue"}, new Object[]{0, ""}, QQCircleMaterial$MaterialDetail.class);
    public final PBInt32Field MaterialKeyInt = PBField.initInt32(0);
    public final PBStringField MaterialValue = PBField.initString("");
}
