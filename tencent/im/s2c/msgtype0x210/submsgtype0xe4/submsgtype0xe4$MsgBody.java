package tencent.im.s2c.msgtype0x210.submsgtype0xe4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xe4$MsgBody extends MessageMicro<submsgtype0xe4$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_display_distance;
    public final PBBytesField bytes_key;
    public submsgtype0xe4$GiftMsg msg_gift;
    public submsgtype0xe4$LikeMsg msg_like;
    public submsgtype0xe4$Room msg_room;
    public final PBUInt32Field uint32_call_type;
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public submsgtype0xe4$Player msg_match_player = new MessageMicro<submsgtype0xe4$Player>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4$Player
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_logo_url;
        public final PBBytesField bytes_nickname;
        public final PBUInt32Field uint32_age;
        public final PBUInt32Field uint32_gender;
        public final PBUInt32Field uint32_level;
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48}, new String[]{"uint64_uin", "bytes_nickname", "bytes_logo_url", "uint32_gender", "uint32_level", "uint32_age"}, new Object[]{0L, byteStringMicro, byteStringMicro, 0, 0, 0}, submsgtype0xe4$Player.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_nickname = PBField.initBytes(byteStringMicro);
            this.bytes_logo_url = PBField.initBytes(byteStringMicro);
            this.uint32_gender = PBField.initUInt32(0);
            this.uint32_level = PBField.initUInt32(0);
            this.uint32_age = PBField.initUInt32(0);
        }
    };
    public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
    public final PBStringField str_hint = PBField.initString("");
    public final PBUInt32Field uint32_countdown = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 48, 56, 66, 74, 82, 90}, new String[]{"msg_match_player", "uint32_distance", "str_hint", "uint32_countdown", "bytes_key", "uint32_type", "uint32_call_type", "bytes_display_distance", "msg_like", "msg_gift", "msg_room"}, new Object[]{null, 0, "", 0, byteStringMicro, 0, 0, byteStringMicro, null, null, null}, submsgtype0xe4$MsgBody.class);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4$LikeMsg] */
    /* JADX WARN: Type inference failed for: r0v4, types: [tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4$GiftMsg] */
    /* JADX WARN: Type inference failed for: r0v5, types: [tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4$Room] */
    /* JADX WARN: Type inference failed for: r1v1, types: [tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4$Player] */
    public submsgtype0xe4$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_key = PBField.initBytes(byteStringMicro);
        this.uint32_call_type = PBField.initUInt32(0);
        this.bytes_display_distance = PBField.initBytes(byteStringMicro);
        this.msg_like = new MessageMicro<submsgtype0xe4$LikeMsg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4$LikeMsg
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_from_uin", "uint64_to_uin"}, new Object[]{0L, 0L}, submsgtype0xe4$LikeMsg.class);
            public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
            public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        };
        this.msg_gift = new MessageMicro<submsgtype0xe4$GiftMsg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4$GiftMsg
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField gift_wording;
            public final PBBytesField packageurl;
            public final PBUInt32Field uint32_all_add_duration;
            public final PBUInt32Field uint32_cur_add_duration;
            public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
            public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_gift_id = PBField.initUInt32(0);
            public final PBUInt64Field uint64_gift_num = PBField.initUInt64(0);
            public final PBStringField str_roomid = PBField.initString("");

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66, 400, 408}, new String[]{"uint64_from_uin", "uint64_to_uin", "uint32_product_id", "uint32_gift_id", "uint64_gift_num", "str_roomid", "gift_wording", "packageurl", "uint32_cur_add_duration", "uint32_all_add_duration"}, new Object[]{0L, 0L, 0, 0, 0L, "", byteStringMicro2, byteStringMicro2, 0, 0}, submsgtype0xe4$GiftMsg.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.gift_wording = PBField.initBytes(byteStringMicro2);
                this.packageurl = PBField.initBytes(byteStringMicro2);
                this.uint32_cur_add_duration = PBField.initUInt32(0);
                this.uint32_all_add_duration = PBField.initUInt32(0);
            }
        };
        this.msg_room = new MessageMicro<submsgtype0xe4$Room>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xe4.submsgtype0xe4$Room
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_room_id"}, new Object[]{""}, submsgtype0xe4$Room.class);
            public final PBStringField str_room_id = PBField.initString("");
        };
    }
}
