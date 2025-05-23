package tencent.im.oidb.reportFocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReportFocus$ReqBody extends MessageMicro<ReportFocus$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48}, new String[]{"rpt_channel_param", "uint32_focus_channel_flag", "is_msg_tab_focus", "rpt_uint64_guild_lists", "rpt_uint64_channel_lists", "active_status"}, new Object[]{null, 0, 0, 0L, 0L, 0}, ReportFocus$ReqBody.class);
    public final PBUInt32Field active_status;
    public final PBRepeatField<Long> rpt_uint64_channel_lists;
    public final PBRepeatField<Long> rpt_uint64_guild_lists;
    public final PBRepeatMessageField<ReportFocus$ChannelParam> rpt_channel_param = PBField.initRepeatMessage(ReportFocus$ChannelParam.class);
    public final PBUInt32Field uint32_focus_channel_flag = PBField.initUInt32(0);
    public final PBUInt32Field is_msg_tab_focus = PBField.initUInt32(0);

    public ReportFocus$ReqBody() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.rpt_uint64_guild_lists = PBField.initRepeat(pBUInt64Field);
        this.rpt_uint64_channel_lists = PBField.initRepeat(pBUInt64Field);
        this.active_status = PBField.initUInt32(0);
    }
}
