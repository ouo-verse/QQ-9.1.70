package tencent.im.oidb.cmd0x984;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x984$RspBody extends MessageMicro<oidb_0x984$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_code", "bytes_err_msg", "msg_read_report_rsp"}, new Object[]{0, ByteStringMicro.EMPTY, null}, oidb_0x984$RspBody.class);
    public final PBUInt32Field uint32_code = PBField.initUInt32(0);
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x984$ReadReportRsp msg_read_report_rsp = new MessageMicro<oidb_0x984$ReadReportRsp>() { // from class: tencent.im.oidb.cmd0x984.oidb_0x984$ReadReportRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0x984$ReadReportRsp.class);
    };
}
