package tencent.im.oidb.cmd0x829;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x829$AddFrdInfo extends MessageMicro<oidb_0x829$AddFrdInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mobile;
    public final PBBytesField bytes_remark;
    public final PBUInt32Field uint32_allow_type;
    public final PBUInt32Field uint32_send_req_flag;
    public final PBUInt32Field uint32_send_result;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"bytes_mobile", "uint32_allow_type", "bytes_remark", "uint32_send_req_flag", "uint32_send_result"}, new Object[]{byteStringMicro, 0, byteStringMicro, 0, 0}, oidb_0x829$AddFrdInfo.class);
    }

    public oidb_0x829$AddFrdInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_mobile = PBField.initBytes(byteStringMicro);
        this.uint32_allow_type = PBField.initUInt32(0);
        this.bytes_remark = PBField.initBytes(byteStringMicro);
        this.uint32_send_req_flag = PBField.initUInt32(0);
        this.uint32_send_result = PBField.initUInt32(0);
    }
}
