package tencent.im.oidb.cmd0xf35;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf35$RspBody extends MessageMicro<oidb_cmd0xf35$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"block_user_rsp"}, new Object[]{null}, oidb_cmd0xf35$RspBody.class);
    public oidb_cmd0xf35$BlockUserRsp block_user_rsp = new MessageMicro<oidb_cmd0xf35$BlockUserRsp>() { // from class: tencent.im.oidb.cmd0xf35.oidb_cmd0xf35$BlockUserRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ret", "err_message", "over_times"}, new Object[]{0, "", 0}, oidb_cmd0xf35$BlockUserRsp.class);
        public final PBUInt32Field ret = PBField.initUInt32(0);
        public final PBStringField err_message = PBField.initString("");
        public final PBUInt32Field over_times = PBField.initUInt32(0);
    };
}
