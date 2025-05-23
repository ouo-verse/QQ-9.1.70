package trpc.yes.common;

import com.tencent.mobileqq.mini.servlet.GameHallAuthServerlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$QQUserInfo extends MessageMicro<UserProxyCmdOuterClass$QQUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 64, 74, 80}, new String[]{"uid", "mini_info", "game_openid", GameHallAuthServerlet.AUTH_STATUS, "defaul_smoba_role", "user_room_list", "group_pro_info", "friend_switch", "nearby_user_info", "yes_uid"}, new Object[]{0L, null, null, 0, null, null, null, 0, null, 0L}, UserProxyCmdOuterClass$QQUserInfo.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public UserProxyCmdOuterClass$MiniInfo mini_info = new UserProxyCmdOuterClass$MiniInfo();
    public UserProxyCmdOuterClass$QQGroupProInfo group_pro_info = new UserProxyCmdOuterClass$QQGroupProInfo();
    public UserProxyCmdOuterClass$UserGameOpenid game_openid = new UserProxyCmdOuterClass$UserGameOpenid();
    public final PBInt32Field auth_status = PBField.initInt32(0);
    public GameRoleOuterClass$SmobaGameRoleInfo defaul_smoba_role = new GameRoleOuterClass$SmobaGameRoleInfo();
    public UserProxyCmdOuterClass$UserRoomList user_room_list = new MessageMicro<UserProxyCmdOuterClass$UserRoomList>() { // from class: trpc.yes.common.UserProxyCmdOuterClass$UserRoomList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_room_list"}, new Object[]{null}, UserProxyCmdOuterClass$UserRoomList.class);
        public final PBRepeatMessageField<UserProxyCmdOuterClass$UserRoom> user_room_list = PBField.initRepeatMessage(UserProxyCmdOuterClass$UserRoom.class);
    };
    public final PBInt32Field friend_switch = PBField.initInt32(0);
    public UserProxyCmdOuterClass$QQNearbyUserInfo nearby_user_info = new UserProxyCmdOuterClass$QQNearbyUserInfo();
    public final PBUInt64Field yes_uid = PBField.initUInt64(0);
}
