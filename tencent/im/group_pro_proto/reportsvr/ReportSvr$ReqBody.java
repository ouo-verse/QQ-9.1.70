package tencent.im.group_pro_proto.reportsvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReportSvr$ReqBody extends MessageMicro<ReportSvr$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{TVKDataBinder.KEY_REPORT_TYPE, "records"}, new Object[]{0, null}, ReportSvr$ReqBody.class);
    public final PBUInt32Field report_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<ReportSvr$Record> records = PBField.initRepeatMessage(ReportSvr$Record.class);
}
