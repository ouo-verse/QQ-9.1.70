package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$RichMsg extends MessageMicro<im_msg_body$RichMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_resid;
    public final PBBytesField bytes_template_1;
    public final PBUInt32Field uint32_flags;
    public final PBUInt32Field uint32_rand;
    public final PBUInt32Field uint32_seq;
    public final PBUInt32Field uint32_service_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48}, new String[]{"bytes_template_1", "uint32_service_id", "bytes_msg_resid", "uint32_rand", "uint32_seq", "uint32_flags"}, new Object[]{byteStringMicro, 0, byteStringMicro, 0, 0, 0}, im_msg_body$RichMsg.class);
    }

    public im_msg_body$RichMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_template_1 = PBField.initBytes(byteStringMicro);
        this.uint32_service_id = PBField.initUInt32(0);
        this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
        this.uint32_rand = PBField.initUInt32(0);
        this.uint32_seq = PBField.initUInt32(0);
        this.uint32_flags = PBField.initUInt32(0);
    }
}
