package tencent.im.group_pro_proto.cmd0x101b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class cmd0x101b$GameParam extends MessageMicro<cmd0x101b$GameParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"team_id", "game_id", "jump_action", "team_guild_id", "team_channel_id"}, new Object[]{"", "", "", "", ""}, cmd0x101b$GameParam.class);
    public final PBStringField team_id = PBField.initString("");
    public final PBStringField game_id = PBField.initString("");
    public final PBStringField jump_action = PBField.initString("");
    public final PBStringField team_guild_id = PBField.initString("");
    public final PBStringField team_channel_id = PBField.initString("");
}
