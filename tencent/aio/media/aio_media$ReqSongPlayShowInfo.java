package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class aio_media$ReqSongPlayShowInfo extends MessageMicro<aio_media$ReqSongPlayShowInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_id"}, new Object[]{0L}, aio_media$ReqSongPlayShowInfo.class);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
}
