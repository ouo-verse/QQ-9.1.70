package tencent.im.cs.face2face_file;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class face2face_file$msg extends MessageMicro<face2face_file$msg> {
    public static final int RESULT_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"version", "result"}, new Object[]{0, 0}, face2face_file$msg.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
}
