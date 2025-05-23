package tencent.im.oidb.cmd0xbbb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.channel_button.channel_button$Channel;
import tencent.im.oidb.channel_button.channel_button$Section;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbbb$RspBody extends MessageMicro<oidb_cmd0xbbb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"rpt_me_channel", "rpt_recomm_channel", "uint64_next_req_time", "rpt_msg_section", "uint32_gray_flag"}, new Object[]{null, null, 0L, null, 0}, oidb_cmd0xbbb$RspBody.class);
    public final PBRepeatMessageField<channel_button$Channel> rpt_me_channel = PBField.initRepeatMessage(channel_button$Channel.class);
    public final PBRepeatMessageField<channel_button$Channel> rpt_recomm_channel = PBField.initRepeatMessage(channel_button$Channel.class);
    public final PBUInt64Field uint64_next_req_time = PBField.initUInt64(0);
    public final PBRepeatMessageField<channel_button$Section> rpt_msg_section = PBField.initRepeatMessage(channel_button$Section.class);
    public final PBUInt32Field uint32_gray_flag = PBField.initUInt32(0);
}
