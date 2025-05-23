package trpc.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CsCommon$RspHeader extends MessageMicro<CsCommon$RspHeader> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"func_ret", "msg"}, new Object[]{0, ""}, CsCommon$RspHeader.class);
    public final PBInt32Field func_ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f437271msg = PBField.initString("");
}
