package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloTeamOuterClass$YoloTeamJoinBattleRsp extends MessageMicro<YoloTeamOuterClass$YoloTeamJoinBattleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"team_info", "ieg_real_name_result"}, new Object[]{null, null}, YoloTeamOuterClass$YoloTeamJoinBattleRsp.class);
    public YoloTeamOuterClass$YoloLiveTeamInfo team_info = new YoloTeamOuterClass$YoloLiveTeamInfo();
    public SafeOuterClass$SafeCheckResult ieg_real_name_result = new SafeOuterClass$SafeCheckResult();
}
