package qshadow;

import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCSafe$SafeCheckReply extends MessageMicro<ShadowAIGCSafe$SafeCheckReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{NativeMonitorConfigHelper.SUB_KEY_LEGAL, "msg_id"}, new Object[]{Boolean.FALSE, ""}, ShadowAIGCSafe$SafeCheckReply.class);
    public final PBBoolField is_legal = PBField.initBool(false);
    public final PBStringField msg_id = PBField.initString("");
}
