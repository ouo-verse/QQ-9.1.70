package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xae9$GetListReq extends MessageMicro<Oidb_0xae9$GetListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_code", "start", "limit"}, new Object[]{0L, 0, 0}, Oidb_0xae9$GetListReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
}
