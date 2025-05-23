package qqcircle;

import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$BatchThankFansReq extends MessageMicro<QQCircleRankinglist$BatchThankFansReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"extInfo", PhotoCacheData.OWNER_UIN, WidgetCacheLunarData.WEEK, "fans_uin"}, new Object[]{null, "", 1, ""}, QQCircleRankinglist$BatchThankFansReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField owner_uin = PBField.initString("");
    public final PBEnumField week = PBField.initEnum(1);
    public final PBRepeatField<String> fans_uin = PBField.initRepeat(PBStringField.__repeatHelper__);
}
