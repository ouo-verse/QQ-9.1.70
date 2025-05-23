package tencent.im.oidb.cmd0x46f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x46f$ReqBody extends MessageMicro<oidb_cmd0x46f$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint64_uin", "rpt_param_list"}, new Object[]{0L, null}, oidb_cmd0x46f$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_cmd0x46f$DislikeParam> rpt_param_list = PBField.initRepeatMessage(oidb_cmd0x46f$DislikeParam.class);
}
