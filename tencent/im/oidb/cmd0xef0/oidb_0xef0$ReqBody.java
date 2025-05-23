package tencent.im.oidb.cmd0xef0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xef0$ReqBody extends MessageMicro<oidb_0xef0$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"rpt_uint64_group_code", "msg_group_info_ext"}, new Object[]{0L, null}, oidb_0xef0$ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public oidb_0xef0$GroupInfoExt msg_group_info_ext = new oidb_0xef0$GroupInfoExt();
}
