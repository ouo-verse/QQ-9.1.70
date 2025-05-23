package tencent.im.oidb.reportFocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class ReportFocus$ChannelParam extends MessageMicro<ReportFocus$ChannelParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_guild_id", "rpt_uint64_channel_id"}, new Object[]{0L, 0L}, ReportFocus$ChannelParam.class);
    public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_channel_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
