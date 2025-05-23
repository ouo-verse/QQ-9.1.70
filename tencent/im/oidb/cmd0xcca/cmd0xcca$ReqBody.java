package tencent.im.oidb.cmd0xcca;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xcca$ReqBody extends MessageMicro<cmd0xcca$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_grp_code", "uint64_msg_seq", "uint64_uin"}, new Object[]{0L, 0L, 0L}, cmd0xcca$ReqBody.class);
    public final PBUInt64Field uint64_grp_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
}
