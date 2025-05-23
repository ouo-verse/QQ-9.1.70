package tencent.aio.video;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_video$RspGetUinByOpenId extends MessageMicro<aio_video$RspGetUinByOpenId> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"err_info", "uin"}, new Object[]{null, 0L}, aio_video$RspGetUinByOpenId.class);
    public aio_video$ErrInfo err_info = new aio_video$ErrInfo();
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
