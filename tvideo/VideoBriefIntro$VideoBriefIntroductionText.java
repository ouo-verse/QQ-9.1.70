package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class VideoBriefIntro$VideoBriefIntroductionText extends MessageMicro<VideoBriefIntro$VideoBriefIntroductionText> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "description"}, new Object[]{"", ""}, VideoBriefIntro$VideoBriefIntroductionText.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField description = PBField.initString("");
}
