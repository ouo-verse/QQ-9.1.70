package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc35$ReqBody extends MessageMicro<oidb_0xc35$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "rpt_msg_expose_info"}, new Object[]{0L, null}, oidb_0xc35$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0xc35$ExposeItem> rpt_msg_expose_info = PBField.initRepeatMessage(oidb_0xc35$ExposeItem.class);
}
