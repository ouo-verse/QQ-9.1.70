package tencent.im.oidb.cmd0x51c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x51c$NoticeVar extends MessageMicro<oidb_0x51c$NoticeVar> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"opt_uint32_operate_type", "opt_uint32_notice_var", "opt_uint32_notice_version"}, new Object[]{0, 0, 0}, oidb_0x51c$NoticeVar.class);
    public final PBUInt32Field opt_uint32_operate_type = PBField.initUInt32(0);
    public final PBUInt32Field opt_uint32_notice_var = PBField.initUInt32(0);
    public final PBUInt32Field opt_uint32_notice_version = PBField.initUInt32(0);
}
