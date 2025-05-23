package trpc.qlive.trpc_fans_group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcFansGroupOuterClass$ModifyGroupNameReq extends MessageMicro<TrpcFansGroupOuterClass$ModifyGroupNameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"new_group_name"}, new Object[]{""}, TrpcFansGroupOuterClass$ModifyGroupNameReq.class);
    public final PBStringField new_group_name = PBField.initString("");
}
