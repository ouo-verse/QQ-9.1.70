package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MutualMarkCard$Guide extends MessageMicro<MutualMarkCard$Guide> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"desc", "state", "url"}, new Object[]{"", null, ""}, MutualMarkCard$Guide.class);
    public final PBStringField desc = PBField.initString("");
    public mutualmark$State state = new mutualmark$State();
    public final PBStringField url = PBField.initString("");
}
