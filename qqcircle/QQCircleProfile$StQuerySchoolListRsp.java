package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta$SchoolInfo;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StQuerySchoolListRsp extends MessageMicro<QQCircleProfile$StQuerySchoolListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"schoolInfo"}, new Object[]{null}, QQCircleProfile$StQuerySchoolListRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$SchoolInfo> schoolInfo = PBField.initRepeatMessage(FeedCloudMeta$SchoolInfo.class);
}
