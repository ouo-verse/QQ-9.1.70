package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperAvatarAIData$AvatarAIEvent extends MessageMicro<SuperAvatarAIData$AvatarAIEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, SuperAvatarAIData$AvatarAIEvent.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
