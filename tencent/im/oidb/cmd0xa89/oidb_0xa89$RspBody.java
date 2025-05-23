package tencent.im.oidb.cmd0xa89;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa89$RspBody extends MessageMicro<oidb_0xa89$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_error_info;
    public final PBBytesField bytes_poid;
    public final PBBytesField bytes_rsp_msg_body;
    public final PBUInt64Field uint64_msg_seq;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"bytes_poid", "bytes_msg_error_info", "uint64_msg_seq", "bytes_rsp_msg_body"}, new Object[]{byteStringMicro, byteStringMicro, 0L, byteStringMicro}, oidb_0xa89$RspBody.class);
    }

    public oidb_0xa89$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_poid = PBField.initBytes(byteStringMicro);
        this.bytes_msg_error_info = PBField.initBytes(byteStringMicro);
        this.uint64_msg_seq = PBField.initUInt64(0L);
        this.bytes_rsp_msg_body = PBField.initBytes(byteStringMicro);
    }
}
