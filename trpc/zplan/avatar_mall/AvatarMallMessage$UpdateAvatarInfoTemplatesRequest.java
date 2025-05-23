package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.zplan.CsCommon$AvatarTemplateConfig;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$UpdateAvatarInfoTemplatesRequest extends MessageMicro<AvatarMallMessage$UpdateAvatarInfoTemplatesRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"avatar_template_config", "seq_id"}, new Object[]{null, 0}, AvatarMallMessage$UpdateAvatarInfoTemplatesRequest.class);
    public CsCommon$AvatarTemplateConfig avatar_template_config = new CsCommon$AvatarTemplateConfig();
    public final PBUInt32Field seq_id = PBField.initUInt32(0);
}
