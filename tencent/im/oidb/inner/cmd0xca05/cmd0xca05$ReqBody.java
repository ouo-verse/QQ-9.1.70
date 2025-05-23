package tencent.im.oidb.inner.cmd0xca05;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xca05$ReqBody extends MessageMicro<cmd0xca05$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_type", "rpt_app_ids", "msg_app_info"}, new Object[]{0, 0L, null}, cmd0xca05$ReqBody.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_app_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public cmd0xca05$AppInfo msg_app_info = new cmd0xca05$AppInfo();
}
