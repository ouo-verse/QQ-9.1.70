package tencent.im.oidb.cmd0xf16;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf16$ReqBody extends MessageMicro<oidb_0xf16$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_remark_info_req"}, new Object[]{null}, oidb_0xf16$ReqBody.class);
    public oidb_0xf16$GroupRemarkInfoReq msg_remark_info_req = new MessageMicro<oidb_0xf16$GroupRemarkInfoReq>() { // from class: tencent.im.oidb.cmd0xf16.oidb_0xf16$GroupRemarkInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_group_code", "uint64_group_uin", "bytes_remark_name"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY}, oidb_0xf16$GroupRemarkInfoReq.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
        public final PBBytesField bytes_remark_name = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
