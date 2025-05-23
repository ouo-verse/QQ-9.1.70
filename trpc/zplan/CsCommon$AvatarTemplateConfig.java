package trpc.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CsCommon$AvatarTemplateConfig extends MessageMicro<CsCommon$AvatarTemplateConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"avatar_template_config"}, new Object[]{null}, CsCommon$AvatarTemplateConfig.class);
    public final PBRepeatMessageField<CsCommon$AvatarTemplateInfo> avatar_template_config = PBField.initRepeatMessage(CsCommon$AvatarTemplateInfo.class);
}
