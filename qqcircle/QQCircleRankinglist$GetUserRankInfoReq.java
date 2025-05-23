package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetUserRankInfoReq extends MessageMicro<QQCircleRankinglist$GetUserRankInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "uid", "tagList"}, new Object[]{null, "", ""}, QQCircleRankinglist$GetUserRankInfoReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField uid = PBField.initString("");
    public final PBRepeatField<String> tagList = PBField.initRepeat(PBStringField.__repeatHelper__);
}
