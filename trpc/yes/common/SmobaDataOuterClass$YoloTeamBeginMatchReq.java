package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class SmobaDataOuterClass$YoloTeamBeginMatchReq extends MessageMicro<SmobaDataOuterClass$YoloTeamBeginMatchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"eventtime", "teamid", "battleinfo", "cyminiid"}, new Object[]{0, null, null, null}, SmobaDataOuterClass$YoloTeamBeginMatchReq.class);
    public final PBUInt32Field eventtime = PBField.initUInt32(0);
    public SmobaDataOuterClass$YoloTeamID teamid = new SmobaDataOuterClass$YoloTeamID();
    public SmobaDataOuterClass$YoloTeamBattleInfo battleinfo = new SmobaDataOuterClass$YoloTeamBattleInfo();
    public SmobaDataOuterClass$YoloCyminiID cyminiid = new SmobaDataOuterClass$YoloCyminiID();
}
