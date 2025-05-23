package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x26$AppNotifyContent extends MessageMicro<submsgtype0x26$AppNotifyContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56}, new String[]{"bytes_text", "opt_msg_app_notify_user", "uint32_online_count", "uint32_expire_ts", "room_mode", "live_extra_mode", "game_id"}, new Object[]{ByteStringMicro.EMPTY, null, 0, 0, 0, 0, 0}, submsgtype0x26$AppNotifyContent.class);
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<submsgtype0x26$AppNotifyUser> opt_msg_app_notify_user = PBField.initRepeatMessage(submsgtype0x26$AppNotifyUser.class);
    public final PBUInt32Field uint32_online_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_ts = PBField.initUInt32(0);
    public final PBUInt32Field room_mode = PBField.initUInt32(0);
    public final PBUInt32Field live_extra_mode = PBField.initUInt32(0);
    public final PBUInt32Field game_id = PBField.initUInt32(0);
}
