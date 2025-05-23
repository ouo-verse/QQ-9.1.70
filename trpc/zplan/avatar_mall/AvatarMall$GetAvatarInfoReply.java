package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMall$GetAvatarInfoReply extends MessageMicro<AvatarMall$GetAvatarInfoReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rsp_msg"}, new Object[]{""}, AvatarMall$GetAvatarInfoReply.class);
    public final PBStringField rsp_msg = PBField.initString("");
}
