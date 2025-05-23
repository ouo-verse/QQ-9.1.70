package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_common$Signature extends MessageMicro<im_common$Signature> {
    public static final int KEY_TYPE_FIELD_NUMBER = 1;
    public static final int SESSION_APP_ID_FIELD_NUMBER = 2;
    public static final int SESSION_KEY_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"key_type", "session_app_id", "session_key"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, im_common$Signature.class);
    public final PBUInt32Field key_type = PBField.initUInt32(0);
    public final PBUInt32Field session_app_id = PBField.initUInt32(0);
    public final PBBytesField session_key = PBField.initBytes(ByteStringMicro.EMPTY);
}
