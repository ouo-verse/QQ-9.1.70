package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgShow$StChangePMSettingRsp extends MessageMicro<QQCirclePrivateMsgShow$StChangePMSettingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"extInfo", "errCode", "errMsg", "setting", "fuelCostRange"}, new Object[]{null, 0, "", null, null}, QQCirclePrivateMsgShow$StChangePMSettingRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field errCode = PBField.initInt32(0);
    public final PBStringField errMsg = PBField.initString("");
    public QQCirclePrivateMsgShow$StPMSettingData setting = new QQCirclePrivateMsgShow$StPMSettingData();
    public QQCirclePrivateMsgShow$StFuelCostRange fuelCostRange = new QQCirclePrivateMsgShow$StFuelCostRange();
}
