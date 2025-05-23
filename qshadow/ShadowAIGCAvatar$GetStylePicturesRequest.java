package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class ShadowAIGCAvatar$GetStylePicturesRequest extends MessageMicro<ShadowAIGCAvatar$GetStylePicturesRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"user_pic_url", "with_glasses", "gender", "style", "extra"}, new Object[]{"", Boolean.FALSE, "", "", ""}, ShadowAIGCAvatar$GetStylePicturesRequest.class);
    public final PBStringField user_pic_url = PBField.initString("");
    public final PBBoolField with_glasses = PBField.initBool(false);
    public final PBStringField gender = PBField.initString("");
    public final PBStringField style = PBField.initString("");
    public final PBStringField extra = PBField.initString("");
}
