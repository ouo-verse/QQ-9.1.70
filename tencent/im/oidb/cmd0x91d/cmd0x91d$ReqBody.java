package tencent.im.oidb.cmd0x91d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x91d$ReqBody extends MessageMicro<cmd0x91d$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_req_uin", "uint64_last_time"}, new Object[]{0L, 0L}, cmd0x91d$ReqBody.class);
    public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_last_time = PBField.initUInt64(0);
}
