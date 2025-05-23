package trpc.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CsCommon$AvatarTemplateInfo extends MessageMicro<CsCommon$AvatarTemplateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_used", "avatar_info"}, new Object[]{Boolean.FALSE, null}, CsCommon$AvatarTemplateInfo.class);
    public final PBBoolField is_used = PBField.initBool(false);
    public CsCommon$AvatarInfo avatar_info = new CsCommon$AvatarInfo();
}
