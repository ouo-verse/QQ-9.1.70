package tencent.im.oidb.cmd0x6f6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x6f6$RspBody extends MessageMicro<oidb_cmd0x6f6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_rsp_info", "str_errinfo"}, new Object[]{null, ByteStringMicro.EMPTY}, oidb_cmd0x6f6$RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0x6f6$RspInfo> rpt_msg_rsp_info = PBField.initRepeatMessage(oidb_cmd0x6f6$RspInfo.class);
    public final PBBytesField str_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
