package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$GetAvatarInfoRequest extends MessageMicro<AvatarMallMessage$GetAvatarInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"req_msg"}, new Object[]{""}, AvatarMallMessage$GetAvatarInfoRequest.class);
    public final PBStringField req_msg = PBField.initString("");
}
