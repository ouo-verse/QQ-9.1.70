package tencent.im.oidb.message_setting;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MessageSetting$GetMessageSettingReq extends MessageMicro<MessageSetting$GetMessageSettingReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field bot_uin = PBField.initUInt64(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBBoolField need_default = PBField.initBool(false);
    public final PBBoolField direct_message = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"bot_uin", "guild_id", "need_default", "direct_message"}, new Object[]{0L, 0L, bool, bool}, MessageSetting$GetMessageSettingReq.class);
    }
}
