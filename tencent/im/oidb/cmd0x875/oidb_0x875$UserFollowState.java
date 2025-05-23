package tencent.im.oidb.cmd0x875;

import appoint.define.appoint_define$RichText;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x875$UserFollowState extends MessageMicro<oidb_0x875$UserFollowState> {
    public static final int STATE_TYPE_CREATE_HOTCHAT = 13;
    public static final int STATE_TYPE_NEARBY_POST = 12;
    public static final int STATE_TYPE_NEW_POST = 11;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_from;
    public final PBBytesField bytes_jump_schema;
    public final PBBytesField bytes_op_txt;
    public final PBUInt64Field uint64_seq;
    public final PBUInt64Field uint64_time;
    public final PBUInt32Field uint32_state_type = PBField.initUInt32(0);
    public oidb_0x875$UserInfo msg_userinfo = new MessageMicro<oidb_0x875$UserInfo>() { // from class: tencent.im.oidb.cmd0x875.oidb_0x875$UserInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_head_url;
        public final PBBytesField bytes_nick_name;
        public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint64_tinyid", "uint64_uin", "bytes_nick_name", "bytes_head_url"}, new Object[]{0L, 0L, byteStringMicro, byteStringMicro}, oidb_0x875$UserInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_nick_name = PBField.initBytes(byteStringMicro);
            this.bytes_head_url = PBField.initBytes(byteStringMicro);
        }
    };
    public oidb_0x875$Details msg_details = new MessageMicro<oidb_0x875$Details>() { // from class: tencent.im.oidb.cmd0x875.oidb_0x875$Details
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_back_color;
        public final PBRepeatField<ByteStringMicro> bytes_pictures;
        public final PBBytesField bytes_text_body;
        public final PBBytesField bytes_title;
        public appoint_define$RichText rich_text_body;
        public final PBUInt32Field uint32_pictures_total;
        public final PBUInt32Field uint32_post_type;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 56}, new String[]{"bytes_title", "bytes_pictures", "uint32_pictures_total", "bytes_text_body", "rich_text_body", "bytes_back_color", "uint32_post_type"}, new Object[]{byteStringMicro, byteStringMicro, 0, byteStringMicro, null, byteStringMicro, 0}, oidb_0x875$Details.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_title = PBField.initBytes(byteStringMicro);
            this.bytes_pictures = PBField.initRepeat(PBBytesField.__repeatHelper__);
            this.uint32_pictures_total = PBField.initUInt32(0);
            this.bytes_text_body = PBField.initBytes(byteStringMicro);
            this.rich_text_body = new appoint_define$RichText();
            this.bytes_back_color = PBField.initBytes(byteStringMicro);
            this.uint32_post_type = PBField.initUInt32(0);
        }
    };

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 50, 56, 64, 74}, new String[]{"uint32_state_type", "msg_userinfo", "msg_details", "bytes_from", "bytes_jump_schema", "uint64_time", "uint64_seq", "bytes_op_txt"}, new Object[]{0, null, null, byteStringMicro, byteStringMicro, 0L, 0L, byteStringMicro}, oidb_0x875$UserFollowState.class);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [tencent.im.oidb.cmd0x875.oidb_0x875$UserInfo] */
    /* JADX WARN: Type inference failed for: r0v3, types: [tencent.im.oidb.cmd0x875.oidb_0x875$Details] */
    public oidb_0x875$UserFollowState() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_from = PBField.initBytes(byteStringMicro);
        this.bytes_jump_schema = PBField.initBytes(byteStringMicro);
        this.uint64_time = PBField.initUInt64(0L);
        this.uint64_seq = PBField.initUInt64(0L);
        this.bytes_op_txt = PBField.initBytes(byteStringMicro);
    }
}
