package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloSmobaRunTimeBattleData extends MessageMicro<YoloRoomOuterClass$YoloSmobaRunTimeBattleData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"total_kill_count", "total_dead_count", "member_battle_info"}, new Object[]{0, 0, null}, YoloRoomOuterClass$YoloSmobaRunTimeBattleData.class);
    public final PBInt32Field total_kill_count = PBField.initInt32(0);
    public final PBInt32Field total_dead_count = PBField.initInt32(0);
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloSmobaRuntimeMemberBattleInfo> member_battle_info = PBField.initRepeatMessage(YoloRoomOuterClass$YoloSmobaRuntimeMemberBattleInfo.class);
}
