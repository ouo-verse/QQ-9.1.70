package tencent.im.nearfield_group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_group$ReqJoinGroup extends MessageMicro<nearfield_group$ReqJoinGroup> {
    public static final int BYTES_DISTANCE_FIELD_NUMBER = 4;
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
    public static final int UINT64_OWNER_UIN_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"msg_head", "uint64_group_code", "uint64_owner_uin", "bytes_distance"}, new Object[]{null, 0L, 0L, ByteStringMicro.EMPTY}, nearfield_group$ReqJoinGroup.class);
    public nearfield_group$BusiReqHead msg_head = new nearfield_group$BusiReqHead();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_distance = PBField.initBytes(ByteStringMicro.EMPTY);
}
