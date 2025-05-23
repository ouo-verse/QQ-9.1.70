package tencent.im.trpc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcMbm$UserMbmInfo extends MessageMicro<TrpcMbm$UserMbmInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"uin", "src_acode", "src_phone", "dst_acode", "dst_phone"}, new Object[]{0L, 0, "", 0, ""}, TrpcMbm$UserMbmInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field src_acode = PBField.initUInt32(0);
    public final PBStringField src_phone = PBField.initString("");
    public final PBUInt32Field dst_acode = PBField.initUInt32(0);
    public final PBStringField dst_phone = PBField.initString("");
}
