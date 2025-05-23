package tencent.im.oidb.cmd0x984;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x984$ReqBody extends MessageMicro<oidb_0x984$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_subcmd", "msg_read_report_req"}, new Object[]{0, null}, oidb_0x984$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public oidb_0x984$ReadReportReq msg_read_report_req = new MessageMicro<oidb_0x984$ReadReportReq>() { // from class: tencent.im.oidb.cmd0x984.oidb_0x984$ReadReportReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_conf_uin", "uint32_msg_seq", "uint64_from_uin"}, new Object[]{0L, 0, 0L}, oidb_0x984$ReadReportReq.class);
        public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    };
}
