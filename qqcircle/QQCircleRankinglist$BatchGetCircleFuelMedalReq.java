package qqcircle;

import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$BatchGetCircleFuelMedalReq extends MessageMicro<QQCircleRankinglist$BatchGetCircleFuelMedalReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", GameCenterAPIJavaScript.QUERY_INFO, "listTime"}, new Object[]{null, null, 0}, QQCircleRankinglist$BatchGetCircleFuelMedalReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleRankinglist$CircleFuelMedalQueryItem> queryInfo = PBField.initRepeatMessage(QQCircleRankinglist$CircleFuelMedalQueryItem.class);
    public final PBUInt32Field listTime = PBField.initUInt32(0);
}
