package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class PubgDataOuterClass$PUBGTeamSettleData extends MessageMicro<PubgDataOuterClass$PUBGTeamSettleData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 800}, new String[]{"team_rank", "total_team", "players", "team_type"}, new Object[]{0, 0, null, 0}, PubgDataOuterClass$PUBGTeamSettleData.class);
    public final PBInt32Field team_rank = PBField.initInt32(0);
    public final PBInt32Field total_team = PBField.initInt32(0);
    public final PBRepeatMessageField<PubgDataOuterClass$PUBGPlayerSettleData> players = PBField.initRepeatMessage(PubgDataOuterClass$PUBGPlayerSettleData.class);
    public final PBInt32Field team_type = PBField.initInt32(0);
}
