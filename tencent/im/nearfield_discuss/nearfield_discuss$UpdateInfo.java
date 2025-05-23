package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_discuss$UpdateInfo extends MessageMicro<nearfield_discuss$UpdateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "msg_user"}, new Object[]{1, null}, nearfield_discuss$UpdateInfo.class);
    public final PBEnumField type = PBField.initEnum(1);
    public nearfield_discuss$UserProfile msg_user = new nearfield_discuss$UserProfile();
}
