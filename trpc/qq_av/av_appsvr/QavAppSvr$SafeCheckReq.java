package trpc.qq_av.av_appsvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QavAppSvr$SafeCheckReq extends MessageMicro<QavAppSvr$SafeCheckReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uin_list", "action", "need_first_warning", "auth_mode", "group_num"}, new Object[]{0L, 0, Boolean.FALSE, 0, 0L}, QavAppSvr$SafeCheckReq.class);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBEnumField action = PBField.initEnum(0);
    public final PBBoolField need_first_warning = PBField.initBool(false);
    public final PBEnumField auth_mode = PBField.initEnum(0);
    public final PBUInt64Field group_num = PBField.initUInt64(0);
}
