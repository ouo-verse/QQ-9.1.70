package tencent.aio.video;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_video$RspGetOpenIdByUin extends MessageMicro<aio_video$RspGetOpenIdByUin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"err_info", "open_id"}, new Object[]{null, ByteStringMicro.EMPTY}, aio_video$RspGetOpenIdByUin.class);
    public aio_video$ErrInfo err_info = new aio_video$ErrInfo();
    public final PBBytesField open_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
