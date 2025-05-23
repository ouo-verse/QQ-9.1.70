package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$AnonymousGroupMsg extends MessageMicro<im_msg_body$AnonymousGroupMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField str_anon_id;
    public final PBBytesField str_anon_nick;
    public final PBBytesField str_rank_color;
    public final PBUInt32Field uint32_bubble_id;
    public final PBUInt32Field uint32_expire_time;
    public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
    public final PBUInt32Field uint32_head_portrait;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58}, new String[]{"uint32_flags", "str_anon_id", "str_anon_nick", "uint32_head_portrait", "uint32_expire_time", "uint32_bubble_id", "str_rank_color"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro}, im_msg_body$AnonymousGroupMsg.class);
    }

    public im_msg_body$AnonymousGroupMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_anon_id = PBField.initBytes(byteStringMicro);
        this.str_anon_nick = PBField.initBytes(byteStringMicro);
        this.uint32_head_portrait = PBField.initUInt32(0);
        this.uint32_expire_time = PBField.initUInt32(0);
        this.uint32_bubble_id = PBField.initUInt32(0);
        this.str_rank_color = PBField.initBytes(byteStringMicro);
    }
}
