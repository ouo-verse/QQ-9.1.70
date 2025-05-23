package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fe$ReqBody extends MessageMicro<cmd0x3fe$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_msg_user_info", "uint64_group_code"}, new Object[]{null, 0L}, cmd0x3fe$ReqBody.class);
    public final PBRepeatMessageField<cmd0x3fe$UserInfo> rpt_msg_user_info = PBField.initRepeatMessage(cmd0x3fe$UserInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
}
