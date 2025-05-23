package tencent.im.new_year_report;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;

/* loaded from: classes29.dex */
public final class PackShareReport$ReportShareReq extends MessageMicro<PackShareReport$ReportShareReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"promotion_id", AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_CHANNEL, "swipe_count", "combo_count", "win_money_count", "win_goods_count", "share_error"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0}, PackShareReport$ReportShareReq.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBUInt32Field share_type = PBField.initUInt32(0);
    public final PBUInt32Field share_channel = PBField.initUInt32(0);
    public final PBUInt32Field swipe_count = PBField.initUInt32(0);
    public final PBUInt32Field combo_count = PBField.initUInt32(0);
    public final PBUInt32Field win_money_count = PBField.initUInt32(0);
    public final PBUInt32Field win_goods_count = PBField.initUInt32(0);
    public final PBUInt32Field share_error = PBField.initUInt32(0);
}
