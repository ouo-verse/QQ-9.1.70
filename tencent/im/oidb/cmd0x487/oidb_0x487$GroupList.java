package tencent.im.oidb.cmd0x487;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x487$GroupList extends MessageMicro<oidb_0x487$GroupList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_groupcode", "uint64_opt_uin", "bytes_group_name"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY}, oidb_0x487$GroupList.class);
    public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0);
    public final PBUInt64Field uint64_opt_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
}
