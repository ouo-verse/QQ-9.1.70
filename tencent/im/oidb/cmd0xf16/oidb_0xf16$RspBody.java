package tencent.im.oidb.cmd0xf16;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf16$RspBody extends MessageMicro<oidb_0xf16$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_remark_info_rsp"}, new Object[]{null}, oidb_0xf16$RspBody.class);
    public oidb_0xf16$GroupRemarkInfoRsp msg_remark_info_rsp = new MessageMicro<oidb_0xf16$GroupRemarkInfoRsp>() { // from class: tencent.im.oidb.cmd0xf16.oidb_0xf16$GroupRemarkInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_group_code", "uint64_group_uin", "int32_result"}, new Object[]{0L, 0L, 0}, oidb_0xf16$GroupRemarkInfoRsp.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
        public final PBInt32Field int32_result = PBField.initInt32(0);
    };
}
