package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class NearbyCommonOuterClass$YoloCommRoomData extends MessageMicro<NearbyCommonOuterClass$YoloCommRoomData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66}, new String[]{AudienceReportConst.ROOM_ID, "room_type", "room_icon", "room_title", "room_desc", "tag_list", "online_user_num_desc", "user_info_list"}, new Object[]{"", 0, "", "", "", null, "", null}, NearbyCommonOuterClass$YoloCommRoomData.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBInt32Field room_type = PBField.initInt32(0);
    public final PBStringField room_icon = PBField.initString("");
    public final PBStringField room_title = PBField.initString("");
    public final PBStringField room_desc = PBField.initString("");
    public final PBRepeatMessageField<NearbyCommonOuterClass$YoloCommRoomTag> tag_list = PBField.initRepeatMessage(NearbyCommonOuterClass$YoloCommRoomTag.class);
    public final PBStringField online_user_num_desc = PBField.initString("");
    public final PBRepeatMessageField<NearbyCommonOuterClass$YesGameRecommendTeamUser> user_info_list = PBField.initRepeatMessage(NearbyCommonOuterClass$YesGameRecommendTeamUser.class);
}
