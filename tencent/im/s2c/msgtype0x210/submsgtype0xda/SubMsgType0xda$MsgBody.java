package tencent.im.s2c.msgtype0x210.submsgtype0xda;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xda$MsgBody extends MessageMicro<SubMsgType0xda$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover_url;
    public final PBBytesField bytes_doodle_url;
    public final PBBytesField bytes_ext_info;
    public final PBBytesField bytes_feed_id;
    public final PBBytesField bytes_from_nick;
    public final PBBytesField bytes_group_unionid;
    public final PBBytesField bytes_icon_union_id;
    public final PBBytesField bytes_msg_info;
    public final PBBytesField bytes_sub_type;
    public final PBBytesField bytes_union_id;
    public final PBBytesField bytes_version_ctrl;
    public final PBBytesField bytes_vid;
    public final PBBytesField bytes_vid_url;
    public final PBUInt32Field uint32_comment_id;
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_oper_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 66, 74, 80, 90, 98, 106, 114, 122, 130}, new String[]{"uint32_msg_type", "bytes_msg_info", "bytes_sub_type", "bytes_version_ctrl", "bytes_feed_id", "bytes_union_id", "uint32_comment_id", "bytes_icon_union_id", "bytes_cover_url", "uint32_oper_type", "bytes_group_unionid", "bytes_vid", "bytes_doodle_url", "bytes_from_nick", "bytes_vid_url", "bytes_ext_info"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, SubMsgType0xda$MsgBody.class);
    }

    public SubMsgType0xda$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_info = PBField.initBytes(byteStringMicro);
        this.bytes_sub_type = PBField.initBytes(byteStringMicro);
        this.bytes_version_ctrl = PBField.initBytes(byteStringMicro);
        this.bytes_feed_id = PBField.initBytes(byteStringMicro);
        this.bytes_union_id = PBField.initBytes(byteStringMicro);
        this.uint32_comment_id = PBField.initUInt32(0);
        this.bytes_icon_union_id = PBField.initBytes(byteStringMicro);
        this.bytes_cover_url = PBField.initBytes(byteStringMicro);
        this.uint32_oper_type = PBField.initUInt32(0);
        this.bytes_group_unionid = PBField.initBytes(byteStringMicro);
        this.bytes_vid = PBField.initBytes(byteStringMicro);
        this.bytes_doodle_url = PBField.initBytes(byteStringMicro);
        this.bytes_from_nick = PBField.initBytes(byteStringMicro);
        this.bytes_vid_url = PBField.initBytes(byteStringMicro);
        this.bytes_ext_info = PBField.initBytes(byteStringMicro);
    }
}
