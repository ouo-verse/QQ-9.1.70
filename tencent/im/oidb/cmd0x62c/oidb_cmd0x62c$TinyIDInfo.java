package tencent.im.oidb.cmd0x62c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x62c$TinyIDInfo extends MessageMicro<oidb_cmd0x62c$TinyIDInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_appid", "uint64_uin", "uint64_tinyid"}, new Object[]{0, 0L, 0L}, oidb_cmd0x62c$TinyIDInfo.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
}
