package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class ActivityOuterClass$EnterShareLiveRoomReq extends MessageMicro<ActivityOuterClass$EnterShareLiveRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"param"}, new Object[]{ByteStringMicro.EMPTY}, ActivityOuterClass$EnterShareLiveRoomReq.class);
    public final PBBytesField param = PBField.initBytes(ByteStringMicro.EMPTY);
}
