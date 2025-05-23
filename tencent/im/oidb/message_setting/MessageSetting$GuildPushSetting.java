package tencent.im.oidb.message_setting;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class MessageSetting$GuildPushSetting extends MessageMicro<MessageSetting$GuildPushSetting> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField bot_name = PBField.initString("");
    public final PBBoolField disable_create_dm = PBField.initBool(false);
    public final PBBoolField disable_push_msg = PBField.initBool(false);
    public final PBRepeatField<Long> channel_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field max_push_num = PBField.initUInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 32, 40, 48}, new String[]{"bot_name", "disable_create_dm", "disable_push_msg", "channel_ids", "max_push_num"}, new Object[]{"", bool, bool, 0L, 0}, MessageSetting$GuildPushSetting.class);
    }
}
