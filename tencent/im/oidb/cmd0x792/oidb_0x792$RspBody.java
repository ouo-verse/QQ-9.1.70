package tencent.im.oidb.cmd0x792;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x792$RspBody extends MessageMicro<oidb_0x792$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"uint32_result", "errMsg", "uint32_newnum", "uint32_sleeptime", "uint64_lastuin"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0, 0L}, oidb_0x792$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_newnum = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sleeptime = PBField.initUInt32(0);
    public final PBUInt64Field uint64_lastuin = PBField.initUInt64(0);
}
