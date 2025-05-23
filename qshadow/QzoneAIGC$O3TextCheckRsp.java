package qshadow;

import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QzoneAIGC$O3TextCheckRsp extends MessageMicro<QzoneAIGC$O3TextCheckRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"code", "msg", NativeMonitorConfigHelper.SUB_KEY_LEGAL}, new Object[]{0, "", Boolean.FALSE}, QzoneAIGC$O3TextCheckRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f429486msg = PBField.initString("");
    public final PBBoolField is_legal = PBField.initBool(false);
}
