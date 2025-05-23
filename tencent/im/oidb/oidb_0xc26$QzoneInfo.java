package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$QzoneInfo extends MessageMicro<oidb_0xc26$QzoneInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"icon_url", "text", "hit_exp_group"}, new Object[]{"", "", 0}, oidb_0xc26$QzoneInfo.class);
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBEnumField hit_exp_group = PBField.initEnum(0);
}
