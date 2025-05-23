package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Hotspots$HotSpotRsp extends MessageMicro<Hotspots$HotSpotRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"needUpdate", "attachInfo"}, new Object[]{Boolean.FALSE, ByteStringMicro.EMPTY}, Hotspots$HotSpotRsp.class);
    public final PBBoolField needUpdate = PBField.initBool(false);
    public final PBBytesField attachInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
