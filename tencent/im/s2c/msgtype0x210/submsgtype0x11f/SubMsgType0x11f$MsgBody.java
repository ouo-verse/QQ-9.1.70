package tencent.im.s2c.msgtype0x210.submsgtype0x11f;

import com.tencent.luggage.wxa.uf.l;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x11f$MsgBody extends MessageMicro<SubMsgType0x11f$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_info;
    public final PBBytesField bytes_gray_tips;
    public final PBBytesField bytes_msg_info;
    public final PBBytesField bytes_version_ctrl;
    public SubMsgType0x11f$PersonalSetting msg_per_setting;
    public final PBRepeatMessageField<SubMsgType0x11f$MediaUserInfo> rpt_msg_media_uin;
    public final PBRepeatField<Long> rpt_uint64_to_uin;
    public final PBUInt32Field uint32_aio_type;
    public final PBUInt32Field uint32_media_type;
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_play_mode;
    public final PBUInt64Field uint64_msg_seq;
    public final PBUInt64Field uint64_oper_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58, 64, 74, 82, 88, l.CTRL_INDEX, 802}, new String[]{"uint32_msg_type", "bytes_msg_info", "bytes_version_ctrl", "uint32_aio_type", "uint64_oper_uin", "rpt_uint64_to_uin", "bytes_gray_tips", "uint64_msg_seq", "rpt_msg_media_uin", "msg_per_setting", "uint32_play_mode", "uint32_media_type", "bytes_ext_info"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0L, 0L, byteStringMicro, 0L, null, null, 0, 0, byteStringMicro}, SubMsgType0x11f$MsgBody.class);
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f$PersonalSetting] */
    public SubMsgType0x11f$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_info = PBField.initBytes(byteStringMicro);
        this.bytes_version_ctrl = PBField.initBytes(byteStringMicro);
        this.uint32_aio_type = PBField.initUInt32(0);
        this.uint64_oper_uin = PBField.initUInt64(0L);
        this.rpt_uint64_to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        this.bytes_gray_tips = PBField.initBytes(byteStringMicro);
        this.uint64_msg_seq = PBField.initUInt64(0L);
        this.rpt_msg_media_uin = PBField.initRepeatMessage(SubMsgType0x11f$MediaUserInfo.class);
        this.msg_per_setting = new MessageMicro<SubMsgType0x11f$PersonalSetting>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f$PersonalSetting
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_theme_id", "uint32_player_id", "uint32_font_id"}, new Object[]{0, 0, 0}, SubMsgType0x11f$PersonalSetting.class);
            public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_player_id = PBField.initUInt32(0);
            public final PBUInt32Field uint32_font_id = PBField.initUInt32(0);
        };
        this.uint32_play_mode = PBField.initUInt32(0);
        this.uint32_media_type = PBField.initUInt32(0);
        this.bytes_ext_info = PBField.initBytes(byteStringMicro);
    }
}
