package trpc.yes.common;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes30.dex */
public final class YoloTeamOuterClass$YoloTeamPlayerInfo extends MessageMicro<YoloTeamOuterClass$YoloTeamPlayerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48}, new String[]{"user_id", "user_game_data", c.G, "show_info", "status", "camp_id"}, new Object[]{null, null, 0, null, 0, 0}, YoloTeamOuterClass$YoloTeamPlayerInfo.class);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public YoloRoomOuterClass$YoloUserGameData user_game_data = new YoloRoomOuterClass$YoloUserGameData();
    public final PBUInt32Field pos = PBField.initUInt32(0);
    public YoloTeamOuterClass$YoloTeamUserShowInfo show_info = new YoloTeamOuterClass$YoloTeamUserShowInfo();
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBInt32Field camp_id = PBField.initInt32(0);
}
