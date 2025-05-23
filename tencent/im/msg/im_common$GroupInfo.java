package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_common$GroupInfo extends MessageMicro<im_common$GroupInfo> {
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int GROUP_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_id", "group_type"}, new Object[]{0L, 1}, im_common$GroupInfo.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBEnumField group_type = PBField.initEnum(1);
}
