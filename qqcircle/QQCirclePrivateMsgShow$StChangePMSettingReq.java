package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgShow$StChangePMSettingReq extends MessageMicro<QQCirclePrivateMsgShow$StChangePMSettingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "setting"}, new Object[]{null, null}, QQCirclePrivateMsgShow$StChangePMSettingReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public QQCirclePrivateMsgShow$StPMSettingData setting = new QQCirclePrivateMsgShow$StPMSettingData();
}
