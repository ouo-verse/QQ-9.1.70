package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$ReqCreateRoom extends MessageMicro<aio_media$ReqCreateRoom> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"enum_aio_type", "uint64_id", "str_song_id", "enum_media_type"}, new Object[]{1, 0L, "", 1}, aio_media$ReqCreateRoom.class);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBStringField str_song_id = PBField.initString("");
    public final PBEnumField enum_media_type = PBField.initEnum(1);
}
