package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class VideoBriefIntro$Star extends MessageMicro<VideoBriefIntro$Star> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"name", "image_url", "star_id"}, new Object[]{"", "", 0L}, VideoBriefIntro$Star.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField image_url = PBField.initString("");
    public final PBInt64Field star_id = PBField.initInt64(0);
}
