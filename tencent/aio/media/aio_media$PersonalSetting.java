package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class aio_media$PersonalSetting extends MessageMicro<aio_media$PersonalSetting> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_theme_id"}, new Object[]{0}, aio_media$PersonalSetting.class);
    public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
}
