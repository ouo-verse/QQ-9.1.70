package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.soload.biz.SoLoadIPCModule;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCSafe$SafeCheckRequest extends MessageMicro<ShadowAIGCSafe$SafeCheckRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"busi_id", "medias", SoLoadIPCModule.KEY_IS_SYNC}, new Object[]{"", null, Boolean.FALSE}, ShadowAIGCSafe$SafeCheckRequest.class);
    public final PBStringField busi_id = PBField.initString("");
    public final PBRepeatMessageField<ShadowAIGCSafe$Media> medias = PBField.initRepeatMessage(ShadowAIGCSafe$Media.class);
    public final PBBoolField is_sync = PBField.initBool(false);
}
