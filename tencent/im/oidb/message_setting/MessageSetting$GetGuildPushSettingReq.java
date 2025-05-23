package tencent.im.oidb.message_setting;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class MessageSetting$GetGuildPushSettingReq extends MessageMicro<MessageSetting$GetGuildPushSettingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"bot_tiny_id", "guild_id"}, new Object[]{0L, 0L}, MessageSetting$GetGuildPushSettingReq.class);
    public final PBUInt64Field bot_tiny_id = PBField.initUInt64(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
}
