package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaTeamChangeEvent extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaTeamChangeEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"change_type", "team_info"}, new Object[]{0, null}, YoloBattleSmobaOuterClass$YoloSmobaTeamChangeEvent.class);
    public final PBEnumField change_type = PBField.initEnum(0);
    public SmobaDataOuterClass$YoloTeamInfo team_info = new SmobaDataOuterClass$YoloTeamInfo();
}
