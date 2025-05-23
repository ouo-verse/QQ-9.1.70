package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$BatchGetUidByTinyIdRsp extends MessageMicro<UserProxyCmdOuterClass$BatchGetUidByTinyIdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tiny_id_uid_pair_list"}, new Object[]{null}, UserProxyCmdOuterClass$BatchGetUidByTinyIdRsp.class);
    public final PBRepeatMessageField<UserProxyCmdOuterClass$TinyIdUinPair> tiny_id_uid_pair_list = PBField.initRepeatMessage(UserProxyCmdOuterClass$TinyIdUinPair.class);
}
