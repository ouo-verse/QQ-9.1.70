package tencent.im.s2c.msgtype0x210.submsgtype0x44;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x44$ClearCountMsg extends MessageMicro<submsgtype0x44$ClearCountMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_uin", "uint32_time", "uint32_processflag", "uint32_updateflag"}, new Object[]{0L, 0, 0, 0}, submsgtype0x44$ClearCountMsg.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_processflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_updateflag = PBField.initUInt32(0);
}
