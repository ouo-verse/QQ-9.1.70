package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class NearbyCommonOuterClass$YesGameRecommendTeam extends MessageMicro<NearbyCommonOuterClass$YesGameRecommendTeam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 58, 64, 72, 82}, new String[]{"id", "type", "name", "grade_desc", "grade_list", "lane_type_desc", "game_mode_name", "game_mode_type", "game_mode", "user_list"}, new Object[]{"", 0, "", "", 0, "", "", 0, 0, null}, NearbyCommonOuterClass$YesGameRecommendTeam.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f437244id = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField grade_desc = PBField.initString("");
    public final PBRepeatField<Integer> grade_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBStringField lane_type_desc = PBField.initString("");
    public final PBStringField game_mode_name = PBField.initString("");
    public final PBInt32Field game_mode_type = PBField.initInt32(0);
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public final PBRepeatMessageField<NearbyCommonOuterClass$YesGameRecommendTeamPos> user_list = PBField.initRepeatMessage(NearbyCommonOuterClass$YesGameRecommendTeamPos.class);
}
