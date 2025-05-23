package qqcircle;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetOpenBoxUserRankingRsp extends MessageMicro<QQCircleRankinglist$GetOpenBoxUserRankingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"extInfo", "userRank", GuildMsgItem.NICK_FRIEND, "text", "rocketDiff", "textType"}, new Object[]{null, null, null, "", 0, 0}, QQCircleRankinglist$GetOpenBoxUserRankingRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public QQCircleRankinglist$TreasureRankItem userRank = new QQCircleRankinglist$TreasureRankItem();
    public FeedCloudMeta$StUser friend = new FeedCloudMeta$StUser();
    public final PBStringField text = PBField.initString("");
    public final PBInt32Field rocketDiff = PBField.initInt32(0);
    public final PBInt32Field textType = PBField.initInt32(0);
}
