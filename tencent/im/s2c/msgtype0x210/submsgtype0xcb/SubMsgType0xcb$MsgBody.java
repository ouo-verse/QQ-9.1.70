package tencent.im.s2c.msgtype0x210.submsgtype0xcb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xcb$MsgBody extends MessageMicro<SubMsgType0xcb$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_anchor_head_url;
    public final PBBytesField bytes_anchor_nickname;
    public final PBBytesField bytes_c2c_msg_wording;
    public final PBBytesField bytes_jump_schema;
    public final PBBytesField bytes_live_end_wording;
    public final PBBytesField bytes_live_wording;
    public final PBUInt32Field uint32_anchor_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_wording_type;
    public final PBUInt32Field uint32_live_wording_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 72}, new String[]{"uint32_anchor_status", "bytes_jump_schema", "bytes_anchor_nickname", "bytes_anchor_head_url", "bytes_live_wording", "bytes_live_end_wording", "bytes_c2c_msg_wording", "uint32_live_wording_type", "uint32_end_wording_type"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, SubMsgType0xcb$MsgBody.class);
    }

    public SubMsgType0xcb$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_jump_schema = PBField.initBytes(byteStringMicro);
        this.bytes_anchor_nickname = PBField.initBytes(byteStringMicro);
        this.bytes_anchor_head_url = PBField.initBytes(byteStringMicro);
        this.bytes_live_wording = PBField.initBytes(byteStringMicro);
        this.bytes_live_end_wording = PBField.initBytes(byteStringMicro);
        this.bytes_c2c_msg_wording = PBField.initBytes(byteStringMicro);
        this.uint32_live_wording_type = PBField.initUInt32(0);
        this.uint32_end_wording_type = PBField.initUInt32(0);
    }
}
