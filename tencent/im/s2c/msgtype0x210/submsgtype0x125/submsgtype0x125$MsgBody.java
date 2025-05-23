package tencent.im.s2c.msgtype0x210.submsgtype0x125;

import com.tencent.luggage.wxa.uf.l;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x125$MsgBody extends MessageMicro<submsgtype0x125$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_info;
    public final PBBytesField bytes_gray_tips;
    public final PBBytesField bytes_msg_info;
    public final PBBytesField bytes_version_ctrl;
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_push_type;
    public final PBUInt64Field uint64_msg_seq;
    public final PBUInt64Field uint64_oper_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, l.CTRL_INDEX, 802}, new String[]{"uint32_msg_type", "bytes_msg_info", "bytes_version_ctrl", "uint64_oper_uin", "bytes_gray_tips", "uint64_msg_seq", "uint32_push_type", "bytes_ext_info"}, new Object[]{0, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0L, 0, byteStringMicro}, submsgtype0x125$MsgBody.class);
    }

    public submsgtype0x125$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_info = PBField.initBytes(byteStringMicro);
        this.bytes_version_ctrl = PBField.initBytes(byteStringMicro);
        this.uint64_oper_uin = PBField.initUInt64(0L);
        this.bytes_gray_tips = PBField.initBytes(byteStringMicro);
        this.uint64_msg_seq = PBField.initUInt64(0L);
        this.uint32_push_type = PBField.initUInt32(0);
        this.bytes_ext_info = PBField.initBytes(byteStringMicro);
    }
}
