package tencent.im.oidb.oidb_0xd6c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd6c$ReqBody extends MessageMicro<oidb_0xd6c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_host_uin", "uint64_friend_uin"}, new Object[]{0L, 0L}, oidb_0xd6c$ReqBody.class);
    public final PBUInt64Field uint64_host_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0);
}
