package tencent.im.oidb.cmd0xef5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xef5$ReqBody extends MessageMicro<oidb_cmd0xef5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"first_comment_id", "sub_comment_id", TVKDataBinder.KEY_REPORT_TYPE, "rowkey", VRReportDefine$ReportParam.REPORT_REASON}, new Object[]{"", "", 0, "", ""}, oidb_cmd0xef5$ReqBody.class);
    public final PBStringField first_comment_id = PBField.initString("");
    public final PBStringField sub_comment_id = PBField.initString("");
    public final PBUInt32Field report_type = PBField.initUInt32(0);
    public final PBStringField rowkey = PBField.initString("");
    public final PBStringField report_reason = PBField.initString("");
}
