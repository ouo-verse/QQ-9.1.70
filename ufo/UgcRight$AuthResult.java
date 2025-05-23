package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UgcRight$AuthResult extends MessageMicro<UgcRight$AuthResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"auth_result", "auth_finstep", "rightFlag"}, new Object[]{1, 1, 0L}, UgcRight$AuthResult.class);
    public final PBEnumField auth_result = PBField.initEnum(1);
    public final PBEnumField auth_finstep = PBField.initEnum(1);
    public final PBUInt64Field rightFlag = PBField.initUInt64(0);
}
