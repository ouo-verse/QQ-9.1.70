package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class VideoBriefIntro$VideoBriefIntroductionPoster extends MessageMicro<VideoBriefIntro$VideoBriefIntroductionPoster> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"img_url", "title", "rating", "first_label_info", "sub_label_info", "third_label_info", "hotval"}, new Object[]{"", "", "", "", "", "", ""}, VideoBriefIntro$VideoBriefIntroductionPoster.class);
    public final PBStringField img_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField rating = PBField.initString("");
    public final PBStringField first_label_info = PBField.initString("");
    public final PBStringField sub_label_info = PBField.initString("");
    public final PBStringField third_label_info = PBField.initString("");
    public final PBStringField hotval = PBField.initString("");
}
