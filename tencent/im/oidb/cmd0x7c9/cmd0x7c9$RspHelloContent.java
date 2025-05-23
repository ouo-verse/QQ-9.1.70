package tencent.im.oidb.cmd0x7c9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7c9$RspHelloContent extends MessageMicro<cmd0x7c9$RspHelloContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_req_type", "uint32_next_time_gap"}, new Object[]{0, 0}, cmd0x7c9$RspHelloContent.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_time_gap = PBField.initUInt32(0);
}
