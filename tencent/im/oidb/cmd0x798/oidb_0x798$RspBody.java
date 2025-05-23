package tencent.im.oidb.cmd0x798;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x798$RspBody extends MessageMicro<oidb_0x798$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_result", "errMsg", "stInfos", "uint64_sleeptime"}, new Object[]{0, ByteStringMicro.EMPTY, null, 0L}, oidb_0x798$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x798$Info> stInfos = PBField.initRepeatMessage(oidb_0x798$Info.class);
    public final PBUInt64Field uint64_sleeptime = PBField.initUInt64(0);
}
