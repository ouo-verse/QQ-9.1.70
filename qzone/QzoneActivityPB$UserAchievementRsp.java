package qzone;

import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$UserAchievementRsp extends MessageMicro<QzoneActivityPB$UserAchievementRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"uin", "nick", "friend_assist", "catch_first", GetGuildJoinUrlServlet.BUNDLE_KEY_URL}, new Object[]{"", "", "", "", ""}, QzoneActivityPB$UserAchievementRsp.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField friend_assist = PBField.initString("");
    public final PBStringField catch_first = PBField.initString("");
    public final PBStringField share_url = PBField.initString("");
}
