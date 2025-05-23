package tencent.im.oidb.cmd0x897;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x897$RspBody extends MessageMicro<cmd0x897$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "rpt_msg_grp_visitor_info", "str_err_msg"}, new Object[]{0, null, ""}, cmd0x897$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x897$GroupVisitorInfo> rpt_msg_grp_visitor_info = PBField.initRepeatMessage(cmd0x897$GroupVisitorInfo.class);
    public final PBStringField str_err_msg = PBField.initString("");
}
