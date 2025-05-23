package tencent.im.s2c.msgtype0x210.submsgtype0xa8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xa8$MsgBody extends MessageMicro<SubMsgType0xa8$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_extend_content;
    public final PBBytesField bytes_msg_summary;
    public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_action_subType = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_action_type", "uint32_action_subType", "bytes_msg_summary", "bytes_extend_content"}, new Object[]{0, 0, byteStringMicro, byteStringMicro}, SubMsgType0xa8$MsgBody.class);
    }

    public SubMsgType0xa8$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_summary = PBField.initBytes(byteStringMicro);
        this.bytes_extend_content = PBField.initBytes(byteStringMicro);
    }
}
