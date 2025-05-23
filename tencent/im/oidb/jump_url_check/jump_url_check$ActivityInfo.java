package tencent.im.oidb.jump_url_check;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class jump_url_check$ActivityInfo extends MessageMicro<jump_url_check$ActivityInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"item_pkg_name", "item_name"}, new Object[]{"", ""}, jump_url_check$ActivityInfo.class);
    public final PBStringField item_pkg_name = PBField.initString("");
    public final PBStringField item_name = PBField.initString("");
}
