package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Hotspots$HotSpotReq extends MessageMicro<Hotspots$HotSpotReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"intervalFromLastReqFeedList", "curFeedPosition", "attachInfo"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY}, Hotspots$HotSpotReq.class);
    public final PBInt64Field intervalFromLastReqFeedList = PBField.initInt64(0);
    public final PBInt64Field curFeedPosition = PBField.initInt64(0);
    public final PBBytesField attachInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
