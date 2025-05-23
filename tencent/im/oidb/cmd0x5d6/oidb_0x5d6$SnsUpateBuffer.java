package tencent.im.oidb.cmd0x5d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5d6$SnsUpateBuffer extends MessageMicro<oidb_0x5d6$SnsUpateBuffer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 3202, 3208}, new String[]{"uint64_uin", "rpt_msg_sns_update_item", "rpt_uin32_idlist"}, new Object[]{0L, null, 0}, oidb_0x5d6$SnsUpateBuffer.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0x5d6$SnsUpdateItem> rpt_msg_sns_update_item = PBField.initRepeatMessage(oidb_0x5d6$SnsUpdateItem.class);
    public final PBRepeatField<Integer> rpt_uin32_idlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
