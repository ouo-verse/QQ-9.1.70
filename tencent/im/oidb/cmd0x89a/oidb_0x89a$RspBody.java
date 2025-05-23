package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x89a$RspBody extends MessageMicro<oidb_0x89a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_group_code", "str_errorinfo"}, new Object[]{0L, ByteStringMicro.EMPTY}, oidb_0x89a$RspBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBBytesField str_errorinfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
