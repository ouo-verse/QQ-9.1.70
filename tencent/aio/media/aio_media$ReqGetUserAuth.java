package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$ReqGetUserAuth extends MessageMicro<aio_media$ReqGetUserAuth> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_id"}, new Object[]{0L}, aio_media$ReqGetUserAuth.class);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
}
