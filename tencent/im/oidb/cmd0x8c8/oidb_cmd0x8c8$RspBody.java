package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8c8$RspBody extends MessageMicro<oidb_cmd0x8c8$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint64_uin", "rpt_social_feeds_info", "rpt_del_feeds_id_list", "rpt_del_feeds_info_list"}, new Object[]{0L, null, 0L, null}, oidb_cmd0x8c8$RspBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_cmd0x8c8$FeedsInfo> rpt_social_feeds_info = PBField.initRepeatMessage(oidb_cmd0x8c8$FeedsInfo.class);
    public final PBRepeatField<Long> rpt_del_feeds_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<oidb_cmd0x8c8$FeedsInfo> rpt_del_feeds_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8$FeedsInfo.class);
}
