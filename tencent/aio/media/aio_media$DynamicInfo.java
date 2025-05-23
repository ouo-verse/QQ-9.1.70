package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$DynamicInfo extends MessageMicro<aio_media$DynamicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 32}, new String[]{"uint32_user_num", "rpt_uint64_uins", "int32_media_type"}, new Object[]{0, 0L, 0}, aio_media$DynamicInfo.class);
    public final PBUInt32Field uint32_user_num = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBInt32Field int32_media_type = PBField.initInt32(0);
}
