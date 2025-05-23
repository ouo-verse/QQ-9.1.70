package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMall$GetAvatarInfoRequest extends MessageMicro<AvatarMall$GetAvatarInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"req_msg"}, new Object[]{""}, AvatarMall$GetAvatarInfoRequest.class);
    public final PBStringField req_msg = PBField.initString("");
}
