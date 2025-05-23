package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$ReqMediaOperation extends MessageMicro<aio_media$ReqMediaOperation> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"enum_aio_type", "uint64_id", "enum_operation", "enum_play_mode", "enum_cut_type"}, new Object[]{1, 0L, 1, 1, 1}, aio_media$ReqMediaOperation.class);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBEnumField enum_operation = PBField.initEnum(1);
    public final PBEnumField enum_play_mode = PBField.initEnum(1);
    public final PBEnumField enum_cut_type = PBField.initEnum(1);
}
