package tencent.trpc.qqgroup;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupFace$UploadReq extends MessageMicro<GroupFace$UploadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48}, new String[]{"proto_ver", "group_uin", "info", "group_sign", "img_type", "is_from_pc"}, new Object[]{0, 0L, null, ByteStringMicro.EMPTY, 0, 0}, GroupFace$UploadReq.class);
    public final PBUInt32Field proto_ver = PBField.initUInt32(0);
    public final PBUInt64Field group_uin = PBField.initUInt64(0);
    public GroupFace$NewGroupFaceInfo info = new GroupFace$NewGroupFaceInfo();
    public final PBBytesField group_sign = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField img_type = PBField.initEnum(0);
    public final PBUInt32Field is_from_pc = PBField.initUInt32(0);
}
