package tencent.im.oidb.cmd0x86f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import nearby_interact_state.interact_value$FreshThing;
import nearby_interact_state.interact_value$Tribe;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x86f$UserInteractState extends MessageMicro<oidb_0x86f$UserInteractState> {
    public static final int STATE_TYPE_AWARD_POST = 3;
    public static final int STATE_TYPE_FACE_SCORE_DOT_LIKE = 1001;
    public static final int STATE_TYPE_FACE_SCORE_INVITE_PIC = 1002;
    public static final int STATE_TYPE_FOLLOW = 9;
    public static final int STATE_TYPE_LIKE_COMMENT = 5;
    public static final int STATE_TYPE_LIKE_POST = 2;
    public static final int STATE_TYPE_NEARBY_LIKE_POST = 7;
    public static final int STATE_TYPE_NEARBY_REPLY_COMMENT = 8;
    public static final int STATE_TYPE_NEARBY_REPLY_POST = 6;
    public static final int STATE_TYPE_REPLY_COMMENT = 4;
    public static final int STATE_TYPE_REPLY_POST = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_heap_jump_url;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_jump_url;
    public final PBBytesField bytes_jump_url2;
    public final PBUInt32Field uint32_state_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public oidb_0x86f$UserInfo msg_userinfo = new MessageMicro<oidb_0x86f$UserInfo>() { // from class: tencent.im.oidb.cmd0x86f.oidb_0x86f$UserInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_head_url;
        public final PBBytesField bytes_label_type;
        public final PBBytesField bytes_nick_name;
        public final PBUInt32Field uint32_age;
        public final PBUInt32Field uint32_gender;
        public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 58}, new String[]{"uint64_tinyid", "uint64_uin", "bytes_nick_name", "bytes_head_url", "uint32_age", "uint32_gender", "bytes_label_type"}, new Object[]{0L, 0L, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro}, oidb_0x86f$UserInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_nick_name = PBField.initBytes(byteStringMicro);
            this.bytes_head_url = PBField.initBytes(byteStringMicro);
            this.uint32_age = PBField.initUInt32(0);
            this.uint32_gender = PBField.initUInt32(0);
            this.bytes_label_type = PBField.initBytes(byteStringMicro);
        }
    };
    public oidb_0x86f$Details msg_details = new MessageMicro<oidb_0x86f$Details>() { // from class: tencent.im.oidb.cmd0x86f.oidb_0x86f$Details
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_back_color2;
        public final PBBytesField bytes_back_color3;
        public oidb_0x86f$CommonDetails msg_common_details = new MessageMicro<oidb_0x86f$CommonDetails>() { // from class: tencent.im.oidb.cmd0x86f.oidb_0x86f$CommonDetails
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_content_txt2;
            public final PBBytesField bytes_content_txt3;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_content_txt2", "bytes_content_txt3"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_0x86f$CommonDetails.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_content_txt2 = PBField.initBytes(byteStringMicro);
                this.bytes_content_txt3 = PBField.initBytes(byteStringMicro);
            }
        };
        public interact_value$Tribe msg_tribe = new interact_value$Tribe();
        public interact_value$FreshThing msg_fresh_thing = new interact_value$FreshThing();

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"msg_common_details", "msg_tribe", "msg_fresh_thing", "bytes_back_color2", "bytes_back_color3"}, new Object[]{null, null, null, byteStringMicro, byteStringMicro}, oidb_0x86f$Details.class);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [tencent.im.oidb.cmd0x86f.oidb_0x86f$CommonDetails] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_back_color2 = PBField.initBytes(byteStringMicro);
            this.bytes_back_color3 = PBField.initBytes(byteStringMicro);
        }
    };

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 802}, new String[]{"uint32_state_type", "uint64_time", "uint64_seq", "msg_userinfo", "msg_details", "bytes_icon_url", "bytes_jump_url", "bytes_heap_jump_url", "bytes_jump_url2"}, new Object[]{0, 0L, 0L, null, null, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0x86f$UserInteractState.class);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [tencent.im.oidb.cmd0x86f.oidb_0x86f$UserInfo] */
    /* JADX WARN: Type inference failed for: r0v5, types: [tencent.im.oidb.cmd0x86f.oidb_0x86f$Details] */
    public oidb_0x86f$UserInteractState() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        this.bytes_jump_url = PBField.initBytes(byteStringMicro);
        this.bytes_heap_jump_url = PBField.initBytes(byteStringMicro);
        this.bytes_jump_url2 = PBField.initBytes(byteStringMicro);
    }
}
