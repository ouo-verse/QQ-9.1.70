package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x95a$GetArActivityRedRsp extends MessageMicro<cmd0x95a$GetArActivityRedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint32_red_switch", "uint64_server_activity_id"}, new Object[]{0L, 0, 0L}, cmd0x95a$GetArActivityRedRsp.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_red_switch = PBField.initUInt32(0);
    public final PBUInt64Field uint64_server_activity_id = PBField.initUInt64(0);
}
