package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetCreatorRankingRsp extends MessageMicro<QQCircleRankinglist$GetCreatorRankingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"extInfo", "items", "listTimes", "subscribed"}, new Object[]{null, null, "", Boolean.FALSE}, QQCircleRankinglist$GetCreatorRankingRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleRankinglist$CreatorRankItem> items = PBField.initRepeatMessage(QQCircleRankinglist$CreatorRankItem.class);
    public final PBRepeatField<String> listTimes = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBoolField subscribed = PBField.initBool(false);
}
