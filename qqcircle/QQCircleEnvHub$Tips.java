package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$Tips extends MessageMicro<QQCircleEnvHub$Tips> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"id", "text", "durationMs", "canExpose", "showAfterTime"}, new Object[]{0, "", 0, Boolean.FALSE, 0}, QQCircleEnvHub$Tips.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f429302id = PBField.initInt32(0);
    public final PBStringField text = PBField.initString("");
    public final PBUInt32Field durationMs = PBField.initUInt32(0);
    public final PBBoolField canExpose = PBField.initBool(false);
    public final PBUInt32Field showAfterTime = PBField.initUInt32(0);
}
