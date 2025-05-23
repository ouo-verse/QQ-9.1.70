package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgShow$StGetPMSettingRsp extends MessageMicro<QQCirclePrivateMsgShow$StGetPMSettingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"extInfo", "setting", "fuelCostRange", "isProtection"}, new Object[]{null, null, null, Boolean.FALSE}, QQCirclePrivateMsgShow$StGetPMSettingRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public QQCirclePrivateMsgShow$StPMSettingData setting = new QQCirclePrivateMsgShow$StPMSettingData();
    public QQCirclePrivateMsgShow$StFuelCostRange fuelCostRange = new QQCirclePrivateMsgShow$StFuelCostRange();
    public final PBBoolField isProtection = PBField.initBool(false);
}
