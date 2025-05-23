package tencent.im.group_pro_proto.oidb0xf62;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.group_pro_proto.common.common$FreqLimitInfo;
import tencent.im.group_pro_proto.common.common$MsgHead;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb0xf62$RspBody extends MessageMicro<Oidb0xf62$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50, 58}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "send_time", "head", "err_type", "trans_svr_info", "freq_limit_info"}, new Object[]{0, ByteStringMicro.EMPTY, 0, null, 0, null, null}, Oidb0xf62$RspBody.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field send_time = PBField.initUInt32(0);
    public common$MsgHead head = new common$MsgHead();
    public final PBUInt32Field err_type = PBField.initUInt32(0);
    public Oidb0xf62$TransSvrInfo trans_svr_info = new MessageMicro<Oidb0xf62$TransSvrInfo>() { // from class: tencent.im.group_pro_proto.oidb0xf62.Oidb0xf62$TransSvrInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField err_msg;
        public final PBBytesField trans_info;
        public final PBUInt32Field sub_type = PBField.initUInt32(0);
        public final PBInt32Field ret_code = PBField.initInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"sub_type", "ret_code", "err_msg", "trans_info"}, new Object[]{0, 0, byteStringMicro, byteStringMicro}, Oidb0xf62$TransSvrInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.err_msg = PBField.initBytes(byteStringMicro);
            this.trans_info = PBField.initBytes(byteStringMicro);
        }
    };
    public common$FreqLimitInfo freq_limit_info = new common$FreqLimitInfo();
}
