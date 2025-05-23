package tencent.im.oidb.cmd0x1122;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class oidb_0x1122$Permission extends MessageMicro<oidb_0x1122$Permission> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField only_chat = PBField.initBool(false);
    public final PBBoolField qzone_not_watch = PBField.initBool(false);
    public final PBBoolField qzone_not_watched = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{800, 808, 816}, new String[]{"only_chat", "qzone_not_watch", "qzone_not_watched"}, new Object[]{bool, bool, bool}, oidb_0x1122$Permission.class);
    }
}
