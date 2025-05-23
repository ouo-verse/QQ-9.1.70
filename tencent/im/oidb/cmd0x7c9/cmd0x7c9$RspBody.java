package tencent.im.oidb.cmd0x7c9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7c9$RspBody extends MessageMicro<cmd0x7c9$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_next_time_gap", "rpt_hello_content"}, new Object[]{0, null}, cmd0x7c9$RspBody.class);
    public final PBUInt32Field uint32_next_time_gap = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x7c9$RspHelloContent> rpt_hello_content = PBField.initRepeatMessage(cmd0x7c9$RspHelloContent.class);
}
