package trpc.yes.common;

import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloSmobaUserGameData extends MessageMicro<YoloRoomOuterClass$YoloSmobaUserGameData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 96, 104, 122, 808}, new String[]{"role_id", "role_abs_info", "game_rolo_hero_info", "hero_lane_type", "game_status", "update_status", "update_process", MsfConstants.ATTRIBUTE_LOGIN_TYPE, "phone_system", "role_info", "last_notify_time"}, new Object[]{null, null, null, 0, 0, 0, 0, 0, 0, null, 0}, YoloRoomOuterClass$YoloSmobaUserGameData.class);
    public GameDataServerOuterClass$GameRoleId role_id = new GameDataServerOuterClass$GameRoleId();
    public GameDataServerOuterClass$GameRoleAbsInfo role_abs_info = new GameDataServerOuterClass$GameRoleAbsInfo();
    public GameDataServerOuterClass$GameRoleHeroInfo game_rolo_hero_info = new GameDataServerOuterClass$GameRoleHeroInfo();
    public final PBInt32Field hero_lane_type = PBField.initInt32(0);
    public final PBInt32Field game_status = PBField.initInt32(0);
    public final PBInt32Field update_status = PBField.initInt32(0);
    public final PBInt32Field update_process = PBField.initInt32(0);
    public final PBInt32Field login_type = PBField.initInt32(0);
    public final PBInt32Field phone_system = PBField.initInt32(0);
    public GameDataServerOuterClass$GameRoleInfo role_info = new GameDataServerOuterClass$GameRoleInfo();
    public final PBUInt32Field last_notify_time = PBField.initUInt32(0);
}
