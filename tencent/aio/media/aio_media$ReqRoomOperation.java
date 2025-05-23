package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$ReqRoomOperation extends MessageMicro<aio_media$ReqRoomOperation> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"enum_aio_type", "uint64_id", "enum_room_operation", "enum_media_type"}, new Object[]{1, 0L, 1, 1}, aio_media$ReqRoomOperation.class);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBEnumField enum_room_operation = PBField.initEnum(1);
    public final PBEnumField enum_media_type = PBField.initEnum(1);
}
