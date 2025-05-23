package tencent.im.cs.modifyexamine;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class modifyexamine$ReqBody extends MessageMicro<modifyexamine$ReqBody> {
    public static final int SKEY_FIELD_NUMBER = 2;
    public static final int UINT64_GC_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_gc", "skey"}, new Object[]{0L, ""}, modifyexamine$ReqBody.class);
    public final PBUInt64Field uint64_gc = PBField.initUInt64(0);
    public final PBStringField skey = PBField.initString("");
}
