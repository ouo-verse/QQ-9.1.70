package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class generalflags$IconInfo extends MessageMicro<generalflags$IconInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_res_id", "uint32_expired_time", "uint32_permission_switch", "uint32_biz_id"}, new Object[]{0, 0, 0, 0}, generalflags$IconInfo.class);
    public final PBUInt32Field uint32_res_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expired_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_permission_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biz_id = PBField.initUInt32(0);
}
