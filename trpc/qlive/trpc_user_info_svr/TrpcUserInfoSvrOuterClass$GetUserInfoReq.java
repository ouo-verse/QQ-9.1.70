package trpc.qlive.trpc_user_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcUserInfoSvrOuterClass$GetUserInfoReq extends MessageMicro<TrpcUserInfoSvrOuterClass$GetUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uid", "fileds"}, new Object[]{0L, 0}, TrpcUserInfoSvrOuterClass$GetUserInfoReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBRepeatField<Integer> fileds = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
