package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x26$AppNotifyUser extends MessageMicro<submsgtype0x26$AppNotifyUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"opt_uint64_uin", "opt_uint32_flag"}, new Object[]{0L, 0}, submsgtype0x26$AppNotifyUser.class);
    public final PBUInt64Field opt_uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field opt_uint32_flag = PBField.initUInt32(0);
}
