package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x51d$NoticeInfo extends MessageMicro<oidb_0x51d$NoticeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"opt_uint32_notice_count", "opt_uint32_notice_version"}, new Object[]{0, 0}, oidb_0x51d$NoticeInfo.class);
    public final PBUInt32Field opt_uint32_notice_count = PBField.initUInt32(0);
    public final PBUInt32Field opt_uint32_notice_version = PBField.initUInt32(0);
}
