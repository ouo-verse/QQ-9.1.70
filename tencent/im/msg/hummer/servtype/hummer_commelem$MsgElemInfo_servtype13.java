package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype13 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype13> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_sys_head_id", "uint32_head_flag"}, new Object[]{0, 0}, hummer_commelem$MsgElemInfo_servtype13.class);
    public final PBUInt32Field uint32_sys_head_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_head_flag = PBField.initUInt32(0);
}
