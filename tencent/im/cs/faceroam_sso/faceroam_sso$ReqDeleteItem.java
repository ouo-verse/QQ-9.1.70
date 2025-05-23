package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class faceroam_sso$ReqDeleteItem extends MessageMicro<faceroam_sso$ReqDeleteItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"filename"}, new Object[]{""}, faceroam_sso$ReqDeleteItem.class);
    public final PBRepeatField<String> filename = PBField.initRepeat(PBStringField.__repeatHelper__);
}
