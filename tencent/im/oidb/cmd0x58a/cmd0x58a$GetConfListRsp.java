package tencent.im.oidb.cmd0x58a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x58a$GetConfListRsp extends MessageMicro<cmd0x58a$GetConfListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_msg_conf_base_info", "rpt_uint64_other_conf_list"}, new Object[]{null, 0L}, cmd0x58a$GetConfListRsp.class);
    public final PBRepeatMessageField<cmd0x58a$ConfBaseInfo> rpt_msg_conf_base_info = PBField.initRepeatMessage(cmd0x58a$ConfBaseInfo.class);
    public final PBRepeatField<Long> rpt_uint64_other_conf_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
