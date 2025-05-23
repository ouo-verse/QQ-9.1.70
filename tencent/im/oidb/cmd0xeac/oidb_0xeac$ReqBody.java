package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeac$ReqBody extends MessageMicro<oidb_0xeac$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_code", "msg_seq", "msg_random"}, new Object[]{0L, 0, 0}, oidb_0xeac$ReqBody.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_random = PBField.initUInt32(0);
}
