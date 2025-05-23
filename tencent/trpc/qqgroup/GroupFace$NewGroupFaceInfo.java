package tencent.trpc.qqgroup;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupFace$NewGroupFaceInfo extends MessageMicro<GroupFace$NewGroupFaceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"sub_cmd", "clip_info"}, new Object[]{0, null}, GroupFace$NewGroupFaceInfo.class);
    public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
    public GroupFace$ClipInfo clip_info = new GroupFace$ClipInfo();
}
