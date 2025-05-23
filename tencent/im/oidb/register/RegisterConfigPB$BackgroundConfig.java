package tencent.im.oidb.register;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class RegisterConfigPB$BackgroundConfig extends MessageMicro<RegisterConfigPB$BackgroundConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", "url", "sort_weight"}, new Object[]{0, "", 0}, RegisterConfigPB$BackgroundConfig.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f436024id = PBField.initInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field sort_weight = PBField.initInt32(0);
}
