package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class ShadowAIGCAvatar$GetStylePicturesReply extends MessageMicro<ShadowAIGCAvatar$GetStylePicturesReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"style_pictures", "extra", "with_glasses", "gender"}, new Object[]{null, "", Boolean.FALSE, ""}, ShadowAIGCAvatar$GetStylePicturesReply.class);
    public final PBRepeatMessageField<ShadowAIGCAvatar$StylePictureInfo> style_pictures = PBField.initRepeatMessage(ShadowAIGCAvatar$StylePictureInfo.class);
    public final PBStringField extra = PBField.initString("");
    public final PBBoolField with_glasses = PBField.initBool(false);
    public final PBStringField gender = PBField.initString("");
}
