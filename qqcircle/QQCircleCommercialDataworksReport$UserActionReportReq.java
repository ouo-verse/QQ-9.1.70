package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tenpay.sdk.util.QWSoterConstans;
import org.apache.commons.fileupload.FileUploadBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCommercialDataworksReport$UserActionReportReq extends MessageMicro<QQCircleCommercialDataworksReport$UserActionReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 90, 98, 104, 114}, new String[]{QWSoterConstans.CGI_KEY_BUSI_TYPE, "uid", WinkDaTongReportConstant.ElementParamKey.ADID, "adpos_type", "action_type", "action_time", "feeds_index", QAdVrReportParams.ParamKey.EXPERIMENT_ID, FileUploadBase.ATTACHMENT, "adpos_id", "trace_id", "qq_ver", "os_type", "app_id"}, new Object[]{0, "", "", 0, 0, 0L, 0, "", "", "", "", "", 0, ""}, QQCircleCommercialDataworksReport$UserActionReportReq.class);
    public final PBEnumField busi_type = PBField.initEnum(0);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField adid = PBField.initString("");
    public final PBEnumField adpos_type = PBField.initEnum(0);
    public final PBEnumField action_type = PBField.initEnum(0);
    public final PBInt64Field action_time = PBField.initInt64(0);
    public final PBUInt32Field feeds_index = PBField.initUInt32(0);
    public final PBRepeatField<String> experiment_id = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField attachment = PBField.initString("");
    public final PBStringField adpos_id = PBField.initString("");
    public final PBStringField trace_id = PBField.initString("");
    public final PBStringField qq_ver = PBField.initString("");
    public final PBUInt32Field os_type = PBField.initUInt32(0);
    public final PBStringField app_id = PBField.initString("");
}
