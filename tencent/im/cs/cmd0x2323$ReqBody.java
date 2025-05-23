package tencent.im.cs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x2323$ReqBody extends MessageMicro<cmd0x2323$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_code_list"}, new Object[]{0L}, cmd0x2323$ReqBody.class);
    public final PBRepeatField<Long> group_code_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
