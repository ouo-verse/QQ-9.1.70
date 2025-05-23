package tencent.im.nearfield_group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_group$ReqExit extends MessageMicro<nearfield_group$ReqExit> {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_head", "uint64_group_code"}, new Object[]{null, 0L}, nearfield_group$ReqExit.class);
    public nearfield_group$BusiReqHead msg_head = new nearfield_group$BusiReqHead();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
}
