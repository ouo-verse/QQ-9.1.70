package tencent.im.s2c.msgtype0x210.submsgtype0x158;

import com.tencent.bugly.common.trace.TraceSpan;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x158$TraceInfo extends MessageMicro<SubMsgType0x158$TraceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"trace_id", TraceSpan.KEY_SPAN_ID, "trace_flag"}, new Object[]{"", "", 0}, SubMsgType0x158$TraceInfo.class);
    public final PBStringField trace_id = PBField.initString("");
    public final PBStringField span_id = PBField.initString("");
    public final PBUInt32Field trace_flag = PBField.initUInt32(0);
}
