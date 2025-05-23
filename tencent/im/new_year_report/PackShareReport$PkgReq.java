package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes29.dex */
public final class PackShareReport$PkgReq extends MessageMicro<PackShareReport$PkgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"head", "report_share"}, new Object[]{null, null}, PackShareReport$PkgReq.class);
    public PackShareReport$PkgHead head = new PackShareReport$PkgHead();
    public PackShareReport$ReportShareReq report_share = new PackShareReport$ReportShareReq();
}
