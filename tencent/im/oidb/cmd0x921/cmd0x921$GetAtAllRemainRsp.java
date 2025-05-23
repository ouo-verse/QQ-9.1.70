package tencent.im.oidb.cmd0x921;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x921$GetAtAllRemainRsp extends MessageMicro<cmd0x921$GetAtAllRemainRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_uin", "uint32_uin_remain", "uint64_discuss_uin", "uint32_discuss_uin_remain", "bool_priviledge"}, new Object[]{0L, 0, 0L, 0, Boolean.FALSE}, cmd0x921$GetAtAllRemainRsp.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_uin_remain = PBField.initUInt32(0);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_discuss_uin_remain = PBField.initUInt32(0);
    public final PBBoolField bool_priviledge = PBField.initBool(false);
}
