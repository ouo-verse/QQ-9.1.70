package trpc.yes.common;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$TinyIdUinPair extends MessageMicro<UserProxyCmdOuterClass$TinyIdUinPair> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{INetChannelCallback.KEY_TINY_ID, "uid"}, new Object[]{0L, 0L}, UserProxyCmdOuterClass$TinyIdUinPair.class);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
