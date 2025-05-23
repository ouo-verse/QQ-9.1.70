package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudMeta$StUser;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StUserInfo extends MessageMicro<QQCircleProfile$StUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26}, new String[]{QCircleAlphaUserReporter.KEY_USER, "infos"}, new Object[]{null, null}, QQCircleProfile$StUserInfo.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBRepeatMessageField<QQCircleProfile$StSingleInfo> infos = PBField.initRepeatMessage(QQCircleProfile$StSingleInfo.class);
}
