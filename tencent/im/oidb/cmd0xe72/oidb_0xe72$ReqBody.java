package tencent.im.oidb.cmd0xe72;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe72$ReqBody extends MessageMicro<oidb_0xe72$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_grp_code", "uint64_uin", "bytes_join_group_auth", "uint32_edu_support_no_verify"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY, 0}, oidb_0xe72$ReqBody.class);
    public final PBUInt64Field uint64_grp_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_join_group_auth = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_edu_support_no_verify = PBField.initUInt32(0);
}
