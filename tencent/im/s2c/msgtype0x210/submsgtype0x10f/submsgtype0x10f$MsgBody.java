package tencent.im.s2c.msgtype0x210.submsgtype0x10f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x10f$MsgBody extends MessageMicro<submsgtype0x10f$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48}, new String[]{"uint32_is_open_coin_entry", "uint32_can_get_coin_count", "bytes_coin_icon_url", "msg_setting_wording", "uint64_last_completed_task_stamp", "uint64_dst_uin"}, new Object[]{0, 0, ByteStringMicro.EMPTY, null, 0L, 0L}, submsgtype0x10f$MsgBody.class);
    public final PBUInt32Field uint32_is_open_coin_entry = PBField.initUInt32(0);
    public final PBUInt32Field uint32_can_get_coin_count = PBField.initUInt32(0);
    public final PBBytesField bytes_coin_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public submsgtype0x10f$KanDianCoinSettingWording msg_setting_wording = new MessageMicro<submsgtype0x10f$KanDianCoinSettingWording>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x10f.submsgtype0x10f$KanDianCoinSettingWording
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_picture_url;
        public final PBBytesField bytes_wording;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_wording", "bytes_picture_url"}, new Object[]{byteStringMicro, byteStringMicro}, submsgtype0x10f$KanDianCoinSettingWording.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_wording = PBField.initBytes(byteStringMicro);
            this.bytes_picture_url = PBField.initBytes(byteStringMicro);
        }
    };
    public final PBUInt64Field uint64_last_completed_task_stamp = PBField.initUInt64(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
}
