package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8b8$ModifyOrderReq extends MessageMicro<oidb_0x8b8$ModifyOrderReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_pic_cnt", "rpt_uint32_pic_list"}, new Object[]{0, 0}, oidb_0x8b8$ModifyOrderReq.class);
    public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_uint32_pic_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
