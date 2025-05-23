package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RegisterExt$RegisterExtData extends MessageMicro<RegisterExt$RegisterExtData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"set_status_scene", "first_login_after_update", "set_status_has_avatar"}, new Object[]{0, 0, 0}, RegisterExt$RegisterExtData.class);
    public final PBUInt32Field set_status_scene = PBField.initUInt32(0);
    public final PBUInt32Field first_login_after_update = PBField.initUInt32(0);
    public final PBUInt32Field set_status_has_avatar = PBField.initUInt32(0);
}
