package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb60$CheckUrlRsp extends MessageMicro<oidb_0xb60$CheckUrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"is_authed", "next_req_duration"}, new Object[]{Boolean.FALSE, 0}, oidb_0xb60$CheckUrlRsp.class);
    public final PBBoolField is_authed = PBField.initBool(false);
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
}
