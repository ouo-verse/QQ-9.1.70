package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$CancelCollectRequest extends MessageMicro<AvatarMallMessage$CancelCollectRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"item_id"}, new Object[]{0}, AvatarMallMessage$CancelCollectRequest.class);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
}
