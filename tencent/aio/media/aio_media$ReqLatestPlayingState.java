package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class aio_media$ReqLatestPlayingState extends MessageMicro<aio_media$ReqLatestPlayingState> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"enum_aio_type", "uint64_id", "uint32_version"}, new Object[]{1, 0L, 0}, aio_media$ReqLatestPlayingState.class);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
}
