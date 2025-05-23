package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MessageOuterClass$QQUserInfoMsg extends MessageMicro<MessageOuterClass$QQUserInfoMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 56}, new String[]{"qq_user_info", "show_scene", "user_id", "add_friend_tips_text", "game_id", "game_role_info", "version_type"}, new Object[]{null, 0, null, "", 0, null, 0}, MessageOuterClass$QQUserInfoMsg.class);
    public UserProxyCmdOuterClass$QQUserInfo qq_user_info = new UserProxyCmdOuterClass$QQUserInfo();
    public final PBInt32Field show_scene = PBField.initInt32(0);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBStringField add_friend_tips_text = PBField.initString("");
    public final PBInt32Field game_id = PBField.initInt32(0);
    public YesGameInfoOuterClass$YesGameRoleInfo game_role_info = new YesGameInfoOuterClass$YesGameRoleInfo();
    public final PBInt32Field version_type = PBField.initInt32(0);
}
