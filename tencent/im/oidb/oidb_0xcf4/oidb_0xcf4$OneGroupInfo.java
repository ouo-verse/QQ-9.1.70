package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$OneGroupInfo extends MessageMicro<oidb_0xcf4$OneGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_group_uin", "uint64_group_code", "string_group_name", "uint32_cmduin_last_msg_time"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY, 0}, oidb_0xcf4$OneGroupInfo.class);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBBytesField string_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cmduin_last_msg_time = PBField.initUInt32(0);
}
