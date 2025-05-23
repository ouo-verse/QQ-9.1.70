package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MutualMarkCard$ReqBody extends MessageMicro<MutualMarkCard$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"friend_uin"}, new Object[]{0L}, MutualMarkCard$ReqBody.class);
    public final PBUInt64Field friend_uin = PBField.initUInt64(0);
}
