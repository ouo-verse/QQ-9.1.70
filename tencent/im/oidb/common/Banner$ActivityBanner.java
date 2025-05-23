package tencent.im.oidb.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Banner$ActivityBanner extends MessageMicro<Banner$ActivityBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"image_link", "jump_link", "title", "sub_title"}, new Object[]{"", "", "", ""}, Banner$ActivityBanner.class);
    public final PBStringField image_link = PBField.initString("");
    public final PBStringField jump_link = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
}
