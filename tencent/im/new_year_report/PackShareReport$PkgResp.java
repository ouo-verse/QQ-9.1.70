package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class PackShareReport$PkgResp extends MessageMicro<PackShareReport$PkgResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"head", "report_share"}, new Object[]{null, null}, PackShareReport$PkgResp.class);
    public PackShareReport$PkgHead head = new PackShareReport$PkgHead();
    public PackShareReport$ReportShareResp report_share = new MessageMicro<PackShareReport$ReportShareResp>() { // from class: tencent.im.new_year_report.PackShareReport$ReportShareResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80}, new String[]{"reserve"}, new Object[]{0}, PackShareReport$ReportShareResp.class);
        public final PBUInt32Field reserve = PBField.initUInt32(0);
    };
}
