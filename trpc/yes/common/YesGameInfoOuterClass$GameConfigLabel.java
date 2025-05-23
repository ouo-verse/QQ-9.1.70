package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GameConfigLabel extends MessageMicro<YesGameInfoOuterClass$GameConfigLabel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"text", "text_hue", "icon", "desc"}, new Object[]{"", "", "", ""}, YesGameInfoOuterClass$GameConfigLabel.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField text_hue = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
