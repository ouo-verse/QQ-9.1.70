package tencent.im.oidb.cmd0xa79;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa79$RspBody extends MessageMicro<oidb_0xa79$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_real_state", "uint32_bind_num", "uint32_id_level", "enum_upload_cre"}, new Object[]{0, 0, 0, 0}, oidb_0xa79$RspBody.class);
    public final PBUInt32Field uint32_real_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bind_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_id_level = PBField.initUInt32(0);
    public final PBEnumField enum_upload_cre = PBField.initEnum(0);
}
