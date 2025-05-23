package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf4d$RspBody extends MessageMicro<oidb_0xf4d$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 802}, new String[]{"ret", "err_message", "pull_interval", "is_forbid", "extra_info", "danmu_detail_list"}, new Object[]{0, "", 0, 0, null, null}, oidb_0xf4d$RspBody.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBStringField err_message = PBField.initString("");
    public final PBUInt32Field pull_interval = PBField.initUInt32(0);
    public final PBUInt32Field is_forbid = PBField.initUInt32(0);
    public oidb_0xf4d$ExtraInfo extra_info = new MessageMicro<oidb_0xf4d$ExtraInfo>() { // from class: tencent.im.oidb.cmd0xf4d.oidb_0xf4d$ExtraInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "danmu_summary_info"}, new Object[]{null, null}, oidb_0xf4d$ExtraInfo.class);
        public final PBRepeatMessageField<oidb_0xf4d$ReportInfo> report_info = PBField.initRepeatMessage(oidb_0xf4d$ReportInfo.class);
        public oidb_0xf4d$DanmuSummaryInfo danmu_summary_info = new MessageMicro<oidb_0xf4d$DanmuSummaryInfo>() { // from class: tencent.im.oidb.cmd0xf4d.oidb_0xf4d$DanmuSummaryInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"danmu_total_nums", "danmu_cookie", "open_text"}, new Object[]{0L, ByteStringMicro.EMPTY, ""}, oidb_0xf4d$DanmuSummaryInfo.class);
            public final PBUInt64Field danmu_total_nums = PBField.initUInt64(0);
            public final PBBytesField danmu_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBStringField open_text = PBField.initString("");
        };
    };
    public final PBRepeatMessageField<oidb_0xf4d$DanmuDetail> danmu_detail_list = PBField.initRepeatMessage(oidb_0xf4d$DanmuDetail.class);
}
