package trpc.yes.common;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* loaded from: classes30.dex */
public final class LivelinkServerOuterClass$GetKPLSchedulesReq extends MessageMicro<LivelinkServerOuterClass$GetKPLSchedulesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50}, new String[]{"season_id", QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time", "team_id", TtmlNode.TAG_REGION, "stage"}, new Object[]{"", 0L, 0L, "", "", ""}, LivelinkServerOuterClass$GetKPLSchedulesReq.class);
    public final PBStringField season_id = PBField.initString("");
    public final PBInt64Field begin_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
    public final PBStringField team_id = PBField.initString("");
    public final PBStringField region = PBField.initString("");
    public final PBStringField stage = PBField.initString("");
}
