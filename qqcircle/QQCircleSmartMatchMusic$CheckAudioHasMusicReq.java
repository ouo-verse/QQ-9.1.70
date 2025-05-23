package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$CheckAudioHasMusicReq extends MessageMicro<QQCircleSmartMatchMusic$CheckAudioHasMusicReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"audio"}, new Object[]{ByteStringMicro.EMPTY}, QQCircleSmartMatchMusic$CheckAudioHasMusicReq.class);
    public final PBBytesField audio = PBField.initBytes(ByteStringMicro.EMPTY);
}
