package tencent.im.oidb.cmd0x58a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x58a$ConfBaseInfo extends MessageMicro<cmd0x58a$ConfBaseInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_conf_uin", "uint32_is_favorite", "uint32_info_seq", "uint32_member_num"}, new Object[]{0L, 0, 0, 0}, cmd0x58a$ConfBaseInfo.class);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_is_favorite = PBField.initUInt32(0);
    public final PBUInt32Field uint32_info_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
}
