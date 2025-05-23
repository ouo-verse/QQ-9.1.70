package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class creatorReader {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CreatorAD extends MessageMicro<CreatorAD> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 56}, new String[]{"creative_id", "job_id", "qq_ad_get_rsp", "action_report_infos", "card_show_second", "highlight_second", "highlight_slide_second"}, new Object[]{"", 0L, null, null, 0, 0, 0}, CreatorAD.class);
        public final PBStringField creative_id = PBField.initString("");
        public final PBInt64Field job_id = PBField.initInt64(0);
        public final PBInt32Field card_show_second = PBField.initInt32(0);
        public final PBInt32Field highlight_second = PBField.initInt32(0);
        public final PBInt32Field highlight_slide_second = PBField.initInt32(0);
        public qq_ad_get.QQAdGetRsp qq_ad_get_rsp = new qq_ad_get.QQAdGetRsp();
        public UserActionReportInfo action_report_infos = new UserActionReportInfo();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class UserActionReportInfo extends MessageMicro<UserActionReportInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"adv_id", "trace_id", "exposure_url", "click_url"}, new Object[]{"", "", "", ""}, UserActionReportInfo.class);
        public final PBStringField adv_id = PBField.initString("");
        public final PBStringField trace_id = PBField.initString("");
        public final PBStringField exposure_url = PBField.initString("");
        public final PBStringField click_url = PBField.initString("");
    }

    creatorReader() {
    }
}
