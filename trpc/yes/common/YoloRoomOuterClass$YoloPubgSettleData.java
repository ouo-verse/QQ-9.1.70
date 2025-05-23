package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloPubgSettleData extends MessageMicro<YoloRoomOuterClass$YoloPubgSettleData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"pubg_player_settle_data", "pubg_team_settle_data"}, new Object[]{null, null}, YoloRoomOuterClass$YoloPubgSettleData.class);
    public PubgDataOuterClass$PUBGPlayerSettleData pubg_player_settle_data = new PubgDataOuterClass$PUBGPlayerSettleData();
    public PubgDataOuterClass$PUBGTeamSettleData pubg_team_settle_data = new PubgDataOuterClass$PUBGTeamSettleData();
}
