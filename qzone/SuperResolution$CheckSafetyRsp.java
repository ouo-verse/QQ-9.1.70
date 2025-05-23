package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$CheckSafetyRsp extends MessageMicro<SuperResolution$CheckSafetyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_harmful"}, new Object[]{Boolean.FALSE}, SuperResolution$CheckSafetyRsp.class);
    public final PBBoolField is_harmful = PBField.initBool(false);
}
