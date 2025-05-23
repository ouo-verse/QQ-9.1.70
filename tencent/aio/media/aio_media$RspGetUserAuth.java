package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class aio_media$RspGetUserAuth extends MessageMicro<aio_media$RspGetUserAuth> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_result", "bool_allow_member_start"}, new Object[]{null, Boolean.TRUE}, aio_media$RspGetUserAuth.class);
    public aio_media$ResultInfo msg_result = new aio_media$ResultInfo();
    public final PBBoolField bool_allow_member_start = PBField.initBool(true);
}
