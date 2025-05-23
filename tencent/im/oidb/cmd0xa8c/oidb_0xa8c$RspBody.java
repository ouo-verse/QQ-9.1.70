package tencent.im.oidb.cmd0xa8c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa8c$RspBody extends MessageMicro<oidb_0xa8c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_error_info;
    public final PBBytesField bytes_poid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_poid", "bytes_msg_error_info"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_0xa8c$RspBody.class);
    }

    public oidb_0xa8c$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_poid = PBField.initBytes(byteStringMicro);
        this.bytes_msg_error_info = PBField.initBytes(byteStringMicro);
    }
}
