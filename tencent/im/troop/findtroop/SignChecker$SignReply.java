package tencent.im.troop.findtroop;

import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SignChecker$SignReply extends MessageMicro<SignChecker$SignReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"sign", MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY}, new Object[]{"", ""}, SignChecker$SignReply.class);
    public final PBStringField sign = PBField.initString("");
    public final PBStringField plaintext = PBField.initString("");
}
