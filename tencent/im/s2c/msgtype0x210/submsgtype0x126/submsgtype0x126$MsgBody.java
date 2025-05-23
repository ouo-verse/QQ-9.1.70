package tencent.im.s2c.msgtype0x210.submsgtype0x126;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x126$MsgBody extends MessageMicro<submsgtype0x126$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_info;
    public final PBBytesField str_msg_info;
    public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 802}, new String[]{"uint64_msg_seq", "uint32_msg_type", "str_msg_info", "bytes_ext_info"}, new Object[]{0L, 0, byteStringMicro, byteStringMicro}, submsgtype0x126$MsgBody.class);
    }

    public submsgtype0x126$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_msg_info = PBField.initBytes(byteStringMicro);
        this.bytes_ext_info = PBField.initBytes(byteStringMicro);
    }
}
