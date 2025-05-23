package tencent.aio.video;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_video$ReqGetOpenIdByUin extends MessageMicro<aio_video$ReqGetOpenIdByUin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"app_id", "target_uin"}, new Object[]{0, 0L}, aio_video$ReqGetOpenIdByUin.class);
    public final PBUInt32Field app_id = PBField.initUInt32(0);
    public final PBUInt64Field target_uin = PBField.initUInt64(0);
}
