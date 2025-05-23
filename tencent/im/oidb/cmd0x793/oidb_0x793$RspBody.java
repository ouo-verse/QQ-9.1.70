package tencent.im.oidb.cmd0x793;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x793$RspBody extends MessageMicro<oidb_0x793$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_result", "errMsg", "rpt_uinlist", "uint32_flag"}, new Object[]{0, ByteStringMicro.EMPTY, null, 0}, oidb_0x793$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x793$UinListInfo> rpt_uinlist = PBField.initRepeatMessage(oidb_0x793$UinListInfo.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
}
