package tencent.im.troop.findtroop;

import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SignChecker$SignRequest extends MessageMicro<SignChecker$SignRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 64}, new String[]{"appid", "app_type", MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, "src", "raw_url", "http_method", "post_body", "is_need_plaintext"}, new Object[]{0L, 0, "", 0, "", "", "", Boolean.FALSE}, SignChecker$SignRequest.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBStringField plaintext = PBField.initString("");
    public final PBUInt32Field src = PBField.initUInt32(0);
    public final PBStringField raw_url = PBField.initString("");
    public final PBStringField http_method = PBField.initString("");
    public final PBStringField post_body = PBField.initString("");
    public final PBBoolField is_need_plaintext = PBField.initBool(false);
}
