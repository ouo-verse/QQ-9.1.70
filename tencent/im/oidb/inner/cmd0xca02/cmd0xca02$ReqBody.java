package tencent.im.oidb.inner.cmd0xca02;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xca02$ReqBody extends MessageMicro<cmd0xca02$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uint32_type", "rpt_app_ids", "msg_app_info", "uint64_group_code", "uint32_group_type"}, new Object[]{0, 0, null, 0L, 0}, cmd0xca02$ReqBody.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_app_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public cmd0xca02$AppInfo msg_app_info = new cmd0xca02$AppInfo();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
}
