package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xc83$ReqBody extends MessageMicro<cmd0xc83$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{808, 816, 824}, new String[]{"uint64_from_uin", "uint64_to_uin", "uint32_op"}, new Object[]{0L, 0L, 0}, cmd0xc83$ReqBody.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_op = PBField.initUInt32(0);
}
