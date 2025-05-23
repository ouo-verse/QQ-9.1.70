package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class faceroam_sso$RspDeleteItem extends MessageMicro<faceroam_sso$RspDeleteItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"filename", "ret"}, new Object[]{"", 0L}, faceroam_sso$RspDeleteItem.class);
    public final PBRepeatField<String> filename = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<Long> ret = PBField.initRepeat(PBInt64Field.__repeatHelper__);
}
