package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$Entry;
import tianshu.QQCircleTianShu$RspEntry;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StBusiInfoData extends MessageMicro<QQCircleFeedBase$StBusiInfoData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 64, 74, 80, 90, 98, 106}, new String[]{"tabInfos", "busiMap", "allPolyInfo", "schoolInfos", "companyInfos", "defaultTabIndex", "rewardData", "goBackToSmallWorldWay", "rewardPolyInfo", "defaultTabSourceType", "publishAlienationButton", "publishToast", "gallerySubTabInfos"}, new Object[]{null, null, null, null, null, 0, null, 0, null, 0, null, null, null}, QQCircleFeedBase$StBusiInfoData.class);
    public final PBRepeatMessageField<QQCircleFeedBase$StTabInfo> tabInfos = PBField.initRepeatMessage(QQCircleFeedBase$StTabInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> busiMap = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatMessageField<QQCircleFeedBase$StPolyLike> allPolyInfo = PBField.initRepeatMessage(QQCircleFeedBase$StPolyLike.class);
    public final PBRepeatMessageField<QQCircleBase$UserCircleInfo> schoolInfos = PBField.initRepeatMessage(QQCircleBase$UserCircleInfo.class);
    public final PBRepeatMessageField<QQCircleBase$UserCircleInfo> companyInfos = PBField.initRepeatMessage(QQCircleBase$UserCircleInfo.class);
    public final PBUInt32Field defaultTabIndex = PBField.initUInt32(0);
    public QQCircleFeedBase$StRewardData rewardData = new QQCircleFeedBase$StRewardData();
    public final PBInt32Field goBackToSmallWorldWay = PBField.initInt32(0);
    public final PBRepeatMessageField<QQCircleFeedBase$StPolyLike> rewardPolyInfo = PBField.initRepeatMessage(QQCircleFeedBase$StPolyLike.class);
    public final PBInt32Field defaultTabSourceType = PBField.initInt32(0);
    public QQCircleTianShu$RspEntry publishAlienationButton = new QQCircleTianShu$RspEntry();
    public QQCircleTianShu$RspEntry publishToast = new QQCircleTianShu$RspEntry();
    public final PBRepeatMessageField<QQCircleFeedBase$StSubTabInfo> gallerySubTabInfos = PBField.initRepeatMessage(QQCircleFeedBase$StSubTabInfo.class);
}
