package tencent.im.oidb.oidb_0xde8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xde8$NickInfo extends MessageMicro<oidb_0xde8$NickInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feedid;
    public final PBBytesField bytes_nick;
    public oidb_0xde8$lightCommentInfo msg_light_comment;
    public final PBRepeatMessageField<oidb_0xde8$CommentItem> rpt_item;
    public final PBUInt32Field uint32_create_time;
    public final PBUInt32Field uint32_del_time;
    public final PBUInt32Field uint32_mod_time;
    public final PBUInt32Field uint32_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58, 66}, new String[]{"bytes_feedid", "bytes_nick", "uint32_type", "uint32_create_time", "uint32_mod_time", "uint32_del_time", "rpt_item", "msg_light_comment"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0, 0, null, null}, oidb_0xde8$NickInfo.class);
    }

    public oidb_0xde8$NickInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_feedid = PBField.initBytes(byteStringMicro);
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_type = PBField.initUInt32(0);
        this.uint32_create_time = PBField.initUInt32(0);
        this.uint32_mod_time = PBField.initUInt32(0);
        this.uint32_del_time = PBField.initUInt32(0);
        this.rpt_item = PBField.initRepeatMessage(oidb_0xde8$CommentItem.class);
        this.msg_light_comment = new oidb_0xde8$lightCommentInfo();
    }
}
