package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MallSendGift$RspHeader extends MessageMicro<MallSendGift$RspHeader> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48}, new String[]{"func_ret", "msg", "request_id", "trace_id", "client_seq", "frequency"}, new Object[]{0, "", 0, 0L, 0L, 0}, MallSendGift$RspHeader.class);
    public final PBInt32Field func_ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f437272msg = PBField.initString("");
    public final PBUInt32Field request_id = PBField.initUInt32(0);
    public final PBUInt64Field trace_id = PBField.initUInt64(0);
    public final PBUInt64Field client_seq = PBField.initUInt64(0);
    public final PBUInt32Field frequency = PBField.initUInt32(0);
}
