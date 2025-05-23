package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_member_info$MemberGameInfo extends MessageMicro<group_member_info$MemberGameInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"str_game_name", "str_level_name", "str_level_icon", "str_game_font_color", "str_game_background_color", "str_game_url", "str_desc_info"}, new Object[]{"", "", "", "", "", "", ""}, group_member_info$MemberGameInfo.class);
    public final PBStringField str_game_name = PBField.initString("");
    public final PBStringField str_level_name = PBField.initString("");
    public final PBStringField str_level_icon = PBField.initString("");
    public final PBStringField str_game_font_color = PBField.initString("");
    public final PBStringField str_game_background_color = PBField.initString("");
    public final PBStringField str_game_url = PBField.initString("");
    public final PBRepeatField<String> str_desc_info = PBField.initRepeat(PBStringField.__repeatHelper__);
}
