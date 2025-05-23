package tencent.im.oidb.cmd0x8fd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x8fd$ReqBody extends MessageMicro<Oidb_0x8fd$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"rpt_uint64_group_code", "msg_reqfilter"}, new Object[]{0L, null}, Oidb_0x8fd$ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public Oidb_0x8fd$ReqFilter msg_reqfilter = new MessageMicro<Oidb_0x8fd$ReqFilter>() { // from class: tencent.im.oidb.cmd0x8fd.Oidb_0x8fd$ReqFilter
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_level_name_flag"}, new Object[]{0}, Oidb_0x8fd$ReqFilter.class);
        public final PBUInt32Field uint32_level_name_flag = PBField.initUInt32(0);
    };
}
