package tencent.im.oidb.cmd0xaf6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xaf6$ReqBody extends MessageMicro<cmd0xaf6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_id", "get_member_num"}, new Object[]{0L, 0L}, cmd0xaf6$ReqBody.class);
    public final PBRepeatField<Long> group_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field get_member_num = PBField.initUInt64(0);
}
