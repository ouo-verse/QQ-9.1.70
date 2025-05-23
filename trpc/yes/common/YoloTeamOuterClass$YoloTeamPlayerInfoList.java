package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class YoloTeamOuterClass$YoloTeamPlayerInfoList extends MessageMicro<YoloTeamOuterClass$YoloTeamPlayerInfoList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"player_list"}, new Object[]{null}, YoloTeamOuterClass$YoloTeamPlayerInfoList.class);
    public final PBRepeatMessageField<YoloTeamOuterClass$YoloTeamPlayerInfo> player_list = PBField.initRepeatMessage(YoloTeamOuterClass$YoloTeamPlayerInfo.class);
}
