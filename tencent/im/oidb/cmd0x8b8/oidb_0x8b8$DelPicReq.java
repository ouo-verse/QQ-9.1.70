package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0x8b8$DelPicReq extends MessageMicro<oidb_0x8b8$DelPicReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_del_cnt", "rpt_uint32_del_list"}, new Object[]{0, 0}, oidb_0x8b8$DelPicReq.class);
    public final PBUInt32Field uint32_del_cnt = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_uint32_del_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
