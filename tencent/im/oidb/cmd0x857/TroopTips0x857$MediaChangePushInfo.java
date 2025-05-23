package tencent.im.oidb.cmd0x857;

import com.tencent.luggage.wxa.uf.l;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class TroopTips0x857$MediaChangePushInfo extends MessageMicro<TroopTips0x857$MediaChangePushInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_info;
    public final PBBytesField bytes_gray_tips;
    public final PBBytesField bytes_msg_info;
    public final PBBytesField bytes_version_ctrl;
    public final PBBoolField is_join_when_start;
    public PersonalSetting msg_per_setting;
    public final PBUInt32Field uint32_join_nums;
    public final PBUInt32Field uint32_media_type;
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_play_mode;
    public final PBUInt64Field uint64_group_id;
    public final PBUInt64Field uint64_msg_seq;
    public final PBUInt64Field uint64_oper_uin;

    /* loaded from: classes29.dex */
    public static final class PersonalSetting extends MessageMicro<PersonalSetting> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_theme_id", "uint32_player_id", "uint32_font_id"}, new Object[]{0, 0, 0}, PersonalSetting.class);
        public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_player_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_font_id = PBField.initUInt32(0);
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 56, 64, 74, 80, 88, l.CTRL_INDEX, 802}, new String[]{"uint32_msg_type", "bytes_msg_info", "bytes_version_ctrl", "uint64_group_id", "uint64_oper_uin", "bytes_gray_tips", "uint64_msg_seq", "uint32_join_nums", "msg_per_setting", "uint32_play_mode", "is_join_when_start", "uint32_media_type", "bytes_ext_info"}, new Object[]{0, byteStringMicro, byteStringMicro, 0L, 0L, byteStringMicro, 0L, 0, null, 0, Boolean.FALSE, 0, byteStringMicro}, TroopTips0x857$MediaChangePushInfo.class);
    }

    public TroopTips0x857$MediaChangePushInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_info = PBField.initBytes(byteStringMicro);
        this.bytes_version_ctrl = PBField.initBytes(byteStringMicro);
        this.uint64_group_id = PBField.initUInt64(0L);
        this.uint64_oper_uin = PBField.initUInt64(0L);
        this.bytes_gray_tips = PBField.initBytes(byteStringMicro);
        this.uint64_msg_seq = PBField.initUInt64(0L);
        this.uint32_join_nums = PBField.initUInt32(0);
        this.msg_per_setting = new PersonalSetting();
        this.uint32_play_mode = PBField.initUInt32(0);
        this.is_join_when_start = PBField.initBool(false);
        this.uint32_media_type = PBField.initUInt32(0);
        this.bytes_ext_info = PBField.initBytes(byteStringMicro);
    }
}
