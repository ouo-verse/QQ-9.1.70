package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$GuildInfo extends MessageMicro<QQCircleProfile$GuildInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"guildId", "icon", "name", "redirectText", "redirectUrl"}, new Object[]{0L, "", "", "", ""}, QQCircleProfile$GuildInfo.class);
    public final PBUInt64Field guildId = PBField.initUInt64(0);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField redirectText = PBField.initString("");
    public final PBStringField redirectUrl = PBField.initString("");
}
