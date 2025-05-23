package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7f5$RspBody extends MessageMicro<cmd0x7f5$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_completed_flag", "uint32_recruit_number", "rpt_group_info", "bytes_req_context"}, new Object[]{0, 0, null, ByteStringMicro.EMPTY}, cmd0x7f5$RspBody.class);
    public final PBUInt32Field uint32_completed_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recruit_number = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x7f5$GroupInfo> rpt_group_info = PBField.initRepeatMessage(cmd0x7f5$GroupInfo.class);
    public final PBBytesField bytes_req_context = PBField.initBytes(ByteStringMicro.EMPTY);
}
