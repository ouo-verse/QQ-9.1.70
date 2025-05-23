package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd extends MessageMicro<YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"game_rolo_hero_info", "hero_lane_type"}, new Object[]{null, 0}, YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd.class);
    public GameDataServerOuterClass$GameRoleHeroInfo game_rolo_hero_info = new GameDataServerOuterClass$GameRoleHeroInfo();
    public final PBInt32Field hero_lane_type = PBField.initInt32(0);
}
