package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import trpc.zplan.CsCommon$AvatarTemplateConfig;
import trpc.zplan.CsCommon$RspHeader;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$GetAvatarInfoTemplatesReply extends MessageMicro<AvatarMallMessage$GetAvatarInfoTemplatesReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rsp_header", "avatar_template_config"}, new Object[]{null, null}, AvatarMallMessage$GetAvatarInfoTemplatesReply.class);
    public CsCommon$RspHeader rsp_header = new CsCommon$RspHeader();
    public CsCommon$AvatarTemplateConfig avatar_template_config = new CsCommon$AvatarTemplateConfig();
}
