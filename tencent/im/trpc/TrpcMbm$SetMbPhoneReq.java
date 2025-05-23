package tencent.im.trpc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class TrpcMbm$SetMbPhoneReq extends MessageMicro<TrpcMbm$SetMbPhoneReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"token"}, new Object[]{ByteStringMicro.EMPTY}, TrpcMbm$SetMbPhoneReq.class);
    public final PBBytesField token = PBField.initBytes(ByteStringMicro.EMPTY);
}
