package tencent.im.troop.findtroop;

import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SignChecker$CheckSignReply extends MessageMicro<SignChecker$CheckSignReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{MessageForRichState.SIGN_MSG_PLAIN_TEXT_KEY, "ret", "msg"}, new Object[]{"", 0, ""}, SignChecker$CheckSignReply.class);
    public final PBStringField plaintext = PBField.initString("");
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436055msg = PBField.initString("");
}
