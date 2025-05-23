package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes30.dex */
public final class SafeOuterClass$GetUserPrivIdRsp extends MessageMicro<SafeOuterClass$GetUserPrivIdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"priv_id_list"}, new Object[]{0}, SafeOuterClass$GetUserPrivIdRsp.class);
    public final PBRepeatField<Integer> priv_id_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}
