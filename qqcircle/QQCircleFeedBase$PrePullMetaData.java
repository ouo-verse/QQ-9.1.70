package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$PrePullMetaData extends MessageMicro<QQCircleFeedBase$PrePullMetaData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField isOpenPrePull = PBField.initBool(false);
    public final PBBoolField isOpenPrePullAfter = PBField.initBool(false);
    public final PBRepeatMessageField<QQCircleFeedBase$PrePullSecondaryData> secondaryData = PBField.initRepeatMessage(QQCircleFeedBase$PrePullSecondaryData.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"isOpenPrePull", "isOpenPrePullAfter", "secondaryData", "extInfo"}, new Object[]{bool, bool, null, null}, QQCircleFeedBase$PrePullMetaData.class);
    }
}
