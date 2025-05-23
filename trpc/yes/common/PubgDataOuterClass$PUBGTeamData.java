package trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class PubgDataOuterClass$PUBGTeamData extends MessageMicro<PubgDataOuterClass$PUBGTeamData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 74, 82}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "team_size", "team_type", "appid", "team_bus_id", "team_id", "type", "sub_mode_view_id", "team_mate", "leader_role_id"}, new Object[]{0, 0, 0, "", "", "", "", 0, null, ""}, PubgDataOuterClass$PUBGTeamData.class);
    public final PBInt32Field area = PBField.initInt32(0);
    public final PBInt32Field team_size = PBField.initInt32(0);
    public final PBInt32Field team_type = PBField.initInt32(0);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField team_bus_id = PBField.initString("");
    public final PBStringField team_id = PBField.initString("");
    public final PBStringField type = PBField.initString("");
    public final PBRepeatField<Integer> sub_mode_view_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<PubgDataOuterClass$PUBGTeamMate> team_mate = PBField.initRepeatMessage(PubgDataOuterClass$PUBGTeamMate.class);
    public final PBStringField leader_role_id = PBField.initString("");
}
