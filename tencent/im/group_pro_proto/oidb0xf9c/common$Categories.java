package tencent.im.group_pro_proto.oidb0xf9c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$Categories extends MessageMicro<common$Categories> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"category"}, new Object[]{null}, common$Categories.class);
    public final PBRepeatMessageField<common$Category> category = PBField.initRepeatMessage(common$Category.class);
}
