package tencent.im.oidb.message_setting;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class MessageSetting$SetGuildPushSettingReq extends MessageMicro<MessageSetting$SetGuildPushSettingReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field bot_tiny_id = PBField.initUInt64(0);
    public final PBBoolField disable_create_dm = PBField.initBool(false);
    public final PBBoolField disable_push_msg = PBField.initBool(false);
    public final PBRepeatField<Long> channel_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field max_push_num = PBField.initUInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"guild_id", "bot_tiny_id", "disable_create_dm", "disable_push_msg", "channel_ids", "max_push_num"}, new Object[]{0L, 0L, bool, bool, 0L, 0}, MessageSetting$SetGuildPushSettingReq.class);
    }
}
