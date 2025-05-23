package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;

/* loaded from: classes30.dex */
public final class TVideoFloatPr$QqH5DisplayInfo extends MessageMicro<TVideoFloatPr$QqH5DisplayInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"url", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME}, new Object[]{"", 0}, TVideoFloatPr$QqH5DisplayInfo.class);
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field showTime = PBField.initInt32(0);
}
